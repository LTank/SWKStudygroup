package dk;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Create tasks
        Runnable printA = new PrintChar('a', 1000);
        Runnable printB = new PrintChar('b', 1000);
        Runnable printC = new PrintChar('c', 1000);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(printC);

        // Set priority
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(7);
        thread3.setPriority(Thread.NORM_PRIORITY);

        // "Start" threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
// The task for printing a character a specified number of tim
class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The number of times to repeat
    /** Construct a task with a specified character and number o
     * times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }
    @Override /** Override the run() method to tell the system
     * what task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint + " ");
        }
    }
}
