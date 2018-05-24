import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    private Button button;
    private Item item;
    private StackPane layout;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("En tittel");

        button = new Button("Tekst");
        Button button2 = new Button("To");
        button.setOnAction(e -> {
                System.out.println("Ok");
                ImageView imgView = new ImageView(item.getImg());
                layout.getChildren().addAll(button2);
        });

        item = new Item();

        layout = new StackPane();
        layout.getChildren().add(button);


        //Image img = new Image("http://via.placeholder.com/350x150");
        ImageView imgView = new ImageView(item.getImg());
        //layout.getChildren().add(imgView);


        Scene scene = new Scene(layout, 500, 400);
        window.setScene(scene);
        window.show();
    }

    public void makeMessage(Button button, Item item) {
        button.setOnAction(e -> {
            Label message = new Message(item).getInfo();
            layout.getChildren().add(message);
        });
    }



}
