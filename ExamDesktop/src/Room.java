import java.lang.reflect.Method;

public abstract class Room implements RoomProperties{
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

    public void setSize(int size) {
        this.size = size;
    }

    public void setAmountOfDoors(int amountOfDoors) {
        this.amountOfDoors = amountOfDoors;
    }

    public void setAmountOfWindows(int amountOfWindows) {
        this.amountOfWindows = amountOfWindows;
    }

    public String getType() {
        return this.type;
    }

    public void printRoom() {
        System.out.printf("Type: %s\n", this.type);
        System.out.printf("Size: %d\n", this.size);
        System.out.printf("Doors: %d\n", this.amountOfDoors);
        System.out.printf("Windows: %d\n", this.amountOfWindows);
    }

}
