package GUI;

import Forsikring.BilForsikring;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import Person.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import Kontroller.Postregister;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBil implements ComboBoxConverter {

    public Pane bilFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du bilforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb); //TOP

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
        lbPerson.setId("lbPerson");
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

        TextField postSted = new TextField();
        postSted.setPromptText("PostSted");
        postSted.setEditable(false);
        postSted.setMinWidth(200);

        tfPostnr.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Postregister register = new Postregister();
                String poststed = register.getPoststed(tfPostnr.getText());
                if (poststed == null) {
                    poststed = "Eksisterer ikke!";
                }
                postSted.setText(poststed);
            }
        });

        //Bil
        Label lbBil = new Label();
        lbBil.setText("Bil innformasjon");
        lbBil.setId("lbBil");
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

        //Registrer knapp & Label & Toggle
        Label lbvelgEier = new Label();
        lbvelgEier.setText("Annen eier?");
        lbvelgEier.setId("velgeier");
        lbvelgEier.setAlignment(Pos.CENTER);

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

        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Beregn Pris");
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

            Person person;
            if (rbtJa.selectedProperty().getValue()) {
                person = new Person(tfFornavn.getText(), tfEtternavn.getText(), tfPersonnr.getText(), tfAdresse.getText(), tfPostnr.getText(), tfTelefon.getText());
            } else {
                person = null;
            }
            double bonus = 0;
            double egenandel = 0;
            int kjøreLengde = 0;
            String regNo = tfRegnr.getText();
            String årsModell = tfÅrsmodell.getText();
            String bilType = tfBiltype.getText();
            int kmStand = 0;
            try {
                bonus = convertDou(cbBonus.getValue());
                egenandel = convertDou(cbEgenandel.getValue());
                kjøreLengde = convertInt(cbKjørelengde.getValue());
                kmStand = Integer.parseInt(tfKmstand.getText());

            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat");
            }
            BilForsikring bil = new BilForsikring(bonus, egenandel, kjøreLengde, regNo, årsModell, bilType, kmStand);
            kontroll.setBilForsikring(bil, person);
            regLabel.setText("Bilforsikring Registrert!");

        });

        gridleft.add(lbBil, 0, 0);
        gridleft.add(tfRegnr, 0, 1);
        gridleft.add(tfÅrsmodell, 0, 2);
        gridleft.add(tfBiltype, 0, 3);
        gridleft.add(tfKmstand, 0, 4);
        gridleft.add(cbBonus, 0, 5);
        gridleft.add(cbEgenandel, 0, 6);
        gridleft.add(cbKjørelengde, 0, 7);
        gridleft.add(lbvelgEier, 0, 8);
        gridleft.add(rbtJa, 0, 9);
        gridleft.add(rbtNei, 0, 10);

        gridright.add(lbPerson, 0, 0);
        gridright.add(tfFornavn, 0, 1);
        gridright.add(tfEtternavn, 0, 2);
        gridright.add(tfPersonnr, 0, 3);
        gridright.add(tfTelefon, 0, 4);
        gridright.add(tfAdresse, 0, 5);
        gridright.add(tfPostnr, 0, 6);
        gridright.add(postSted, 0, 7);

        gridcenter.add(btnSjekkpris, 0, 11);
        gridcenter.add(btnRegBilforsikring, 0, 12);
        gridcenter.add(regLabel, 0, 13);

        borderPane.setLeft(gridleft); // Left

        borderPane.setCenter(gridcenter); //Center

        //borderPane.setRight(gridright); //Right
        borderPane.getStylesheets().add("CSS/kundeBil.css");

        return borderPane;

    }
}
