// IMPORTS of needed tools and plug-ins
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
            System.out.println("Customer attempting to enter restaurant");
            Door.acquire();
            System.out.println("Customer " + (custCount + 1) + " has entered restaurant and is seated");
            Nap.release();
            System.out.println("Customer " + (custCount + 1) +  " is waiting for the waiter");
            countmutex.acquire();
            custCount++;
            countmutex.release();
            Servicing.acquire();
            System.out.println("Customer " + custCount + " has been served");
            Door.release();
            System.out.println("Customer " + custCount + " is leaving");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

