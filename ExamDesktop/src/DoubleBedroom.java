public class DoubleBedRoom extends BedRoom{

    public DoubleBedRoom(int size, int amountOfDoors, int amountOfWindows) {
        super("doublebedroom", size, amountOfDoors, amountOfWindows, 2);
    }

    public String getExtraLine() {
        super.extraLine = "ekstra 2";
        return super.extraLine;
    }
}
