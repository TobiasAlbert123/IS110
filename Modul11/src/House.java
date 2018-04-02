import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class House {
    private ArrayList<Room> rooms;
    private Random randomPicker;
    private ArrayList<String[]> rows;
    private ArrayList<Inhabitant> inhabitants;

    public House(int amountOfRooms) {
        randomPicker = new Random();
        rooms = new ArrayList<>();
        setAmountOfRooms(amountOfRooms);
        rows = new ArrayList<>();
        inhabitants = new ArrayList<>();
    }

    public void houseSetup() {
        String[] row0 = new String[5];
        String[] row1 = {"B", "B", "|", "K", "K"};
        String[] row2 = {"B", "B", "|", "K", "K"};
        String[] row3 = {"B", "B", "|", "K", "K"};
        String[] row4 = {"B", "B", "|", "K", "K"};
        String[] row5 = {"B", "B", "|", "K", "K"};
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
    }

    public void houseMaker(int amountOfRows) {
        for (int i = 0; i < amountOfRows; i++) {
            String row = "";
            switch (i) {
                case 0:
                    row = "_ _ _ _ _";
                    break;

                case 1:
                    row = "B B | K K";
                    break;

                case 2:
                    row = "- H H H -";
                    break;

                default:
                    row = "H H H H H";
            }
            String[] splitRow = row.split("");
            for (int j = 0; j < splitRow.length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.printf(" %s", splitRow[j]);
            }
            System.out.print(" |\n");
        }
    }

    public void newHouseRow() {

    }

    public void printHouse() {
        houseSetup();
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.printf(" %s", rows.get(i)[j]);
                if (j == 4) {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
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
            System.out.printf("Amount not recognised, making default %d room(s)", amount);
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
                    rooms.add(newBedroom);
                    break;
                case "bathroom":
                    System.out.println("Has shower?");
                    boolean shower;
                    //String hasShower = specs.next().toLowerCase();
                    switch (specs.next().toLowerCase()) {
                        case "true":
                            shower = true;
                            break;
                        case "false":
                            shower = false;
                            break;
                        default:
                            System.out.println("Only true or false is accepted, please try again");
                            return;
                    }
                    Room newBathroom = new Bathroom(shower, type, size, doors, windows);

                    break;
                default:
                    System.out.println("Room type not recognised");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wrong format detected, please try again");
        }

    }

    public void deleteRooms(String amountString) {
        try {
            int amount = Integer.parseInt(amountString);
            for (int i = 0; i < amount && rooms.size() > 0; i++) {
                rooms.remove(0);
            }
        } catch (NumberFormatException ex) {
            System.out.printf("'%s' is not an integer, please try again\n", amountString);
        }
    }

    public boolean areRoomsEqual(Room room1, Room room2) {
        if (room1.equals(room2)) {
            return true;
        }
        return false;
    }

    public void checkStats() {
        int equalsFound = 0;
        int equalStats = 0;
        boolean statsAreEqual = false;
        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms.size() /* && j != i*/; j++) {
                if (rooms.get(i).getRoomType() == rooms.get(j).getRoomType()) {
                    statsAreEqual = true;
                    equalStats++;
                }
                if (rooms.get(i).getAmountOfDoors() == rooms.get(j).getAmountOfDoors()) {
                    statsAreEqual = true;
                    equalStats++;
                }
                if (rooms.get(i).getAmountOfWindows() == rooms.get(j).getAmountOfWindows()) {
                    statsAreEqual = true;
                    equalStats++;
                }
                if (rooms.get(i).getSize() == rooms.get(j).getSize()) {
                    statsAreEqual = true;
                    equalStats++;
                }
                if (statsAreEqual) {
                    if (rooms.get(i) == (rooms.get(j))) {
                        equalsFound++;
                    }
                }
            }
        }

        System.out.printf("%d equal stats, %d equal rooms\n", equalStats, equalsFound);
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
                    default: System.out.printf("Could not recognize '%s' as a roomtype to print\n", type);
                    return;
                }
            }
        }
    }

    public void printPeople(String type) {
        if (inhabitants.size() == 0) {
            System.out.println("There are currently 0 people living in the house");
        } else  {
            for (Inhabitant oneInhabitant : inhabitants) {
                switch (type.toLowerCase()) {
                    case "all":
                        oneInhabitant.printInfo();
                        break;

                    case "male":
                        if (oneInhabitant.getGender().contains("male")) {
                            oneInhabitant.printInfo();
                        }
                        break;

                    case "female":
                        if (oneInhabitant.getGender().contains("female")) {
                            oneInhabitant.printInfo();
                        }
                        break;

                    default:
                        System.out.println("Person type not recognised, please use 'all', 'male' or 'female'");
                }

            }
        }
    }

    public void makeInhabitant(String sAmount) {
        int amount = Integer.parseInt(sAmount);
        for (int i = 0; i < amount; i++) {
            Inhabitant newInhabitant = new Inhabitant();
            inhabitants.add(newInhabitant);
        }
    }

    public void nameCheck(String name) {
        int sameName = 0;
        int equally = 0;
        for (int i = 0; i < inhabitants.size(); i++) {
            if (inhabitants.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                for (int j = 0; j < inhabitants.size(); j++) {
                    if (inhabitants.get(i).equals(inhabitants.get(j))) {
                        equally++;
                    }
                    /*if (inhabitants.get(i) == inhabitants.get(j)) {
                        equally++;
                    }*/
                }
                sameName++;
            }
        }
        System.out.printf("%d equal objects found\n", equally);
        System.out.printf("%d people with the name %s", sameName, name);
    }
}
