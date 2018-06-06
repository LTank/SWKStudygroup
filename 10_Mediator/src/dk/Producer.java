package dk;

import java.util.Random;

public class Producer implements Runnable{

    private MediatingDiamond diamonds;

    public Producer(MediatingDiamond diamonds) {
        this.diamonds = diamonds;
    }

    @Override
    public void run() {

        while (true) {
            diamonds.increment(); // Produces diamond if less than 5
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000)); // Doing this to slow down our prints
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
