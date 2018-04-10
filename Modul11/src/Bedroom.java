public class Bedroom extends Room{
    private int amountOfBeds;
    private String roomType;

    //specific creator
    public Bedroom(int amountOfBeds, String roomType, int size, int amountOfDoors, int amountOfWindows) {
        super(roomType, size, amountOfDoors, amountOfWindows);
        this.amountOfBeds = amountOfBeds;
        this.roomType = "bedroom";
    }

    //random creator
    public Bedroom() {
        super("bedroom", (int) Math.round((Math.random())*30 + 5), (int) Math.round((Math.random()) +1 ), (int) Math.round((Math.random())*3 + 1));
        this.amountOfBeds = (int) Math.round(Math.random()) + 1;
    }

    public boolean heatedFloor() {
        return false;
    }

    public void PrintStats() {
        super.PrintStats();
        System.out.printf("Number of beds: %d\n", amountOfBeds);
    }

    public void printMaster() {
        System.out.println("This is the master bedroom");
    }
}
