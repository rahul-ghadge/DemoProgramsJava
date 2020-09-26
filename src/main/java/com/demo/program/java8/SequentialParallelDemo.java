package com.demo.program.java8;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialParallelDemo {

    public static void main(String[] args) {

        System.out.println("Available Processors :: " + Runtime.getRuntime().availableProcessors());

        String str[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println("\n-------------------- Sequential Run --------------------");
        printStream(Arrays.stream(str).sequential());

        System.out.println("\n\n-------------------- Parallel Run --------------------");
        printStream(Arrays.stream(str).parallel());


        System.out.println("\n\n-------------------- Sequential Sum --------------------");
        System.out.println("Seq Execution in millis :: " + checkPerformance(SequentialParallelDemo::seqSum, 25));
        System.out.println("Parallel Execution in millis :: " + checkPerformance(SequentialParallelDemo::parallelSum, 25));


        System.out.println("\n\n-------------------- Sequential Worse case Performance issue --------------------");
        List<Integer> list = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
        worseCaseParallelStreamForSeq(list);
        worseCaseParallelStreamForPar(list);


        System.out.println("\n\n-------------------- Sequential Worse case Data issue --------------------");
        Calculation calculation = new Calculation();

        IntStream.rangeClosed(0, 2000).forEach(calculation::calculate);
        System.out.println("Result in Seq :: " + calculation.getTotal());

        IntStream.rangeClosed(0, 2000).parallel().forEach(calculation::calculate);
        System.out.println("Result in Parallel :: " + calculation.getTotal());

    }


    static void printStream(Stream<String> stream) {
        try {
            // Sleeping thread for 1 sec
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " Value :: " + s + " - thread :: " + Thread.currentThread().getName());
            try {
                // Sleeping thread for 200 milli sec
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    // Performance check for Sequential and Parallel Streams
    static long checkPerformance(Supplier<Integer> supplier, int noOfTimes) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < noOfTimes; i++) {
            supplier.get();
        }
        return System.currentTimeMillis() - startTime;
    }

    static int seqSum() {
        return IntStream.rangeClosed(1, 10_00_00_000).sum();
    }

    static int parallelSum() {
        return IntStream.rangeClosed(1, 10_00_00_000).parallel().sum();
    }
    // Performance check ends here




    static void worseCaseParallelStreamForSeq(List<Integer> list) {

        long start = System.currentTimeMillis();
        int total = list.stream().reduce(0, (x, y) -> x + y);

        System.out.println("Sequential Duration :: " + (System.currentTimeMillis() - start));
        System.out.println("Sequential Sum :: " + total);

    }

    static void worseCaseParallelStreamForPar(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.parallelStream().reduce(0, (x, y) -> x + y);

        System.out.println("Parallel Duration :: " + (System.currentTimeMillis() - start));
        System.out.println("Parallel Sum :: " + total);
    }


}


class Calculation {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void calculate(int in) {
        total += in;
    }
}






//        ---------------------------------------------------------------
//        Output
//        ---------------------------------------------------------------
//        Available Processors :: 4
//
//        -------------------- Sequential Run --------------------
//        23:35:16.943 Value :: 1 - thread :: main
//        23:35:17.144 Value :: 2 - thread :: main
//        23:35:17.345 Value :: 3 - thread :: main
//        23:35:17.545 Value :: 4 - thread :: main
//        23:35:17.745 Value :: 5 - thread :: main
//        23:35:17.946 Value :: 6 - thread :: main
//        23:35:18.146 Value :: 7 - thread :: main
//        23:35:18.346 Value :: 8 - thread :: main
//        23:35:18.547 Value :: 9 - thread :: main
//        23:35:18.747 Value :: 10 - thread :: main
//
//
//        -------------------- Parallel Run --------------------
//        23:35:19.959 Value :: 7 - thread :: main
//        23:35:19.959 Value :: 3 - thread :: ForkJoinPool.commonPool-worker-1
//        23:35:19.959 Value :: 2 - thread :: ForkJoinPool.commonPool-worker-3
//        23:35:19.959 Value :: 5 - thread :: ForkJoinPool.commonPool-worker-2
//        23:35:20.159 Value :: 4 - thread :: ForkJoinPool.commonPool-worker-1
//        23:35:20.159 Value :: 9 - thread :: ForkJoinPool.commonPool-worker-2
//        23:35:20.159 Value :: 6 - thread :: main
//        23:35:20.159 Value :: 1 - thread :: ForkJoinPool.commonPool-worker-3
//        23:35:20.360 Value :: 8 - thread :: ForkJoinPool.commonPool-worker-1
//        23:35:20.360 Value :: 10 - thread :: ForkJoinPool.commonPool-worker-2
//
//
//        -------------------- Sequential Sum --------------------
//        Seq Execution in millis :: 1139
//        Parallel Execution in millis :: 404
//
//
//        -------------------- Sequential Worse case Performance issue --------------------
//        Sequential Duration :: 3
//        Sequential Sum :: 50005000
//        Parallel Duration :: 3
//        Parallel Sum :: 50005000
//
//
//        -------------------- Sequential Worse case Data issue --------------------
//        Result in Seq :: 2001000
//        Result in Parallel :: 3819034
