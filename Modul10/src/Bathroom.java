import java.util.Random;

public class Bathroom extends Room {
    private boolean hasShower;
    private String roomType;

    //specific creator
    public Bathroom(boolean hasShower, String roomType, int size, int amountOfDoors, int amountOfWindows) {
        super(roomType, size, amountOfDoors, amountOfWindows);
        this.hasShower = hasShower;
        this.roomType = "bathroom";
    }

    //random creator
    public Bathroom() {
        super("bathroom", (int) Math.round(Math.random()*30 + 5), (int) Math.round(Math.random() +1), (int) Math.round(Math.random()*3 + 1));
        Random r = new Random();
        this.hasShower = r.nextBoolean();
    }

    public void PrintStats() {
        super.PrintStats();
        System.out.printf("Has shower: %b\n", hasShower);
    }
}
