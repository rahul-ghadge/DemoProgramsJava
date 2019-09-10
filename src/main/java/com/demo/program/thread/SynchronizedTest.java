package com.demo.program.thread;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedTest {

    static List<Integer> list = new ArrayList<>();

    public static void process() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                addToList(i);
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                addToList(i);
            }
        });


        t1.start();
        t2.start();
    }


    static synchronized void addToList(int i) {
        list.add(i);
    }


    public static void main(String[] args) {
        process();
        System.out.println(list.size());
    }
}
