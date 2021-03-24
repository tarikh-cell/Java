import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
import javafx.geometry.Insets;

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

    GridPane grp = displayUser();
    GridPane gdp = Search();
    TabPane tb = createTabs();
    tb.setPadding(new Insets(20));
    tb.getStylesheets().add("style.css");

    bp.setLeft(grp);
    bp.setCenter(tb);

    Scene scene = new Scene(bp, 800, 600, Color.rgb(45, 52, 71));

    scene.getStylesheets().add("style.css");
    stage.setTitle("FDM - Trainer Skills");
    stage.setScene(scene);
    stage.show();
   }

   public static TabPane createTabs (){
     TabPane tabPane = new TabPane();

     Tab tab = new Tab();
     Image imag = new Image("search.png", 60, 60, false, false);
     ImageView imgVie = new ImageView(imag);
     tab.setGraphic(imgVie);
     tab.setContent(
     Search()
     );
     tabPane.getTabs().add(tab);

     Tab tab1 = new Tab();
     Image ima = new Image("search.jpg", 60, 60, false, false);
     ImageView imgVi = new ImageView(ima);
     tab1.setGraphic(imgVi);
     tab1.setContent(new Text("hi"));
     tabPane.getTabs().add(tab1);

     Tab tab2 = new Tab();
     Image im = new Image("Picture3.png", 60, 60, false, false);
     ImageView imgV = new ImageView(im);
     tab2.setGraphic(imgV);
     tab2.setContent(new Text("hi"));
     tabPane.getTabs().add(tab2);

     Tab tab3 = new Tab();
     Image i = new Image("Picture3.png", 60, 60, false, false);
     ImageView imgVe = new ImageView(i);
     tab3.setGraphic(imgVe);
     tab3.setContent(new Text("hi"));
     tabPane.getTabs().add(tab3);
     tabPane.getStylesheets().add("style.css");

     return tabPane;
   }

   public static GridPane displayUser(){
     GridPane gp = new GridPane();
     gp.setId("gp");
     gp.setPadding(new Insets(40));

     Image im = new Image("Picture3.png", 100, 100, false, false);
     ImageView imgV = new ImageView(im);
     gp.getChildren().add(imgV);
     gp.setHalignment(imgV, HPos.CENTER);
     gp.setHgap(10);

     String[] arr = {"Kahludi","Al Falluga","Admin","A190","01-01-2001"};
     gp.addRow(1, new Text("Forename:"), new Text(arr[0]));
     gp.addRow(2, new Text("Surname:"), new Text(arr[1]));
     gp.addRow(3, new Text("Account Type:"), new Text(arr[2]));
     gp.addRow(4, new Text("Unique Identifier:"), new Text(arr[3]));
     gp.addRow(5, new Text("Account made:"), new Text(arr[4]));
     gp.setVgap(10);
     gp.setColumnSpan(imgV, 2);

     return gp;
   }

   public static TextField displaySearch(){
     //Example Function
     System.out.println("qwerty");
     TextField s = new TextField("works!");
     return s;
   }

   public static GridPane Search(){
     GridPane gr = new GridPane();
     gr.setPadding(new Insets(20));

     TextField bool = new TextField("false");
     Button btns = new Button("Q");

     TextField search=new TextField();
     search.setPrefWidth(250);
     search.getStyleClass().add("tf");
     search.setPromptText("search");
     gr.addRow(0, search, btns);
     gr.setGridLinesVisible(true);
     Button btnC = new Button("Clear");

     btns.setOnMouseClicked((MouseEvent event) -> {
             //set textfield values
             TextField b = displaySearch();
             String[] ar = passUsers();
             for (int x = 1; x < 5; x++){
               Button r = new Button(ar[x]);
               gr.addRow(x, r);
               r.setOnMouseClicked((MouseEvent evnt) -> {
                 TextField s = displaySearch();
                 gr.getChildren().clear();
                 gr.addRow(0, displayResult(r, btnC));
               });
             }
             gr.addRow(5, b);
             gr.addRow(6, btnC);
         });

     btnC.setOnMouseClicked((MouseEvent event) -> {
             //set textfield values
             gr.getChildren().clear();
             gr.addRow(0, search, btns);
     });
     return gr;
   }

   public static String[] passUsers(){
     String[] arr  = {"", "b", "c", "d", "e"};
     return arr;
   }

   public static VBox displayResult(Button result, Button reset){
     String chosen = result.getText();
     Image i = new Image("Picture3.png", 60, 60, false, false);
     ImageView imgVe = new ImageView(i);
     VBox v = new VBox();
     Text te = new Text("vmekppwekgmropm5g4");
     v.getChildren().addAll(imgVe, result, te, reset);
     return v;
   }

}
