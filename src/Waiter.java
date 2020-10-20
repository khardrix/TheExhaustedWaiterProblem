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
                    sleep(sleepDuration);   // may need moved out of if statement
                    Servicing.release();    // may need moved out of if statement
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }while(true);
    }
}
