public abstract class BedRoom extends Room  implements BedRoomProperties {
    private int amountOfBeds;

    public BedRoom(String type, int size, int amountOfDoors, int amountOfWindows, int amountOfBeds) {
        super(type, size, amountOfDoors, amountOfWindows);
        this.amountOfBeds = amountOfBeds;
    }

    public int getAmountOfBeds() {
        return amountOfBeds;
    }


    public void setAmountOfBeds(int amountOfBeds) {
        this.amountOfBeds = amountOfBeds;
    }

    @Override
    public int hashCode() {
        return 5;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.hashCode()==5) {
            return true;
        }
        return false;
    }

    /*
    Prints info about the room
     */
    public void printRoom() {
        super.printRoom();
        System.out.printf("Beds: %d\n", this.amountOfBeds);
    }
}
