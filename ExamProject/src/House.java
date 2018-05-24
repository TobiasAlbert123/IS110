import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class House {
    private ArrayList<Room> rooms;

    public House() {
        rooms = new ArrayList<>();
    }

    public int getAmountOfRooms() {
        return rooms.size();
    }

    public void makeRoom(String type) {
        BathRoom b = new BathRoom("bathroom", 25, 1, 1, false);
        rooms.add(b);
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
