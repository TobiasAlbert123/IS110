import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class Item  extends Button{
    private String name;
    private int ID;
    private Image img;
    private int dropAmount;
    private int dropCounter;
    private String message;

    public Item() {
        this.name = "Item name";
        this.ID = 32;
        img = new Image("http://via.placeholder.com/350x150");
    }

    public Image getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getDropAmount() {
        return dropAmount;
    }

    public int getDropCounter() {
        return dropCounter;
    }
}
