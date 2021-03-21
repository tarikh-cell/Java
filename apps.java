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
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.PasswordField;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.Screen;


public class apps extends Application
{
  public static void main(String[] arguments)
  {
     Application.launch(arguments);
  }


   @Override
   public void start(Stage stage) throws Exception
   {
      BorderPane bp = new BorderPane();

      //User Icon
      Image im = new Image("Picture3.png", 100, 100, false, false);
      ImageView imgV = new ImageView(im);

      // FDM logo
      GridPane root = new GridPane();

      Image image = new Image("Picture1.png", 70, 70, false, false);
      ImageView imgView = new ImageView(image);
      imgView.setRotate(47);
      imgView.setTranslateX(153);
      imgView.setTranslateY(29);

      Text text = new Text("FDM");
      text.setId("FDM");
      text.setFill(Color.rgb(0,191,255));

      root.addRow(0, imgView);
      root.addRow(1, text);
      root.setAlignment(Pos.TOP_CENTER);

      // Username & Password
      GridPane log = new GridPane();

      Rectangle rect=new Rectangle();
      rect.setWidth(150);
      rect.setHeight(1);
      rect.setY(350);

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
      log.setHalignment(imgV, HPos.CENTER);
      Button btnn = new Button("Forgot Password");

      Image imag = new Image("Picture3.png", 30, 30, false, false);
      ImageView imgVie = new ImageView(imag);

      Image ima = new Image("Picture5.png", 30, 30, false, false);
      ImageView imgVi = new ImageView(ima);

      // Set layout and position elements
      log.addRow(0, new Text(""), imgV);
      log.addRow(1, imgVie, tf1);
      log.addRow(2, imgVi, tf2);
      log.addRow(3, new Text(""), btn);

      Text CopyR = new Text("CopyRight© : All Rights Reserved");
      CopyR.setFill(Color.WHITE);
      bp.setAlignment(CopyR, Pos.CENTER);
      CopyR.setId("cr");
      bp.setStyle("-fx-background-color: #661a33");


      //css
      root.setStyle("-fx-background-color: rgb(45, 52, 71);");
      log.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 25% 100%, #2d3447, #661a33)");
      log.setAlignment(Pos.CENTER);
      log.setVgap(30);

      // Set scene & initialize setLayout

      bp.setTop(root);
      bp.setCenter(log);
      bp.setBottom(CopyR);

      Scene scene = new Scene(bp, 800, 600, Color.rgb(45, 52, 71));

      scene.getStylesheets().add("Stylesheet.css");
      stage.setTitle("FDM - Trainer Skills");
      stage.setScene(scene);
      stage.show();
   }

}
