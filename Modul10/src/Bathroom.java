public class Bathroom extends Room {
    private boolean hasShower;
    private String roomType;

    public Bathroom(boolean hasShower, String roomType, int size, int amountOfDoors, int amountOfWindows) {
        super(roomType, size, amountOfDoors, amountOfWindows);
        this.hasShower = hasShower;
        this.roomType = "Bathroom";
    }

    public Bathroom() {
        super("Bathroom", (int) Math.random()*30 + 5, (int) Math.random() +1, (int) Math.random()*3 + 1);
        this.hasShower = true;
    }

    public void PrintStats() {
        super.PrintStats();
        System.out.printf("Has shower: %b\n", hasShower);
    }
}
