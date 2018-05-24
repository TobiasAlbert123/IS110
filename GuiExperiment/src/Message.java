import javafx.scene.control.Label;

public class Message {
    private int dropAmount;
    private int dropCounter;
    public String name;
    private String message;

    public Message(Item item) {
        this.dropAmount = item.getDropAmount();
        this.dropCounter = item.getDropCounter();
        this.name = item.getName();
    }

    public Label getInfo() {
        int amount = this.dropAmount * this.dropCounter;
        String aString = amount + "x " + this.name;
        Label info = new Label(aString);
        return info;
    }
}
