import java.util.Random;

public class BathRoom extends Room {
    private boolean hasShower;

    public BathRoom(String type, int size, int amountOfDoors, int amountOfWindows, boolean hasShower) {
        super(type, size, amountOfDoors, amountOfWindows);
        this.hasShower = hasShower;
    }

    public BathRoom() {
        super();
    }

    public int setSize() {
        Random r = new Random();
        return r.nextInt(2-30);
    }

    public void printRoom() {
        super.printRoom();
        System.out.println("Shower: " + this.hasShower);
    }
}
