package GUI;

import Forsikring.BatForsikring;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import java.text.DecimalFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBåt implements ComboBoxConverter {

    private String type;

    public Pane båtFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du båtforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb); //TOP

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);

        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);

        GridPane gridleft = new GridPane();
        gridleft.setAlignment(Pos.TOP_CENTER);
        gridleft.setHgap(10);
        gridleft.setVgap(10);
        gridleft.setPadding(new Insets(10));
        gridleft.setPrefHeight(50);
        gridleft.setPrefWidth(400);

        GridPane gridright = new GridPane();
        gridright.setAlignment(Pos.TOP_CENTER);
        gridright.setHgap(10);
        gridright.setVgap(10);
        gridright.setPadding(new Insets(10));
        gridright.setPrefHeight(50);
        gridright.setPrefWidth(400);

        GridPane gridcenter = new GridPane();
        gridcenter.setAlignment(Pos.CENTER);
        gridcenter.setHgap(10);
        gridcenter.setVgap(10);
        gridcenter.setPadding(new Insets(10));
        gridcenter.setPrefHeight(50);
        gridcenter.setPrefWidth(200);

        //Båt
        Label lbBåt = new Label();
        lbBåt.setText("Båt innformasjon");
        lbBåt.setAlignment(Pos.CENTER);

        TextField tfVerdi = new TextField();
        tfVerdi.setPromptText("Båtens verdi");
        tfVerdi.setMinWidth(200);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        TextField tfBåtmodell = new TextField();
        tfBåtmodell.setPromptText("Båtmodell eks (Ibiza 22");
        tfBåtmodell.setMinWidth(200);

        TextField tfAntfot = new TextField();
        tfAntfot.setPromptText("Antall fot");
        tfAntfot.setMinWidth(200);

        TextField tfMotormerke = new TextField();
        tfMotormerke.setPromptText("Motormerke");
        tfMotormerke.setMinWidth(200);

        TextField tfYtelse = new TextField();
        tfYtelse.setPromptText("Ytelse (hk)");
        tfYtelse.setMinWidth(200);

        ToggleGroup båtType = new ToggleGroup();
        RadioButton rbtSeilbåt = new RadioButton("Seilbåt");
        rbtSeilbåt.setToggleGroup(båtType);
        rbtSeilbåt.setSelected(true);
        rbtSeilbåt.setOnAction(e -> {
            type = "Seilbåt";
        });

        RadioButton rbtMotorbåt = new RadioButton("Motorbåt");
        rbtMotorbåt.setToggleGroup(båtType);
        rbtMotorbåt.setSelected(true);
        rbtMotorbåt.setOnAction(e -> {
            type = "Motorbåt";
        });

        //Registrer knapp & Label
        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        

        Button btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Registrer Båtforsikring");
        btnRegBåtforsikring.setId("btnRegBåtforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        
        
      //Lyttere_________________________________________________________________________  
        
        btnSjekkpris.setOnAction(e -> {
            String form = "0.00";
            DecimalFormat tall = new DecimalFormat(form);
            String regNo = tfRegnr.getText();
            String modell = tfBåtmodell.getText();
            String årsModell = tfÅrsmodell.getText();
            String motorMerke = tfMotormerke.getText();

            int motorYtelse = 0;
            double verdi = 0;
            int lengdeFot = 0;

            try {
                verdi = Double.parseDouble(tfVerdi.getText());
                motorYtelse = Integer.parseInt(tfYtelse.getText());
                lengdeFot = Integer.parseInt(tfAntfot.getText());
                BatForsikring båt = new BatForsikring(verdi, lengdeFot, regNo, type, modell, årsModell);
                båt.beregnPremie();
                regLabel.setText("Prisen er: " + tall.format(båt.getPremie()) + " kr");
            } catch (NumberFormatException nfe) {
                System.out.println("feil tallformat");
            }

            
        });
        
        
        btnRegBåtforsikring.setOnAction(e -> {
            regLabel.setText("Båtforsikring Registrert!");
            String regNo = tfRegnr.getText();
            String modell = tfBåtmodell.getText();
            String årsModell = tfÅrsmodell.getText();
            String motorMerke = tfMotormerke.getText();

            int motorYtelse = 0;
            double verdi = 0;
            int lengdeFot = 0;

            try {
                verdi = Double.parseDouble(tfVerdi.getText());
                motorYtelse = Integer.parseInt(tfYtelse.getText());
                lengdeFot = Integer.parseInt(tfAntfot.getText());
                BatForsikring båt = new BatForsikring(verdi, lengdeFot, regNo, type, modell, årsModell);
                båt.beregnPremie();
                båt.beregnEgenAndel();
                kontroll.setBåtForsikring(båt);
            } catch (NumberFormatException nfe) {
                System.out.println("feil tallformat");
            }

            regLabel.setText("Bilforsikring Registrert!");
        });

        grid.add(lbBåt, 0, 0);
        grid.add(tfVerdi, 0, 1);
        grid.add(tfRegnr, 0, 2);
        grid.add(tfÅrsmodell, 0, 3);
        grid.add(tfBåtmodell, 0, 4);
        grid.add(tfAntfot, 0, 5);
        grid.add(tfMotormerke, 0, 6);
        grid.add(tfYtelse, 0, 7);
        grid.add(rbtSeilbåt, 0, 8);
        grid.add(rbtMotorbåt, 0, 9);
        grid.add(btnSjekkpris, 0, 10);
        grid.add(btnRegBåtforsikring, 0, 11);
        grid.add(regLabel, 0, 12);

        borderPane.setCenter(grid); // CENTER

        return borderPane;
    }
}
