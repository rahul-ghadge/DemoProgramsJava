package com.demo.program.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        myCompletableFuture();
        runAsync();
    }

    private static void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
//            return "Completable future";
        });

        String value = completableFuture.get();
        completableFuture.complete(value);
        System.out.println("---> " + value);
        completableFuture.cancel(true);
    }

    private static void myCompletableFuture() {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        completableFuture
                .thenApply(s -> s + " World")
                .thenAccept(System.out::println);
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        Hello World
//        Thread name: ForkJoinPool.commonPool-worker-1