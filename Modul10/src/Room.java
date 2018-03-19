public class Room {
    private int size;
    private int amountOfDoors;
    private int amountOfWindows;
    private String roomType;

    public Room(String roomType, int size, int amountOfDoors, int amountOfWindows) {
        this.roomType = roomType;
        this.size = size;
        this.amountOfDoors = amountOfDoors;
        this.amountOfWindows = amountOfWindows;
    }

    public Room() {

    }

    public String getRoomType() {
        return roomType;
    }

    public void PrintStats() {
        System.out.printf("\ntype: %s\n", roomType);
        System.out.printf("size: %dm^2\n", size);
        System.out.printf("doors: %d\n", amountOfDoors);
        System.out.printf("windows: %d\n", amountOfWindows);
    }
}
