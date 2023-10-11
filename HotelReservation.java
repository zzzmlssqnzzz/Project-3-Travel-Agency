package assignment1;

public class HotelReservation extends Reservation {
    private Hotel hotel;
    private String room_type;
    private int num_nights;
    private int room_price;

    private int price_per_night;
    public HotelReservation(String reservation_name, Hotel hotel, String room_type, int num_nights){
        super(reservation_name);
        this.hotel = hotel;
        this.room_type = room_type;
        this.num_nights = num_nights;
        price_per_night = hotel.reserveRoom(room_type);
    }
    public int getNumOfNights(){
        return num_nights;
    }
    public int getCost(){
        return price_per_night*num_nights;
    }
    public String getRoomType(){
        return room_type;
    }
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (!(obj instanceof HotelReservation)){
            return false;
        }
        HotelReservation reservation = (HotelReservation) obj;
        String reservation_name = reservation.reservationName();
        if (reservation_name.equals(this.reservationName())==false){
            return false;
        }
        int cost = reservation.getCost();
        int num_nights = reservation.getNumOfNights();
        String room_type = reservation.getRoomType();
        if (room_type.equals(this.getRoomType())==false){
            return false;
        }
        else if (cost == this.getCost() && num_nights == this.getNumOfNights()){
            return true;
        }
        return false;
    }
}
