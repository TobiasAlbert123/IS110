public class SingleBedRoom extends BedRoom{

    public SingleBedRoom(int size, int amountOfDoors, int amountOfWindows) {
        super("singlebedroom", size, amountOfDoors, amountOfWindows, 1);
    }

    public String getExtraLine() {
        super.extraLine = "ekstra 1";
        return super.extraLine;
    }

}
