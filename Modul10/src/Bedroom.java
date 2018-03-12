public class Bedroom extends Room{
    private int amountOfBeds;
    private String roomType;

    public Bedroom(String roomType, int amountOfBeds, int size, int amountOfDoors, int amountOfWindows) {
        super(roomType, size, amountOfDoors, amountOfWindows);
        this.amountOfBeds = amountOfBeds;
        this.roomType = "Bedroom";
    }

    public Bedroom() {
        super("Bedroom", (int) Math.round(Math.random())*30 + 5, (int) Math.round(Math.random()) +1, (int) Math.round(Math.random())*3 + 1);
        this.amountOfBeds = (int) Math.round(Math.random()) + 1;
    }

    /*public Bedroom randomBedroom() {
        int size = (int) Math.random()*30 + 5;
        int amountOfDoors = (int) Math.random() +1;
        int amountOfWindows = (int) Math.random()*3 + 1;
        return Bedroom
    }*/

    public void PrintStats() {
        super.PrintStats();
        System.out.printf("Number of beds: %d\n", amountOfBeds);
    }
}
