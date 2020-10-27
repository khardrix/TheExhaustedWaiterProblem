import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Waiter extends Thread {
    private volatile Semaphore Nap;
    private volatile Semaphore Servicing;
    private static int customerServiced = 0;

    public Waiter(Semaphore Nap, Semaphore Servicing) {
        this.Nap = Nap;
        this.Servicing = Servicing;
    }


    public void run(){
        Random dice = new Random();
        do {
            int sleepDuration = 50 + dice.nextInt(450);
            try{
                if(!Nap.tryAcquire()) {
                    System.out.println("Waiter is sleeping");
                    Nap.acquire();
                }
                System.out.println("Waiter is now awake");
                customerServiced++;
                sleep(sleepDuration);
                Servicing.release();
                System.out.println("Waiter is servicing customer " + customerServiced);

            }catch(Exception e) {
                System.out.println(e);
            }
        }while(true);
    }
}
