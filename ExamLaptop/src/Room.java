public abstract class Room implements RoomProperties{
    private String type;
    private int size;
    private int amountOfDoors;
    private int amountOfWindows;
    protected String extraLine;

    public Room(String type, int size, int amountOfDoors, int amountOfWindows) {
        this.type = type;
        this.size = size;
        this.amountOfDoors = amountOfDoors;
        this.amountOfWindows = amountOfWindows;
    }

    /*
    Was going to use setX methods for editRoom, but creating a new room and replacing the old one seemed easier
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void setAmountOfDoors(int amountOfDoors) {
        this.amountOfDoors = amountOfDoors;
    }

    public void setAmountOfWindows(int amountOfWindows) {
        this.amountOfWindows = amountOfWindows;
    }

    /*
    Returns room type
     */
    public String getType() {
        return this.type;
    }

    /*
    Serves no use but displays abstract method
     */
    public abstract String getExtraLine();

    /*
    Prints info about the room
     */
    public void printRoom() {
        System.out.printf("Type: %s\n", this.type);
        System.out.printf("Size: %d\n", this.size);
        System.out.printf("Doors: %d\n", this.amountOfDoors);
        System.out.printf("Windows: %d\n", this.amountOfWindows);
        System.out.printf("Extra abstract: %s\n", this.getExtraLine());
    }

}
