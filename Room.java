package assignment1;
public class Room {
    private String room_type;
    private int room_price;
    private boolean room_availability;

    private final int double_price = 90;
    private final int queen_price = 110;
    private final int king_price = 150;

    public Room(String type) {
        if (type.equals("double")) {
            room_price = double_price *100;
        }
        else if (type.equals("queen")) {
            room_price = queen_price *100;
        }
        else if (type.equals("king")) {
            room_price = king_price *100;
        }
        else throw new IllegalArgumentException("The room type does not exist!");
        room_availability = true;
        room_type = type;
    }
    public Room(Room room) {
        room_type = room.room_type;
        room_price = room.room_price;
        room_availability = room.room_availability;
    }
    public String getType(){

        return room_type;
    }
    public int getPrice(){

        return room_price;
    }

    public void changeAvailability() {
        if (room_availability) {
            room_availability = false;
        }
        else {
            room_availability = true;
        }
    }
    public static Room findAvailableRoom(Room[]list, String room_type){
        for(int i = 0; i < list.length ; i++) {
            if (list[i].room_type.equals(room_type) &&
                    list[i].room_availability)
            {
                return list[i];
            }
        }
            return null;
    }
    public static boolean makeRoomAvailable(Room[]list, String room_type){
        for (int i = 0;i < list.length; i++){
            if (list[i].room_type.equals(room_type) && list[i].room_availability == false) {
                list[i].changeAvailability();
                return true;
            }
            }
        return false;
    }
}