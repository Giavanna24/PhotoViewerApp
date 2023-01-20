import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.StackPane;


public class Main extends Application{
Image currentImage;
int currentNumber;
List<Image> images = new ArrayList<Image>();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Photo Viewer App");

        FileInputStream input =  new FileInputStream("Kitty.jpg");
        Image image = new Image(input);

        FileInputStream input2= new FileInputStream("JoeyUnderTree.jpg");
        Image image2 = new Image(input2);

       FileInputStream input3 =  new FileInputStream("JoeyOnDonutBox.jpg");
        Image image3 = new Image(input3);

        FileInputStream input4 =  new FileInputStream("JoeySleep.jpg");
        Image image4 = new Image(input4);

        FileInputStream input5 =  new FileInputStream("HatOnJoey.jpg");
        Image image5 = new Image(input5);

        images.add(image);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);

        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(50);
        imageView.setTranslateY(10);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1100);

        Button PressMe = new Button("Press Me");

        PressMe.setOnAction(actionEvent -> {
        if (currentNumber < 4){
        currentNumber = currentNumber + 1;
        imageView.setImage(images.get(currentNumber));
        }else{
            currentNumber = 0;
        }
        imageView.setImage(images.get(currentNumber));
    });

        PressMe.setMinSize(50,50);
        PressMe.setMaxSize(100,100);

       // TextArea textarea = new TextArea();
        //StackPane stackPane = new StackPane(imageView,textarea);
        //stackPane.setAlignment(Pos.CENTER);

//stackPane,
        HBox hbox = new HBox(imageView);
        VBox vbox = new VBox(hbox, PressMe);
        vbox.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(vbox ,1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

