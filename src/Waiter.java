import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Waiter extends Thread {
    private volatile Semaphore Nap;
    private volatile Semaphore Servicing;

    public Waiter(Semaphore Nap, Semaphore Servicing) {
        this.Nap = Nap;
        this.Servicing = Servicing;
    }


    public void run(){
        Random dice = new Random();
        int sleepDuration = 50 + dice.nextInt(450);
        do {
            try{
                if(!Nap.tryAcquire()){
                    Nap.acquire();
                    sleep(sleepDuration);
                    Servicing.release();
            }
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }while(true);
    }
}
