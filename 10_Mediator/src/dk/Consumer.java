package dk;

import java.util.Random;

public class Consumer implements Runnable {

    private MediatingDiamond diamonds;

    public Consumer(MediatingDiamond diamonds) {
        this.diamonds = diamonds;
    }

    @Override
    public void run() {
        while (true) {
            diamonds.decrement(); // Consumes diamond if more than 0
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000)); // Doing this to slow down our prints
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
