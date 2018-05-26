public class BathRoom extends Room {
    private boolean hasShower;

    public BathRoom(int size, int amountOfDoors, int amountOfWindows, boolean hasShower) {
        super("bathroom", size, amountOfDoors, amountOfWindows);
        this.hasShower = hasShower;
    }

    public void setHasShower(boolean hasShower) {
        this.hasShower = hasShower;
    }

    public String getExtraLine() {
        super.extraLine = "ekstra bad";
        return super.extraLine;
    }

    /*
    Prints info about the room
     */
    public void printRoom() {
        super.printRoom();
        System.out.println("Shower: " + this.hasShower);
    }
}
