package assignment1;

public class Basket{
    private Reservation[]reservations;
    public Basket(){
        this.reservations = new Reservation[0];
    }
    public Reservation[]getProducts(){
        Reservation[] newRes = this.reservations.clone();
        return newRes;
    }
    public int add(Reservation reservation){
        Reservation[] tempReservation = this.reservations.clone();
        int size = this.reservations.length;

        this.reservations = new Reservation[size+1];
        for (int i = 0; i < size; i++){
            this.reservations[i] = tempReservation[i];
        }
        this.reservations[size] = reservation;
        return size+1;
    }

    public boolean remove(Reservation reservation){
        boolean success = false;
        for (int i=0; i < this.reservations.length; i++){
            if (reservations[i]==reservation){
                success = true;
            }
        }
        if (success && reservations.length == 1){
            Reservation [] tempReservation = new Reservation[0];
            this.reservations = tempReservation;
            return true;
        }
        else if (success){
            Reservation[] tempReservation = new Reservation[reservations.length];
            int index = 0;
            for (int i = 0; i < reservations.length; i++){
                if (this.reservations[i]!=reservation){
                    tempReservation[index] = this.reservations[i];
                    index += 1;
                }
            }
            reservations = tempReservation;
            return true;
        }
        else {
            return false;
        }
    }
    public void clear(){
        if (this.reservations != null){
            reservations = null;
        }
    }
    public int getNumOfReservations(){
        if (this.reservations != null){
            return reservations.length;
        }
        else{
            return 0;
        }
    }
    public int getTotalCost(){
        if (this.reservations != null){
            int size = reservations.length;
            int cost = 0;
            for (int i = 0; i<size; i++){
                cost = cost + reservations[i].getCost();
            }
            return cost;
        }
        else {
            return 0;
        }

    }
}
