import java.lang.Thread;
import java.util.concurrent.Semaphore;

public class Waiter extends Thread {


    private volatile Semaphore Nap = new Semaphore(0);
    private static int custCount = 0;



    public Waiter(Semaphore Nap, Semaphore Servicing, ThreadGroup onject) {

    }



    @Override
    public void run(){
        try{
            System.out.println("Waiter is Running!!!");
            if(Nap.tryAcquire()){

            }

        }
        catch(Exception e){
            System.out.println(e + "\nThere was an error when the Waiter run() method was trying to run.");
        }
    }
}
