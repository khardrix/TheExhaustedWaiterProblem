// IMPORTS of needed Java tools and olus-ins
import java.util.*;
import java.util.concurrent.Semaphore;


public class Driver {

    // Create three class-level Semaphore variables
    volatile static Semaphore Door, Nap, Servicing;


    public static void main(String[] args) throws InterruptedException {
        Door = new Semaphore(15, true);
        Nap = new Semaphore(0, true);
        Servicing = new Semaphore(0, true);

        ThreadGroup rushhour = new ThreadGroup("rushHour");
        ThreadGroup slowtime = new ThreadGroup("slowtime");

        Random randomNumberGenerator = new Random();
        int randomNumber = 0;
        Scanner scanner = new Scanner(System.in);
        Customer [] customer = new Customer[100];


        for(int i = 0; i < 50; i++){
            customer[i] = new Customer(Nap, Servicing, Door, rushhour);
        }

        for(int i = 50; i < 100; i++){
            customer[i] = new Customer(Nap, Servicing, Door, slowtime);
        }

        System.out.println("Hit [ENTER] to start the \"rushhour\" simulation: ");
        String response = scanner.nextLine();

        Waiter waiter = new Waiter(Nap, Servicing);

        try {
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
        System.out.println("Press [ENTER] to start the \"slowtime\" simulation:");
        response = scanner.nextLine();
        long waitTime = 50 + randomNumberGenerator.nextInt(450);
        Thread.sleep(waitTime);

        for(int i = 50; i < 100; i++){
            waitTime = 50 + randomNumberGenerator.nextInt(450);
            Thread.sleep(waitTime);
            customer[i].start();
        }

        if(slowtime.activeCount() == 0){
            waiter.interrupt();
        }
    }
}
