import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class House {
    private ArrayList<Room> rooms;
    private ArrayList<BathRoom> bathRooms;
    private ArrayList<SingleBedRoom> singleBedRooms;
    private ArrayList<DoubleBedRoom> doubleBedRooms;

    public House() {
        rooms = new ArrayList<>();
        bathRooms = new ArrayList<>();
        singleBedRooms = new ArrayList<>();
        doubleBedRooms = new ArrayList<>();
    }

    /**
     * @return amount of rooms
     */
    public int getAmountOfRooms() {
        return rooms.size();
    }

    /**
    *Returns array of possible roomtypes
     */
    public final String[] getAllTypes() {
        String[] types = {"bathroom", "singlebedroom", "doublebedroom"};
        return types;
    }

    /**
    checks if written type is valid
     */
    public boolean isAType(String type) {
        for (int i = 0; i < getAllTypes().length; i++) {
            if (type.equals(getAllTypes()[i])) {
                return true;
            }
        }
        System.out.println("type not recognised, use 'bathroom', 'singlebedroom' or 'doublebedroom',\nor 'back' to return");
        return false;
    }

    /**
    adds different rooms to different lists
     */
    public void addRoomsToLists() {
        //the lists used
        ArrayList[] lists = {bathRooms, singleBedRooms, doubleBedRooms};
        for (int i = 0; i < lists.length; i++) {
            ArrayList currentList = lists[i];
            //clears the list first so there isnt any duplications (could compare objects instead)
            currentList.removeAll(lists[i]);
            for (int j = 0; j < rooms.size(); j++) {
                Room currentRoom = rooms.get(j);
                //adds room to the list if its the correct type
                if (currentRoom.getType() == getAllTypes()[i]) {
                    currentList.add(currentRoom);
                }
            }
        }
    }

    /**
    Makes a random room of type
     */
    public void makeRoom(String type) {
        //randomly generates values
        Random r = new Random();
        int size = r.nextInt(29) + 4;
        int doors = r.nextInt(2) + 1;
        int windows = r.nextInt(4);
        //switch creates different object types based on type
        switch (type) {
            case "bathroom":
                boolean shower = r.nextBoolean();
                BathRoom b = new BathRoom(size, doors, windows, shower);
                rooms.add(b);
                break;

            case "singlebedroom":
                SingleBedRoom sb = new SingleBedRoom(size, doors, windows);
                rooms.add(sb);
                break;

            case "doublebedroom":
                DoubleBedRoom db = new DoubleBedRoom(size, doors, windows);
                rooms.add(db);
                break;
        }
    }

    /**
    Generates 'amount' of random rooms
     */
    public void makeRandomRooms(int amount) {
        String[] types = {"bathroom", "singlebedroom", "doublebedroom"};
        for (int i = 0; i < amount; i++) {
            String type = types[new Random().nextInt(types.length)];
            makeRoom(type);
        }
    }

    /**
     * Sets all variables in a room by user input, used in editRoom() and makeSpecificRoom()
     * @param type type of room to be made
     * @return the room that has been created
     */
    public Room setRoomProperties(String type) {
        //room and scanner initialized
        Room room;
        Scanner sc = new Scanner(System.in);

        //size
        System.out.printf("Size: ");
        int size = sc.nextInt();

        //doors
        System.out.printf("Doors: ");
        int doors = sc.nextInt();

        //windows
        System.out.printf("Windows: ");
        int windows = sc.nextInt();

        //switch creates room based on type
        switch (type.toLowerCase()) {
            case "bathroom":
                System.out.printf("Shower? (true / false):");
                boolean shower = sc.nextBoolean();
                room = new BathRoom(size, doors, windows, shower);
                break;

            case "singlebedroom":
                room = new SingleBedRoom(size, doors, windows);
                break;

            case "doublebedroom":
                room = new DoubleBedRoom(size, doors, windows);
                break;

            default:
                return null;
        }
        return room;
    }

    /**
    Makes a specific room
     */
    public void makeSpecificRoom() {
        Room room;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Type: ");
        String type = sc.next();
        if (isAType(type)) {
            room = setRoomProperties(type);
            rooms.add(room);
            System.out.print("You made room:");
            room.printRoom();
            System.out.println(5);
        } else if (type.equals("back")){
            return;

        } else {
            makeSpecificRoom();
        }
    }

    /**
     * Edits a room by index
     * @param index index number of room to be edited in ArrayList
     */
    public void editRoom(int index) {
        Scanner sc = new Scanner(System.in);
        Room r = rooms.get(index);
        setRoomProperties(r.getType());
        System.out.printf("\nRoom at index %d is now:\n", index);
        r.printRoom();
    }

    /**
    Sets arraylist of rooms to size 'amount'
     * @param amount sets number of rooms to this
     */
    public void setAmountOfRooms(int amount) {
        //does nothing and returns if negative number
        if (amount < 0) {
            System.out.println("Number must be positive. You tried: " + amount);
            return;
        }
            //does nothing if amount is the same
            if (amount == rooms.size()) {
                System.out.printf("You already have %d rooms!\n", amount);
                return;

            } else if (amount < rooms.size()) { //removes index 0 until rooms.size is amount
                for (int i = 0;  amount < rooms.size(); i++) {
                    rooms.remove(0);
                }
                System.out.printf("Now at %d rooms\n", rooms.size());
            } else {    //makes amount-rooms.size rooms
                makeRandomRooms(amount-rooms.size());
                System.out.printf("Now at %d rooms\n", rooms.size());
            }
    }

    /*
    Prints a room by index
     */
    public void printRoom(int index) {
        System.out.printf("Room at index %d: \n", index);
        rooms.get(index).printRoom();
    }

    /*
    Prints either all rooms or all rooms of type
     */
    public void printRooms(String type) {
        switch(type) {
            case "bedroom":
                for (int i = 0; i < rooms.size(); i++) {
                    Room r = rooms.get(i);
                    if (r.getType() == "singlebedroom" ^ r.getType() == "doublebedroom") {
                        System.out.printf("\n%d: \n", i);
                        r.printRoom();
                    }
                }
                break;

            case "singlebedroom":
                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i).getType() == "singlebedroom") {
                        System.out.printf("\n%d: \n", i);
                        rooms.get(i).printRoom();
                    }
                }
                break;

            case "doublebedroom":
                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i).getType() == "doublebedroom") {
                        System.out.printf("\n%d: \n", i);
                        rooms.get(i).printRoom();
                    }
                }
                break;

            case "bathroom":
                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i).getType() == "bathroom") {
                        System.out.printf("\n%d: \n", i);
                        rooms.get(i).printRoom();
                    }
                }
                break;

            //prints all rooms by default / if input isnt recognized
            default:
                int i = 0;
                for (Room r : rooms) {
                    System.out.printf("\n%d: \n", i);
                    r.printRoom();
                    i++;
                }
        }
    }

    /*
    Prints all rooms of type
     */
    public void printByType(String type) {
        addRoomsToLists();
        switch (type) {
            case "bathroom":
                for (BathRoom room : bathRooms) {
                    room.printRoom();
                }
                break;

            case "singlebedroom":
                for (SingleBedRoom room : singleBedRooms) {
                    room.printRoom();
                }
                break;

            case "doublebedroom":
                for (DoubleBedRoom room : doubleBedRooms) {
                    room.printRoom();
                }
                break;
        }
    }

    /*
    General info
     */
    public void printInfo() {
        //adds different rooms into different lists
        addRoomsToLists();

        //variable handling for easier overview
        int singleBed = singleBedRooms.size();
        int doubleBed = doubleBedRooms.size();
        int bedRooms = singleBed + doubleBed;
        int baths = bathRooms.size();
        int all = rooms.size();

        System.out.println("\nStats:");

        //amount of bathrooms with % of all rooms
        System.out.printf("Bathrooms: %d (%.0f%%)\n", baths, percent(baths, all));

        //amount of bedroosm with % of all rooms
        System.out.printf("Bedrooms: %d (%.0f%%)\n", bedRooms, percent(bedRooms, all));

        //amount of single bedrooms with % of bedrooms
        System.out.printf(" -%d single bedrooms (%.0f%%)\n", singleBed, percent(singleBed, bedRooms));

        //amount of double bedrooms with % of bedrooms
        System.out.printf(" -%d double bedrooms (%.0f%%)\n", doubleBed, percent(doubleBed, bedRooms));

        //total number of beds
        System.out.printf("Total beds: %d\n", singleBed + (doubleBed*2));
    }

    /*
    returns the % value of 'amount' in 'total'
     */
    public float percent(int amount, int total) {
        return (float)amount/(float)total * 100;
    }
}
