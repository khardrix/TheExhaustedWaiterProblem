import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.lang.ThreadGroup;

public class Customer extends Thread {
    private volatile Semaphore Door;
    private volatile Semaphore Nap;
    private volatile Semaphore Servicing;

    public Customer (Semaphore Nap, Semaphore Servicing, Semaphore Door, ThreadGroup threadGroup) {
        super(threadGroup, null, null);
        this.Nap = Nap;
        this.Servicing = Servicing;
        this.Door = Door;
    }

    // @Override
    public void run() {
        Nap.release();
        // Servicing.acquire();
        Door.release();
    }
}

