import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class House {
    private ArrayList<Room> rooms;

    public House() {
        rooms = new ArrayList<>();
    }

    public int getAmountOfRooms() {
        return rooms.size();
    }

    public void makeSpecificRoom() {
        Room room;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Type: ");
        String type = sc.next();
        System.out.printf("Size: ");
        int size = sc.nextInt();
        System.out.printf("Doors: ");
        int doors = sc.nextInt();
        System.out.printf("Windows: ");
        int windows = sc.nextInt();
        switch (type.toLowerCase()) {
            case "bathroom":
                System.out.printf("Shower? (true / false):");
                boolean shower = sc.nextBoolean();
                room = new BathRoom(type, size, doors, windows, shower);
                break;

            case "singlebedroom":
                room = new SingleBedRoom(type, size, doors, windows);
                break;

            case "doublebedroom":
                room = new DoubleBedroom(type, size, doors, windows);
                break;

            default:
                System.out.println("type not recognised, use 'bathroom', 'singlebedroom' or 'doublebedroom'");
                return;
        }
        rooms.add(room);
        System.out.print("You made room:");
        room.printRoom();

    }

    public void makeRoom(String type) {
        Random r = new Random();
        int size = r.nextInt(29) + 4;
        int doors = r.nextInt(2) + 1;
        int windows = r.nextInt(4);
        switch (type) {
            case "bathroom":
                boolean shower = r.nextBoolean();
                BathRoom b = new BathRoom("bathroom", size, doors, windows, shower);
                rooms.add(b);
                break;

            case "singlebedroom":
                SingleBedRoom sb = new SingleBedRoom("singlebedroom", size, doors, windows);
                rooms.add(sb);
                break;

            case "doublebedroom":
                DoubleBedroom db = new DoubleBedroom("doublebedroom", size, doors, windows);
                rooms.add(db);
                break;



        }
    }

    public void makeRandomRooms(int amount) {
        String[] types = {"bathroom", "singlebedroom", "doublebedroom"};
        for (int i = 0; i < amount; i++) {
            String type = types[new Random().nextInt(types.length)];
            makeRoom(type);
        }
    }

    public void setAmountOfRooms(int amount) {
        if (amount < 0) {
            System.out.println("Number must be positive. You tried: " + amount);
            return;
        }
            if (amount == rooms.size()) {
                System.out.printf("You already have %d rooms!\n", amount);

            } else if (amount < rooms.size()) {
                for (int i = 0; i < amount; i++) {
                    rooms.remove(0);
                }
            } else {
                makeRandomRooms(amount);
            }

    }

    public void printRooms(String type) {
        switch(type) {
            case "bedroom":
                for (int i = 0; i < rooms.size(); i++) {
                    Room r = rooms.get(i);
                    if (r.getType() == "singlebedroom" ^ r.getType() == "doublebedroom") {
                        r.printRoom();
                    }
                }
                break;

            case "singlebedroom":
                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i).getType() == "singlebedroom") {
                        rooms.get(i).printRoom();
                    }
                }
                break;

            case "doublebedroom":
                Iterator<Room> it = rooms.iterator();
                while (it.hasNext()) {
                    if (it.next().getType() == "doublebedroom") {

                    }
                }
                break;

            case "bathroom":
                for (Room r : rooms) {
                    if (r.getType() == "bathroom") {
                        r.printRoom();
                    }
                }
                break;

            default:
                for (Room r : rooms) {
                    r.printRoom();
                }
        }
    }
}
