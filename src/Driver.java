// IMPORTS of needed Java tools and olus-ins
import java.util.*;
import java.util.concurrent.Semaphore;



public class Driver {

    // Create three class-level Semaphore variables
    volatile static Semaphore Door = new Semaphore(15, true);
    volatile static Semaphore Nap = new Semaphore(0, true);
    volatile static Semaphore Servicing = new Semaphore(0, true);
    private static ThreadGroup rushhour, slowtime;


    public static void main(String[] args) {
        rushhour = new ThreadGroup("rushHour");
        slowtime = new ThreadGroup("slowtime");

        Customer [] customer = new Customer[100];
        Random randomNumberGenerator = new Random();
        Scanner scanner = new Scanner(System.in);



        for(int i = 0; i < 50; i++){
            customer[i] = new Customer(Door, Nap, Servicing, rushhour);
        }

        for(int i = 50; i < 100; i++){
            customer[i] = new Customer(Door, Nap, Servicing, slowtime);
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

        while(rushhour.activeCount() > 0){
        }

        // prompt user
    }
}
