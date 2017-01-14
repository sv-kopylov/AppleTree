
package appletree;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AppleTree extends Application {
   String Message; 
   String Rad;
   
         
   
    @Override
    public void start(Stage primaryStage) {
        
        WebView bro = new WebView();
        
        TextField EnterRad = new TextField();
        EnterRad.setPrefColumnCount(4);
        Label EnterRadLbl = new Label("Радиус приствольного круга в сантиметрах: ");
        
        EnterRad.setOnAction((ActionEvent event) -> {
            Rad = EnterRad.getText();
            Message = new Processor().CalcAndSay(Rad);
            bro.getEngine().loadContent(Message);
        });
                
        
        Button btn = new Button("Посчитать");
        
        btn.setOnAction((ActionEvent event) -> {
            Rad = EnterRad.getText();
            Message = new Processor().CalcAndSay(Rad);
            bro.getEngine().loadContent(Message);
        });
        
        
        Font font = new Font("Arial", 16);
        EnterRadLbl.setFont(font);
        EnterRad.setFont(font);
        btn.setFont(font);
        font = new Font("Arial", 22);
        BorderPane root = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #e7db9d;");
        
        hbox.getChildren().addAll(EnterRadLbl, EnterRad, btn);
        root.setTop(hbox);
        
        GridPane grid = new GridPane();
      // grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        

//      Image Atree = new Image("file:Atree.jpg", true);
        Image Atree = new Image(getClass().getResourceAsStream("/Atree.jpg"));
      ImageView ivAtree = new ImageView(Atree);
       
       bro.setPrefSize(400, 409);
       
//       grid.setPrefSize(700, 600);
       grid.add(bro, 1, 0);      
       grid.add(ivAtree, 0, 0);
                
        root.setCenter(grid);
        
        
        
        Scene scene = new Scene(root, 675, 480);
        // (root, 730, 668)
        primaryStage.setTitle("AppleTree");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

  
    public static void main(String[] args) {
        launch(args);
    }
    
}
