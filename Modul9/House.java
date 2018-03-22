import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class House {
    public ArrayList<Room> rooms;
    private Random randomPicker;

    public House(int amountOfRooms) {
        randomPicker = new Random();
        rooms = new ArrayList<>();
        setAmountOfRooms(amountOfRooms);
    }

    public boolean setAmountOfRooms(int amountOfRooms) {
        String[] roomtypes = {"bedroom", "bathroom"};
        if (amountOfRooms >= 0 && amountOfRooms < Integer.MAX_VALUE) {
            for (int i = 0; i < amountOfRooms; i++) {
                int index = randomPicker.nextInt(roomtypes.length);
                String type = roomtypes[index];
                makeNewRoom(type, "1");
            }
        } else {
            return false;
        }
        return true;
    }

    public int getAmountOfRooms() {
        return rooms.size();
    }

    public boolean makeNewRoom(String args1, String args2) {
        String type = args1;
        int amount = 1;
        try {
            amount = Integer.parseInt(args2);
        } catch (NumberFormatException ex) {
            return false;
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
        return true;
    }

    public boolean makeSpecific(String type) {
        Scanner specs = new Scanner(System.in);
        try {
            System.out.print("Size in m^2: ");
            int size = 22;//specs.nextInt();
            System.out.print("\nDoors: ");
            int doors = 2;//specs.nextInt();
            System.out.print("\nWindows: ");
            int windows = 1;//specs.nextInt();
            switch (type) {
                case "bedroom":
                    System.out.println("Amount of beds?");
                    int beds = 1;//specs.nextInt();
                    Room newBedroom = new Bedroom(beds, type, size, doors, windows);
                    rooms.add(newBedroom);
                    break;
                case "bathroom":
                    System.out.println("Has shower? (true / false");
                    String showerstring = specs.next().toLowerCase();
                    boolean shower;
                    switch (showerstring) {
                        case "true":
                            shower = true;
                            break;
                        case "false":
                            shower = false;
                            break;
                        default:
                            System.out.println("error, try again with 'true' or 'false'");
                            return false;
                    }
                    Room newBathroom = new Bathroom(shower, type, size, doors, windows);
                    rooms.add(newBathroom);
                    break;
                default:
                    System.out.println("Room type not recognised");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wrong format detected, please try again");
            return false;
        }
        return true;
    }

    public boolean printRoom(String type) {
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
                    default:
                        System.out.printf("Could not recognize %s as a roomtype to print\n", type);
                        return false;
                }
            }
        }
        return true;
    }
}
