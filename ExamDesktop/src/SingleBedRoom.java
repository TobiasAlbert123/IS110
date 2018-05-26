public class SingleBedRoom extends BedRoom{


    public SingleBedRoom(String type, int size, int amountOfDoors, int amountOfWindows) {
        super(type, size, amountOfDoors, amountOfWindows, 1);
    }

    public void printRoom() {
        super.printRoom();
    }
}
