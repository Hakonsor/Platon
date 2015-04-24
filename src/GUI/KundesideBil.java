package GUI;

import Kontroller.Kontroller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBil {

    public static Pane bilFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du bilforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb); //TOP


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BOTTOM_CENTER);
        grid.setHgap(10);

        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);


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


        //Bil

        Label lbBil = new Label();
        lbBil.setText("Bil innformasjon");
        lbBil.setAlignment(Pos.CENTER);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        TextField tfBiltype = new TextField();
        tfBiltype.setPromptText("Biltype eks (BMW 3-serie)");
        tfBiltype.setMinWidth(200);

        TextField tfKmstand = new TextField();
        tfKmstand.setPromptText("Km-stand");
        tfKmstand.setMinWidth(200);

        ComboBox<String> cbKjørelengde = new ComboBox<>();
        cbKjørelengde.setEditable(false);
        cbKjørelengde.setMinWidth(200);
        cbKjørelengde.getItems().addAll(
                "Kjørelengde:  5 000 km",
                "Kjørelengde: 10 000 km",
                "Kjørelengde: 20 000 km",
                "Kjørelengde: 30 000 km",
                "Kjørelengde: Ubegrenset"
        );
        cbKjørelengde.setValue("Velg Kjørelengde:");

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

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> {
            regLabel.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Registrer Bilforsikring");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);
        btnRegBilforsikring.setOnAction(e -> {
            
            tfRegnr.getText();
            tfÅrsmodell.getText();
            tfBiltype.getText();
            tfKmstand.getText();
            int indexBonus = cbBonus.getItems().indexOf(cbBonus.getValue());
            int indexEgenandel = cbEgenandel.getItems().indexOf(cbEgenandel.getValue());
            int indexKjorelengde = cbKjørelengde.getItems().indexOf(cbKjørelengde.getValue());
            int integer = 0;
            //kontroll.setForsikring(indexBonus, indexEgenandel, 0/*tlf*/, indexKjorelengde, null/*fornavn*/, null /*etternavn*/, null/*personnummer*/, null /*gateadr*/, tfRegnr.getText(), tfBiltype.getText(), tfÅrsmodell.getText(),/*int Skadefri?*/ 0  );
            //work in progress
            kontroll.setForsikring(indexBonus, indexEgenandel, 
                    tfTelefon.getText(), indexKjorelengde, 
                    tfFornavn.getText(), tfEtternavn.getText(), 
                    tfPersonnr.getText(), tfPostnr.getText(), 
                    tfRegnr.getText(), tfÅrsmodell.getText(), 
                    tfBiltype.getText(), tfKmstand.getText() );
            
            regLabel.setText("Bilforsikring Registrert!");
        });

        grid.add(lbBil, 0, 0);
        grid.add(lbPerson, 2, 0);

        grid.add(tfRegnr, 0, 1);
        grid.add(tfFornavn, 2, 1);

        grid.add(tfÅrsmodell, 0, 2);
        grid.add(tfEtternavn, 2, 2);

        grid.add(tfBiltype, 0, 3);
        grid.add(tfPersonnr, 2, 3);

        grid.add(tfKmstand, 0, 4);
        grid.add(tfTelefon, 2, 4);

        grid.add(cbBonus, 0, 5);
        grid.add(tfAdresse, 2, 5);

        grid.add(cbEgenandel, 0, 6);
        grid.add(tfPostnr, 2, 6);

        grid.add(cbKjørelengde, 0, 7);


        grid.add(btnSjekkpris, 1, 9);
        grid.add(btnRegBilforsikring, 1, 10);

        grid.add(regLabel, 1, 11);




        borderPane.setCenter(grid); // CENTER

        return borderPane;
    }
}
