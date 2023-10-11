package assignment1;

public class Hotel {
    private String hotel_name;
    private Room[]rooms;

    public Hotel(String name, Room[]rooms){
        this.hotel_name = name;
        this.rooms = new Room[rooms.length];
        for (int x = 0; x < rooms.length; x ++){
            this.rooms[x] = new Room(rooms[x]);
        }
    }
    public int reserveRoom(String room_type){
        Room room= Room.findAvailableRoom(rooms, room_type);
        if (room!=null){
            room.changeAvailability() ;
            return room.getPrice();
        }
        else throw new IllegalArgumentException("There are no rooms available");
    }
    public boolean cancelRoom(String room_type){
        if(Room.makeRoomAvailable(rooms, room_type)){
            return true;
        }
            return false;
    }
}
