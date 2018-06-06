package dk;

// Our Mediator class because Consumer & Producer uses this class to communicate with each other.
public class MediatingDiamond {
    private int count = 0;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[34m";

    // Synchronized secures, that only one thread will be incrementing diamonds, if more
    // threads are set to do the same task.
    public synchronized void increment() {
        try {
            while (count > 4) {
                wait(); // Releases and wait for a notify/notifyAll
            }
            count = count + 1;
            System.out.println(ANSI_GREEN + "GiveDiamond: " + count + " ");
            notifyAll(); // Safer than notify, because notifyAll notifies... all and not just one.
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public synchronized void decrement() {
        try {
            while (count < 2) {
                wait(); // Waits and listens for notifyAll
            }
            count = count - 2;
            System.out.println(ANSI_RED + "TakeDiamond: " + count + " ");
            notifyAll();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
