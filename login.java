import javafx.application.Application;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.PasswordField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.Screen;


public class login extends Application
{
  public static void main(String[] arguments)
  {
     Application.launch(arguments);
  }


   @Override
   public void start(Stage stage) throws Exception
   {
      BorderPane bp = new BorderPane();
      bp.setId("background");

      Text text = new Text("FDM");
      text.setId("FDM");
      text.setFill(Color.rgb(0,0,0));

      // Username & Password
      GridPane log = new GridPane();
      log.setId("userForm");

      Text user_id=new Text("User ID");
      user_id.setFill(Color.WHITE);
      Text txt = new Text("password");
      txt.setFill(Color.WHITE);

      TextField tf1=new TextField();
      tf1.getStyleClass().add("tf");
      tf1.setPromptText("Username");
      tf1.setFocusTraversable(false);
      PasswordField tf2=new PasswordField();
      tf2.setPromptText("Password");
      tf2.setFocusTraversable(false);

      Button btn = new Button("LogIn");
      btn.setId("btn");
      btn.setPrefWidth(80);
      log.setHalignment(btn, HPos.RIGHT);
      log.setHalignment(text, HPos.CENTER);
      Button btnn = new Button("Forgot Password");

      btn.setOnMouseClicked((MouseEvent event) -> {
        System.out.println("clicked");
      });

      Image imag = new Image("Picture4.png", 30, 30, false, false);
      ImageView imgVie = new ImageView(imag);

      Image ima = new Image("Picture2.png", 30, 30, false, false);
      ImageView imgVi = new ImageView(ima);

      // Set layout and position elements
      log.addRow(0, new Text(""), new Text(""));
      log.addRow(1, imgVie, tf1);
      log.addRow(2, imgVi, tf2);
      log.addRow(3, new Text(""), btn);

      Text CopyR = new Text("CopyRight© : All Rights Reserved");
      bp.setAlignment(CopyR, Pos.CENTER);
      CopyR.setId("cr");

      // Set scene & initialize setLayout

      log.setVgap(30);
      log.setPadding(new Insets(0,0,0,40));
      //log.setGridLinesVisible(true);

      bp.setCenter(log);
      //bp.setBottom(CopyR);

      //bp.setStyle("-fx-background-color: rgb(0,0,0)");

      Scene scene = new Scene(bp, 800, 600, Color.rgb(0,0,0));

      scene.getStylesheets().add("Stylesheet.css");
      stage.setTitle("FDM - Trainer Skills");
      stage.setScene(scene);
      stage.show();
   }

}
