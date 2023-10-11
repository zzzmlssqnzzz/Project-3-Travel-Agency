package assignment1;

public class FlightReservation extends Reservation{
    private Airport departure;
    private Airport arrival;

    public FlightReservation(String reservation_name, Airport a, Airport b) {
        super(reservation_name);
        int distance = Airport.getDistance(a, b) ;
        if (distance == 0) throw new IllegalArgumentException();
        this.departure = a;
        this.arrival = b;
    }
    public int getCost(){
        int distance = Airport.getDistance(departure, arrival);
        double fuel_price = (1.24*(distance/167.52) + 53.75)*100;
        double total_price = fuel_price + departure.getFees() + arrival.getFees();
        return (int)Math.ceil(total_price);
    }
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (!(obj instanceof FlightReservation)){
            return false;
        }
        FlightReservation reservation = (FlightReservation) obj;
        String reservation_name = reservation.reservationName();
        if (reservation_name.equals(this.reservationName())==false){
            return false;
        }
        int distance_1 = Airport.getDistance(reservation.arrival, this.arrival );
        int distance_2 = Airport.getDistance(reservation.departure , this.departure);
        if (distance_1 != 0 && distance_2 != 0){
            return false;
        }
        return true;
    }


}
