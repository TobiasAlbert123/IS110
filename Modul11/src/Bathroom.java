import java.util.Random;

public class Bathroom extends Room{
    private boolean hasShower;
    private String roomType;
    private boolean heatedFloor;

    //specific creator
    public Bathroom(boolean hasShower, String roomType, int size, int amountOfDoors, int amountOfWindows) {
        super(roomType, size, amountOfDoors, amountOfWindows);
        this.hasShower = hasShower;
        this.roomType = "bathroom";
        this.heatedFloor = heatedFloor();
    }

    //random creator
    public Bathroom() {
        super("bathroom", (int) Math.round(Math.random()*30 + 5), (int) Math.round(Math.random() +1), (int) Math.round(Math.random()*3 + 1));
        Random r = new Random();
        this.hasShower = r.nextBoolean();
    }

    public String setFloorType() {
        String[] types = {"marble", "granite", "stone"};
        Random r = new Random();
        String floorType = types[r.nextInt(types.length)];
        return floorType;
    }

    @Override
    public String getFloorType() {
        return super.getFloorType();
    }

    @Override
    public int getAmountOfDoors() {
        return super.getAmountOfDoors();
    }

    @Override
    public int getAmountOfWindows() {
        return super.getAmountOfWindows();
    }

    /*@Override
    public boolean getShower() {
        return this.hasShower;
    }*/

    public boolean heatedFloor() {
        double r = Math.random();
        if (r >= 0.5) {
            return true;
        }
        return false;
    }


    public void PrintStats() {
        super.PrintStats();
        System.out.printf("Has shower: %b\n", hasShower);
    }
}
