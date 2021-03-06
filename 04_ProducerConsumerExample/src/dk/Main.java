package dk;

public class Main {

    public static void main(String[] args){

        // Our 'trade' object & mediator class
        Diamond diamonds = new Diamond();

        // Consumes diamonds
        Consumer consumer = new Consumer(diamonds);

        // Produces diamonds
        Producer producer = new Producer(diamonds);

        // Sets up our two threads
        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);
        Thread producerThread2 = new Thread(producer);

        // Starts our threads
        producerThread.start();
        producerThread2.start();
        consumerThread.start();

    }
}
