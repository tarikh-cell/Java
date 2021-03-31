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
import javafx.scene.text.*;
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
import javafx.geometry.Orientation;

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

    VBox grp = displayUser();
    GridPane gdp = Search();
    TabPane tb = createTabs();

    //bp.setLeft(grp);
    bp.setLeft(grp);
    bp.setCenter(tb);

    Scene scene = new Scene(bp, 800, 600, Color.rgb(45, 52, 71));

    scene.getStylesheets().add("style.css");
    stage.setTitle("FDM - Trainer Skills");
    stage.setScene(scene);
    stage.show();
   }

   public static VBox displayUser(){
     VBox users = new VBox();
     users.setId("pr");

     Text prf = new Text("Profile");
     prf.setId("prf");
     TextFlow textFlow = new TextFlow();
     textFlow.getChildren().add(prf);
     textFlow.setTextAlignment(TextAlignment.CENTER);
     textFlow.setPadding(new Insets(13,0,0,0));
     users.getChildren().add(textFlow);

     VBox display = new VBox();
     display.setId("dsp");
     display.setPadding(new Insets(0, 10, 0, 10));
     display.setSpacing(10);
     Image im = new Image("Picture3.png", 100, 100, false, false);
     ImageView imgV = new ImageView(im);
     display.getChildren().add(imgV);

     Text[] titles = {new Text("Forename:"),new Text("Surname:"), new Text("Account Type:"), new Text("Unique Identifier:"), new Text("Account made:")};
     Text[] arr = {new Text("Kahludi"),new Text("Al Falluga"),new Text("Admin"),new Text("A190"),new Text("01-01-2001")};
     for(int i = 0; i < 9; i+=2){
       String str = titles[(i/2)].getText() + " " + arr[(i/2)].getText();
       Text row = new Text(str);
       Separator separator2 = new Separator();
       separator2.setOrientation(Orientation.HORIZONTAL);
       display.getChildren().add(row);
       display.getChildren().add(separator2);
      }
    display.setAlignment(Pos.CENTER);
    users.setSpacing(30);
    users.getChildren().add(display);

     return users;
   }

   public static TabPane createTabs(){
     TabPane tabPane = new TabPane();

     Tab tab = new Tab();
     tab.setText("Search");
     tab.setContent(
     Search()
     );
     tab.setClosable(false);
     tabPane.getTabs().add(tab);

     Tab tab1 = new Tab();
     tab1.setText("Add/Remove");
     tab1.setContent(new Text("hi"));
     tab1.setClosable(false);
     tabPane.getTabs().add(tab1);

     Tab tab2 = new Tab();
     tab2.setText("Survey");
     tab2.setContent(new Text("hi"));
     tab2.setClosable(false);
     tabPane.getTabs().add(tab2);

     Tab tab3 = new Tab();
     tab3.setText("Monitor User Activity");
     tab3.setContent(new Text("hi"));
     tab3.setClosable(false);
     tabPane.getTabs().add(tab3);

     return tabPane;
   }

   public static GridPane displayUsers(){
     GridPane gp = new GridPane();
     gp.setId("gp");
     gp.setPadding(new Insets(40));

     Image im = new Image("Picture3.png", 100, 100, false, false);
     ImageView imgV = new ImageView(im);
     gp.getChildren().add(imgV);
     gp.setHalignment(imgV, HPos.CENTER);



     Text[] titles = {new Text("Forename:"),new Text("Surname:"), new Text("Account Type:"), new Text("Unique Identifier:"), new Text("Account made:")};
     Text[] arr = {new Text("Kahludi"),new Text("Al Falluga"),new Text("Admin"),new Text("A190"),new Text("01-01-2001")};
     for(int i = 0; i < 9; i+=2){
       titles[i/2].setFill(Color.WHITE);
       arr[i/2].setFill(Color.WHITE);
       Separator separator2 = new Separator();
       separator2.setOrientation(Orientation.HORIZONTAL);
       gp.addRow(i + 1, titles[(i/2)], arr[(i/2)]);
       gp.addRow(i + 2, separator2);
       gp.setColumnSpan(separator2, 2);
      }

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
     gr.setPadding(new Insets(40, 0, 0, 80));

     TextField bool = new TextField("false");
     Button btns = new Button("Q");
     btns.setId("btns");

     TextField search=new TextField();
     search.setId("tf");

     search.setPromptText("search");
     gr.addRow(0, search, btns);
     gr.setGridLinesVisible(false);
     Button btnC = new Button("Clear");
     btnC.setId("clearButton");

     btns.setOnMouseClicked((MouseEvent event) -> {
             //set textfield values
             //TextField b = new TextField(search.getText());
             String[] ar = passUsers();
             for (int x = 1; x < 5; x++){
               Button r = new Button(ar[x]);
               r.setId("ed");
               gr.addRow(x, r);
               search.setStyle("-fx-background-radius: 20 0 0 0;");
               btns.setStyle("-fx-background-radius: 0 20 0 0;");
               gr.setColumnSpan(r, 2);
               r.setOnMouseClicked((MouseEvent evnt) -> {
                 TextField s = displaySearch();
                 gr.getChildren().clear();
                 gr.addRow(0, displayResult(r, btnC));
               });
             }
             //gr.addRow(5, b);
             gr.addRow(6, btnC);
             gr.setColumnSpan(btnC, 2);
             search.clear();
         });

     btnC.setOnMouseClicked((MouseEvent event) -> {
             //set textfield values
             gr.getChildren().clear();
             gr.addRow(0, search, btns);
             search.setStyle("-fx-background-radius: 20 0 0 20;");
             btns.setStyle("-fx-background-radius: 0 20 20 0;");
     });
     return gr;
   }

   public static String[] passUsers(){
     String[] arr  = {"", "Name: Khaludi, Id: 19029021", "Name: Khalud, Id: 19029021", "Name: Khaldi, Id: 19029021", "Name: Khalid, Id: 19029021"};
     return arr;
   }

   public static VBox displayResult(Button result, Button reset){
     String chosen = result.getText();
     Image i = new Image("Picture3.png", 60, 60, false, false);
     ImageView imgVe = new ImageView(i);
     VBox v = new VBox();
     Button te = new Button("Course: Software Engineering");
     te.setId("course");
     Button te2 = new Button("Qualification: Software Engineering Degree");
     te2.setId("qualification");
     Button te3 = new Button("Region: London");
     te3.setId("region");
     v.getChildren().addAll(imgVe, result, te, te2, te3, reset);
     return v;
   }

   public static void Add(){
     TextField addUser = new TextField("Add User to System");
   }

}
