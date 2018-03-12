import java.util.ArrayList;

public class House {
    private int amountOfRooms;
    public ArrayList<Room> rooms;
    public ArrayList<Bedroom> bedrooms;
    public ArrayList<Bathroom> bathrooms;

    public House(int amountOfRooms) {
        this.amountOfRooms = amountOfRooms;
        rooms = new ArrayList<>();
    }

    public int setAmountOfRooms(int amountOfRooms) {
        this.amountOfRooms = amountOfRooms;
        return amountOfRooms;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }
}
