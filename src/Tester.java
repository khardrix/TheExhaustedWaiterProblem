import java.util.Random;

public class Tester {


    public static void main(String[] args) {
        Random dice = new Random();
        int randomNumber = 0;


        for(int i = 0; i < 10; i++){
            randomNumber = 500 + dice.nextInt(450);
    }
}
