import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.lang.ThreadGroup;

public class Customer extends Thread {
    private volatile Semaphore Door;
    private volatile Semaphore Nap;
    private volatile Semaphore Servicing;

    private static int custCount = 0;
    private static Semaphore countmutex = new Semaphore(1, true);

    public Customer (Semaphore Nap, Semaphore Servicing, Semaphore Door, ThreadGroup threadGroup) {
        super(threadGroup, "customer");
        this.Nap = Nap;
        this.Servicing = Servicing;
        this.Door = Door;
    }


    public void run() {
        try {
            Door.acquire();
            Nap.release();
            Servicing.acquire();
            Door.release();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

