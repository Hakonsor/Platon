package GUI;

import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import Person.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.LinkedList;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBåt implements ComboBoxConverter{

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


        //Person

        Label lbPerson = new Label();
        lbPerson.setText("Bileier innformasjon");
        lbPerson.setAlignment(Pos.CENTER);

        TextField tfFornavn = new TextField();
        tfFornavn.setPromptText("Fornavn");
        tfFornavn.setMinWidth(200);

        TextField tfEtternavn = new TextField();
        tfEtternavn.setPromptText("Etternavn");
        tfEtternavn.setMinWidth(200);

        TextField tfPersonnr = new TextField();
        tfPersonnr.setPromptText("PersonNr");
        tfPersonnr.setMinWidth(200);

        TextField tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setMinWidth(200);

        TextField tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setMinWidth(200);

        TextField tfTelefon = new TextField();
        tfTelefon.setPromptText("Telefon");
        tfTelefon.setMinWidth(200);


        //Båt

        Label lbBåt = new Label();
        lbBåt.setText("Båt innformasjon");
        lbBåt.setAlignment(Pos.CENTER);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);
        tfRegnr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                
            }
        });




        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        tfÅrsmodell.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String årsmodell = tfÅrsmodell.getText();

                if (årsmodell.length() == 0) {
                    tfÅrsmodell.setId("valid");
                }

                if (!årsmodell.matches(regex) || årsmodell.length() > 4) {
                    tfÅrsmodell.setId("error");
                } else {
                    tfÅrsmodell.setId("valid");
                }
                if (årsmodell.length() == 0) {
                    tfÅrsmodell.setId("valid");
                }
            }
        });






        TextField tfBåtmodell = new TextField();
        tfBåtmodell.setPromptText("Båtmodell eks (Ibiza 22");
        tfBåtmodell.setMinWidth(200);

        TextField tfAntfor = new TextField();
        tfAntfor.setPromptText("Antall fot");
        tfAntfor.setMinWidth(200);

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

        RadioButton rbtYacht = new RadioButton("Yacht");
        rbtYacht.setToggleGroup(båtType);
        rbtYacht.setSelected(true);
        rbtYacht.setOnAction(e -> {
            type = "Yacht";
        });

        RadioButton rbtSnekke = new RadioButton("Snekke");
        rbtSnekke.setToggleGroup(båtType);
        rbtSnekke.setSelected(true);
        rbtSnekke.setOnAction(e -> {
            type = "Snekke";
        });

        RadioButton rbtDaycruiser = new RadioButton("Daycruiser");
        rbtDaycruiser.setToggleGroup(båtType);
        rbtDaycruiser.setSelected(true);
        rbtDaycruiser.setOnAction(e -> {
            type = "Daycruiser";
        });

        RadioButton rbtCabincruiser = new RadioButton("Cabincruiser");
        rbtCabincruiser.setToggleGroup(båtType);
        rbtCabincruiser.setSelected(true);
        rbtCabincruiser.setOnAction(e -> {
            type = "Cabin cruiser";
        });

        RadioButton rbtAndre = new RadioButton("Annet");
        rbtAndre.setToggleGroup(båtType);
        rbtAndre.setSelected(true);
        rbtAndre.setOnAction(e -> {
            type = "Annet";
        });

        ComboBox<String> cbBonus = new ComboBox<>();
        cbBonus.setEditable(false);
        cbBonus.setMinWidth(200);
        cbBonus.getItems().addAll(
                "Bonus: -20%",
                "Bonus: -10%",
                "Bonus: 0%",
                "Bonus: 10%",
                "Bonus: 20%",
                "Bonus: 30%",
                "Bonus: 40%",
                "Bonus: 50%",
                "Bonus: 60%",
                "Bonus: 70%",
                "Bonus: 75%"
        );
        cbBonus.setValue("Velg Bonus:");

        ComboBox<String> cbEgenandel = new ComboBox<>();
        cbEgenandel.setEditable(false);
        cbEgenandel.setMinWidth(200);
        cbEgenandel.getItems().addAll(
                "Egenandel:  4 000,-",
                "Egenandel:  6 000,-",
                "Egenandel: 10 000,-"
        );
        cbEgenandel.setValue("Velg Egenandel:");

        //Registrer knapp & Label

        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        ToggleGroup eiere = new ToggleGroup();

        RadioButton rbtJa = new RadioButton("JA");
        rbtJa.setToggleGroup(eiere);
        rbtJa.setId("rbtJa");
        rbtJa.setSelected(true);
        rbtJa.setOnAction(e -> {
            borderPane.setRight(gridright);
            System.out.println("Du har valgt Ja! =D");
        });

        RadioButton rbtNei = new RadioButton("NEI");
        rbtNei.setToggleGroup(eiere);
        rbtNei.setId("rbtNei");
        rbtNei.setSelected(true);
        rbtNei.setOnAction(e -> {
            borderPane.setRight(null);
            System.out.println("Du har valgt Nei");
        });

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> {
            regLabel.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Registrer Båtforsikring");
        btnRegBåtforsikring.setId("btnRegBåtforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        btnRegBåtforsikring.setOnAction(e -> {



            if(tfÅrsmodell.getId().equals("valid")){
                regLabel.setText("Båtforsikring Registrert!");
                Person person;
                if (rbtJa.selectedProperty().getValue())
                    person = new Person(tfFornavn.getText(), tfEtternavn.getText(), tfPersonnr.getText(), tfAdresse.getText(), tfPostnr.getText(), tfTelefon.getText());
                else
                    person = null;


                int effekt = 0;

                try {
                    effekt = Integer.parseInt(tfYtelse.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Dette er en feilmelding opprettet i KundesideBåt.java\n" +
                            "En feil ved parsing av motoreffekt fra string til tall har oppstått\n" + nfe.toString());
                }


                kontroll.setForsikring(convertDou(cbBonus.getValue()), convertDou(cbEgenandel.getValue()), tfRegnr.getText(), tfÅrsmodell.getText(), tfBåtmodell.getText(), tfAntfor.getText(), tfMotormerke.getText(), effekt, type, person);
                regLabel.setText("Bilforsikring Registrert!");
            }else{
                regLabel.setText("Fargeblind bro?!");
            }
        });

        /*
        setForsikring(double bonus, double egenandel,
                              String regNr, String arsmodell, String modell, String tffot, String motor, int ytelse, String type, Person person){

         */

        grid.add(lbBåt, 0, 0);
        grid.add(lbPerson, 2, 0);

        grid.add(tfRegnr, 0, 1);
        grid.add(tfFornavn, 2, 1);

        grid.add(tfÅrsmodell, 0, 2);
        grid.add(tfEtternavn, 2, 2);

        grid.add(tfBåtmodell, 0, 3);
        grid.add(tfPersonnr, 2, 3);

        grid.add(tfAntfor, 0, 4);
        grid.add(tfTelefon, 2, 4);

        grid.add(tfMotormerke, 0, 5);
        grid.add(tfAdresse, 2, 5);

        grid.add(tfYtelse, 0, 6);

        grid.add(cbEgenandel, 0, 7);
        grid.add(tfPostnr, 2, 6);

        grid.add(cbBonus, 0, 8);

        grid.add(rbtCabincruiser, 1, 1);
        grid.add(rbtDaycruiser, 1, 2);
        grid.add(rbtSeilbåt, 1, 3);
        grid.add(rbtSnekke, 1, 4);
        grid.add(rbtYacht, 1, 5);
        grid.add(rbtAndre, 1, 6);


        grid.add(btnSjekkpris, 1, 13);
        grid.add(btnRegBåtforsikring, 1, 14);

        grid.add(regLabel, 1, 15);




        borderPane.setCenter(grid); // CENTER

        borderPane.getStylesheets().add("CSS/error.css");

        return borderPane;

    }


}