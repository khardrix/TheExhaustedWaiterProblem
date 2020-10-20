// IMPORTS of Java needed tools and plug-ins
import java.lang.Thread;
import java.util.concurrent.Semaphore;


public class Customer extends Thread {


    private volatile Semaphore Door = new Semaphore(15, true);
    private volatile Semaphore Nap = new Semaphore(0, true);
    private volatile Semaphore Servicing = new Semaphore(0, true);
    private volatile ThreadGroup rushhour = new ThreadGroup("rushhour group");
    private volatile ThreadGroup showtime = new ThreadGroup("showtime group");


    private static int custCount = 0;


    public Customer (Semaphore Nap, Semaphore Servicing, Semaphore Door, ThreadGroup threadGroup) {
        this.Nap = Nap;
        this.Servicing = Servicing;
        this.Door = Door;
        threadGroup = threadGroup;
    }



    @Override
    public void run() {
        Nap.release();

        Servicing.tryAcquire();

        Door.release();
    }
}
