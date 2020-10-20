import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Waiter extends Thread {


    private volatile Semaphore Nap;
    private volatile Semaphore Servicing;
    //  private static int custCount = 0;


    public Waiter(Semaphore Nap, Semaphore Servicing) {
        Nap = Nap;
        Servicing = Servicing;

    }




    public void run(){

        do {
            try{
                Random dice = new Random();
                int sleepDuration = 50 + dice.nextInt(450);

                if(!Nap.tryAcquire(sleepDuration, TimeUnit.MILLISECONDS)){
                    Nap.acquire();
                }
            }catch(InterruptedException e) {
                e.printStackTrace();
            }

        }while(true);
    }
}
