// IMPORTS of Java needed tools and plug-ins
import java.lang.Thread;
import java.util.concurrent.Semaphore;


public class Customer extends Thread {


    private static int custCount = 0;


    public Customer (Semaphore Nap, Semaphore Servicing, Semaphore Door, ThreadGroup object) {

    }



    @Override
    public void run() {
        try {
            super.run();
            System.out.println("Custumer is running!!!");
        } catch (Exception e) {
            System.out.println(e + "\nThere was an error when the Waiter run() method was trying to run.");
        }

    }
}
