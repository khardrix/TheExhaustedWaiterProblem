public class TheFooBarAndRestaurant {


    private int availableSeats = 0;
    private static final int maxSeats = 15;


    public TheFooBarAndRestaurant(int availableSeats) {

    }

    public TheFooBarAndRestaurant() {
        availableSeats -= maxSeats;
    }


}
