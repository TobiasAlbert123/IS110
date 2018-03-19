import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class House {
    private int amountOfRooms;
    public ArrayList<Room> rooms;
    private Random randomPicker;

    public House(int amountOfRooms) {
        randomPicker = new Random();
        rooms = new ArrayList<>();
        setAmountOfRooms(amountOfRooms);
        this.amountOfRooms = rooms.size();
    }

    public int setAmountOfRooms(int amountOfRooms) {
        String[] roomtypes = {"bedroom", "bathroom"};
        for (int i = 0; i < amountOfRooms; i++) {
            int index = randomPicker.nextInt(roomtypes.length);
            String type = roomtypes[index];
            makeNewRoom(type, "1");
        }
        this.amountOfRooms = rooms.size();
        return amountOfRooms;
    }

    public int getAmountOfRooms() {
        this.amountOfRooms = rooms.size();
        return amountOfRooms;
    }

    public void makeNewRoom(String args1, String args2) {
        String type = args1;
        int amount = 1;
        try {
            amount = Integer.parseInt(args2);
        } catch (NumberFormatException ex) {

        }
        for (int i = 0; i < amount; i++) {
            switch (type) {
                case "bedroom":
                    Bedroom newBedroom = new Bedroom();
                    rooms.add(newBedroom);
                    break;
                case "bathroom":
                    Bathroom newBathroom = new Bathroom();
                    rooms.add(newBathroom);
                    break;
                default: System.out.println("Room type not recognised");
            }
        }
    }

    public void makeSpecific(String type) {
        Scanner specs = new Scanner(System.in);
        String originalinput = specs.next().toLowerCase();
        switch (type) {
            case "bedroom":
                break;
            case "bathroom":
                break;
            default: System.out.println("Room type not recognised");
        }

    }

    public void printRoom(String type) {
        if (rooms.size() == 0) {
            System.out.println("There are currently 0 rooms.");
        } else {
            for (int i = 0; i < rooms.size(); i++) {
                switch (type) {
                    case "all":
                        rooms.get(i).PrintStats();
                        break;
                    case "bathroom":
                        if (rooms.get(i).getRoomType() == "bathroom") {
                            rooms.get(i).PrintStats();
                        }
                        break;
                    case "bedroom":
                        if (rooms.get(i).getRoomType() == "bedroom") {
                            rooms.get(i).PrintStats();
                        }
                        break;
                    default: System.out.printf("Could not recognize %s as a roomtype to print\n", type);
                    return;
                }
            }
        }
    }
}
