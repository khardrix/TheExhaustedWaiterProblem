public class Restaurant {


    private int availableSeats = 0;
    private int maxSeats = 15;


    public Restaurant(int maxSeats) {
        maxSeats = maxSeats;
        availableSeats = maxSeats;
    }


    public boolean HasAvailableSeats () {
        return availableSeats > 0;
    }

    public void seatCustomer() throws Exception {
        availableSeats--;
        if(availableSeats < 0) throw new Exception("More than the mex number of customers have been seated.");
    }

    public void customerLeaves() throws Exception {
        availableSeats++;
        if(availableSeats > maxSeats) throw new Exception("Customers left that were not seated.");
    }


}
