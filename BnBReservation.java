package assignment1;

public class BnBReservation extends HotelReservation {
    public BnBReservation (String reservation_name, Hotel hotel, String room_type, int num_nights){
        super(reservation_name, hotel, room_type, num_nights);
    }
    public int getCost(){
        return (super.getNumOfNights()*10*100)+super.getCost();
    }

}
