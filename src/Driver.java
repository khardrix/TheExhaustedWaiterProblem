// IMPORTS of needed Java tools and olus-ins
import java.util.*;
import java.util.concurrent.Semaphore;



public class Driver {

    // Create three class-level Semaphore variables
    volatile static Semaphore Door = new Semaphore(15, true);
    volatile static Semaphore Nap = new Semaphore(0, true);
    volatile static Semaphore Servicing = new Semaphore(0, true);


    public static void main(String[] args) {

        ThreadGroup rushHour = new ThreadGroup("rushHour");
        ThreadGroup showTime = new ThreadGroup("showtime");

        Customer [] customer = new Customer[100];


        for(int i = 0; i < 50; i++){
            customer[i] = new Customer(Door, Nap, Servicing, rushHour);
        }

        for(int i = 50; i < 100; i++){
            customer[i] = new Customer(Door, Nap, Servicing, showTime);
        }

        // prompt user

        try {
            Waiter waiter = new Waiter(Nap, Servicing);

            waiter.start();

            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println(e);
        }

        for(int i = 0; i < 50; i++){
            customer[i].start();
        }

        while(rushHour.activeCount() > 0){
        }

        // prompt user
    }
}
