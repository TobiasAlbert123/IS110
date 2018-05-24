public abstract class Room {
    private String type;
    private int size;
    private int amountOfDoors;
    private int amountOfWindows;

    public Room(String type, int size, int amountOfDoors, int amountOfWindows) {
        this.type = type;
        this.size = size;
        this.amountOfDoors = amountOfDoors;
        this.amountOfWindows = amountOfWindows;
    }

    public Room() {
    }


    public String getType() {
        return this.type;
    }

    public void printRoom() {
        System.out.println();
        System.out.println("Room info:");
        System.out.printf("Size: %d\n", this.size);
        System.out.printf("Doors: %d\n", this.amountOfDoors);
        System.out.printf("Windows: %d\n", this.amountOfWindows);
    }

}
