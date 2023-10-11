public abstract class Reservation{
    private String client_name;
    public Reservation(String name){
        this.client_name = name;
    }
    public final String reservationName(){
        return client_name;
    }
    public abstract int getCost();
    public abstract boolean equals(Object obj);
}
