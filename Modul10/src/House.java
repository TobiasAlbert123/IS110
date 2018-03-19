import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class House {
    private ArrayList<Room> rooms;
    private Random randomPicker;

    public House(int amountOfRooms) {
        randomPicker = new Random();
        rooms = new ArrayList<>();
        setAmountOfRooms(amountOfRooms);
    }

    public int setAmountOfRooms(int amountOfRooms) {
        String[] roomtypes = {"bedroom", "bathroom"};
        for (int i = 0; i < amountOfRooms; i++) {
            int index = randomPicker.nextInt(roomtypes.length);
            String type = roomtypes[index];
            makeNewRoom(type, "1");
        }
        return rooms.size();
    }

    public int getAmountOfRooms() {
        return rooms.size();
    }

    public void makeNewRoom(String type, String amountString) {
        int amount = 1;
        try {
            amount = Integer.parseInt(amountString);
        } catch (NumberFormatException ex) {

        }
        for (int i = 0; i < amount; i++) {
            switch (type) {
                case "bedroom":
                    Room newBedroom = new Bedroom();
                    rooms.add(newBedroom);
                    break;
                case "bathroom":
                    Room newBathroom = new Bathroom();
                    rooms.add(newBathroom);
                    break;
                default: System.out.println("Room type not recognised");
            }
        }
    }

    public void makeSpecific(String type) {
        Scanner specs = new Scanner(System.in);
        try {
            System.out.print("Size in m^2: ");
            int size = specs.nextInt();
            System.out.print("\nDoors: ");
            int doors = specs.nextInt();
            System.out.print("\nWindows: ");
            int windows = specs.nextInt();
            switch (type) {
                case "bedroom":
                    System.out.println("Amount of beds?");
                    int beds = specs.nextInt();
                    Room newBedroom = new Bedroom(beds, type, size, doors, windows);
                    break;
                case "bathroom":
                    break;
                default:
                    System.out.println("Room type not recognised");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wrong format detected, please try again");
        }

    }

    public void deleteRooms(String amount) {
        try {
            int intamount = Integer.parseInt(amount);
            for (int i = 0; i < intamount && rooms.size() > 0; i++) {
                rooms.remove(0);
            }
        } catch (NumberFormatException ex) {
            System.out.printf("'%s' is not an integer, please try again\n", amount);
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
