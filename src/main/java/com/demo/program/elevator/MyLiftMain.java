package com.demo.program.elevator;

public class MyLiftMain {

    public static void main(String[] args) {
        
    	System.out.println("Welcome to MyLift");
        
    	// RequestListenerThread to read requested floor and add to Set
        Thread requestListenerThread = new Thread(new RequestListener(),
                "RequestListenerThread");
        
        // RequestProcessorThread to read Set and process requested floor
        Thread requestProcessorThread = new Thread(new RequestProcessor(),
                "RequestProcessorThread");

        Elevator.getInstance().setRequestProcessorThread(requestProcessorThread);

        requestListenerThread.start();
        requestProcessorThread.start();

    }
}
