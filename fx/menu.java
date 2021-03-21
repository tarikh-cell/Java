import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.ImageInput;
import javafx.scene.control.Button;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Pos;

public class menu extends Application
{
  public static void main(String[] arguments)
  {
     Application.launch(arguments);
  }


   @Override
   public void start(Stage stage) throws Exception
   {
    BorderPane bp = new BorderPane();

    MenuBar menubar = new MenuBar();
    menubar.setId("mb");
    Menu FileMenu = new Menu("File");
    MenuItem filemenu1=new MenuItem("new");
    Menu EditMenu=new Menu("Edit");
    MenuItem EditMenu1=new MenuItem("Cut");
    EditMenu.getItems().addAll(EditMenu1);
    FileMenu.getItems().addAll(filemenu1);
    menubar.getMenus().addAll(FileMenu,EditMenu);

    GridPane gp = new GridPane();

    Image im = new Image("Picture3.png", 100, 100, false, false);
    ImageView imgV = new ImageView(im);
    gp.getChildren().add(imgV);
    gp.setHalignment(imgV, HPos.CENTER);

    String[] arr = {"Kahludi","Al Falluga","Admin","A190","01-01-2001"};
    gp.addRow(1, new Text("Forename:"), new Text(arr[0]));
    gp.addRow(2, new Text("Surname:"), new Text(arr[1]));
    gp.addRow(3, new Text("Account Type:"), new Text(arr[2]));
    gp.addRow(4, new Text("Unique Identifier:"), new Text(arr[3]));
    gp.addRow(5, new Text("Account made:"), new Text(arr[4]));
    gp.setId("gp");
    gp.setVgap(10);
    gp.setColumnSpan(imgV, 2);

    GridPane gr = new GridPane();
    TextField bool = new TextField("false");

    Button btns = new Button("Q");

    ///////////////////////////////////////////////////////////////////////////
    TextField search=new TextField();
    search.getStyleClass().add("tf");
    search.setPromptText("search");
    gr.addRow(0, menubar);
    gr.addRow(1, search, btns);
    gr.setGridLinesVisible(true);
    Button btnC = new Button("Clear");

    btns.setOnMouseClicked((MouseEvent event) -> {
            //set textfield values
            TextField b = displaySearch();
            for (int x = 1; x < 5; x++){
              Button r = new Button("wasd");
              gr.addRow(x, r);
              r.setOnMouseClicked((MouseEvent evnt) -> {
                TextField s = displaySearch();
                gr.getChildren().clear();
                gr.addRow(0, menubar);
                gr.addRow(1, r);
              });
            }
            gr.addRow(5, b);
            gr.addRow(6, btnC);
        });

    btnC.setOnMouseClicked((MouseEvent event) -> {
            //set textfield values
            gr.getChildren().clear();
            gr.addRow(0, menubar);
            gr.addRow(1, search, btns);
    });
    ///////////////////////////////////////////////////////////////////////////

    bp.setLeft(gp);
    bp.setCenter(gr);

    Scene scene = new Scene(bp, 800, 600, Color.rgb(45, 52, 71));

    scene.getStylesheets().add("style.css");
    stage.setTitle("FDM - Trainer Skills");
    stage.setScene(scene);
    stage.show();
   }

   public static TextField displaySearch(){
     //Example Function
     System.out.println("qwerty");
     TextField s = new TextField("works!");
     return s;
   }

}
