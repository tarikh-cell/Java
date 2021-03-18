import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class app extends Application
{
   @Override
   public void start(Stage stage) throws Exception
   {
      //Button btn = new Button("Click Me");
      //btn.setOnAction(new EventHandler<ActionEvent>(){

      //  @Override
      //  public void handle(ActionEvent arg0){
      //    System.out.println("Hello world");
      //  }
      //});

      Image img = new Image("Picture4.png", 50, 50, false, false);
      ImageView imgView = new ImageView(img);
      imgView.setId("st");
      imgView.setX(353);
      imgView.setRotate(47);


      Text text = new Text("FDM");
      text.setFill(Color.WHITE);
      text.setX(250);
      text.setY(80);
      text.setId("FDM");

      Button btn=new Button("LogIn");
      btn.setLayoutX(300);
      btn.setLayoutY(330);

      Label user_id=new Label("User ID");
      user_id.setTranslateX(190);
      user_id.setTranslateY(230);
      user_id.setTextFill(Color.WHITE);
      Label password = new Label("Password");
      password.setTranslateX(180);
      password.setTranslateY(280);
      password.setTextFill(Color.WHITE);
      TextField tf1=new TextField();
      tf1.setTranslateX(240);
      tf1.setTranslateY(225);
      TextField tf2=new TextField();
      tf2.setTranslateX(240);
      tf2.setTranslateY(275);

      Group root = new Group();
      Scene scene = new Scene(root, 600, 400, Color.rgb(45, 52, 71));

      root.getChildren().addAll(text, imgView, tf1, tf2, user_id, password, btn);


      //root.getChildren().add(btn);
      root.getStylesheets().add("Stylesheet.css");
      stage.setTitle("FDM - Trainer Skills");
      stage.setScene(scene);
      stage.show();
   }



   public static void main(String[] arguments)
   {
      Application.launch(arguments);
   }
}
