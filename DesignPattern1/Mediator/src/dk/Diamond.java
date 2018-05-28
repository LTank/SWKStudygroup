package dk;

// Our Mediator class because Consumer & Producer uses this class to communicate with each other.
public class Diamond {
    private int count = 0;

    // Synchronized secures, that only one thread will be incrementing diamonds, if more
    // threads are set to do the same task.
    public synchronized void increment() {
        try {
            while (count >= 5) {
                wait(); // Releases and wait for a notify/notifyAll
            }
            count = count + 1;
            System.out.println("Inc: " + count + " ");
            notifyAll(); // Safer than notify, because notifyAll notifies... all and not just one.
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public synchronized void decrement() {
        try {
            while (count <= 0) {
                wait(); // Waits and listens for notifyAll
            }
            count = count - 1;
            System.out.println("Dec: " + count + " ");
            notifyAll();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
