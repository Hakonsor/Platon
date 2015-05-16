package GUI;

import Kontroller.Kontroller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Magnus on 12.05.15.
 */
public class infoMelding {

    private Kontroller kontroll;
    private BorderPane borderPane;
    private VBox vBox;
    private Button lukk;
    private TextArea print;
    private Label info;
    private Label reg;
    private static Stage vindu;
    public Scene scene;

    public infoMelding(Stage vindu, Kontroller kontroll) {
        this.vindu = vindu;
        
        this.kontroll = kontroll;
        vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20));

        info = new Label();
        info.setText("Velkommen som ny kunde hos oss!");
        info.setId("info");

        reg = new Label();
        reg.setText("Registrert Info:");
        reg.setId("reg");

        print = new TextArea();
        print.setPrefSize(250, 400);
        print.setId("print");
        print.setText("Her må det legges inn kunde \n" + "-info på siste registrerte!!!");
        print.setEditable(false);

        lukk = new Button();
        lukk.setText("Lukk");
        lukk.setId("lukk");
        lukk.setMinWidth(200);
        lukk.setOnAction(e -> {
            vindu.close();
        });

        vBox.getChildren().addAll(info, reg, print,lukk);
        
        print.setText(kontroll.getsisteKunde());
        //setText();
        
        

        scene = new Scene(vBox, 450, 525);
        vindu.setTitle("Dine opplysninger");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/infoMelding.css");
        vindu.show();
    }
    
    public String setText(){
       String textfelt = "";
       textfelt += kontroll.getsisteKunde();
       return textfelt;
        
        
    }


}//End of class
