public class Airport{
        private int x_coordinate;
        private int y_coordinate;
        private int fees;

    public Airport(int x, int y,int fees){
        this.x_coordinate=x;
        this.y_coordinate=y;
        this.fees=fees;
    }
    public int getFees() {
        return fees;
    }
    public static int getDistance(Airport a, Airport b){
        double dx = b.x_coordinate-a.x_coordinate;
        double dy = b.y_coordinate-a.y_coordinate;
        double dist = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
        return (int)Math.ceil(dist);
    }
}
