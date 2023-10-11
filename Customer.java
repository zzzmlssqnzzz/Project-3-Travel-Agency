package assignment1;

public class Customer {
    private String customer_name;
    private int balance;
    private Basket basket;

    public Customer(String name, int initial_balance){
        super();
        customer_name = name;
        balance = initial_balance;
        basket = new Basket();
    }
    public String getName(){
        return customer_name;
    }
    public Basket getBasket(){
        return basket;
    }
    public int getBalance(){
        return balance;
    }
    public int addFunds(int amount){
        if (amount < 0){
            throw new IllegalArgumentException("Funds can not be negative");
        }
        else{
            balance += amount;
        }
        return balance;
    }
    public int addToBasket(Reservation reservation){
        if (this.customer_name.equals(reservation.reservationName())) {basket.add(reservation);
        return basket.getNumOfReservations();
    }
        else{
            throw new IllegalArgumentException("The names are not the same");
        }
    }
    public int addToBasket(Hotel hotel, String room_type, int num_of_nights, boolean bnb){
        if (bnb){
            BnBReservation bnb_res = new BnBReservation(customer_name, hotel, room_type, num_of_nights);
            int num_res = basket.add(bnb_res);
            return num_res;
        }
        else{
            HotelReservation hotel_res = new HotelReservation(customer_name, hotel, room_type, num_of_nights);
            int num_res = basket.add(hotel_res);
            return num_res;
        }
    }
    public int addToBasket(Airport a1, Airport a2){
        FlightReservation flight_res = new FlightReservation(customer_name, a1, a2);
        int num_res = basket.add(flight_res);
        return num_res;
    }
    public boolean removeFromBasket(Reservation reservation){
        boolean success = basket.remove(reservation);
        return success;
    }
    public int checkOut(){
        if (balance < basket.getTotalCost()){
            throw new IllegalArgumentException("You broke af!");
        }
        else{
            int new_balance = balance - basket.getTotalCost();
            return new_balance;
        }
    }
}
