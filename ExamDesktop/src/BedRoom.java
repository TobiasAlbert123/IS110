public abstract class BedRoom extends Room  implements BedRoomProperties {
    private int amountOfBeds;

    public BedRoom(String type, int size, int amountOfDoors, int amountOfWindows, int amountOfBeds) {
        super(type, size, amountOfDoors, amountOfWindows);
        this.amountOfBeds = amountOfBeds;
    }

    public int getAmountOfBeds() {
        return amountOfBeds;
    }

    public BedRoom() {

    }

    public void printRoom() {
        super.printRoom();
        System.out.printf("Beds: %d\n", this.amountOfBeds);
    }
}
