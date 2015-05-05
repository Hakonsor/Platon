package GUI;

import Forsikring.BilForsikring;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import Kontroller.Postregister;
import Person.Person;
import java.text.DecimalFormat;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.VBox;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBil implements ComboBoxConverter {

    public Pane bilFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");

        HBox vb2 = new HBox();
        vb2.setPadding(new Insets(25, 25, 0, 25));
        vb2.setSpacing(100);
        vb2.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du bilforsikring");
        overskrift.setId("overskrift");
        vb2.getChildren().addAll(overskrift);

        borderPane.setTop(vb2); //TOP

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        GridPane gridBil = new GridPane();
        gridBil.setAlignment(Pos.TOP_CENTER);
        gridBil.setHgap(10);
        gridBil.setVgap(10);
        gridBil.setPadding(new Insets(3));

        GridPane gridPerson = new GridPane();
        gridPerson.setAlignment(Pos.TOP_CENTER);
        gridPerson.setHgap(10);
        gridPerson.setVgap(10);
        gridPerson.setPadding(new Insets(3));
        gridPerson.setVisible(false);

        GridPane gridcenter = new GridPane();
        gridcenter.setAlignment(Pos.CENTER);
        gridcenter.setHgap(10);
        gridcenter.setVgap(10);
        gridcenter.setPadding(new Insets(10));

        hb.getChildren().addAll(gridBil, gridPerson);

        //Person
        Label lbPerson = new Label();
        lbPerson.setText("Bileier innformasjon");
        lbPerson.setId("lbPerson");
        lbPerson.setAlignment(Pos.CENTER);

        TextField tfFornavn = new TextField();
        tfFornavn.setPromptText("Fornavn");
        tfFornavn.setId("promtfix");
        tfFornavn.setMinWidth(200);

        TextField tfEtternavn = new TextField();
        tfEtternavn.setPromptText("Etternavn");
        tfEtternavn.setId("promtfix");
        tfEtternavn.setMinWidth(200);

        TextField tfPersonnr = new TextField();
        tfPersonnr.setPromptText("PersonNr");
        tfPersonnr.setId("promtfix");
        tfPersonnr.setMinWidth(200);

        TextField tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setId("promtfix");
        tfAdresse.setMinWidth(200);

        TextField tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setId("promtfix");
        tfPostnr.setMinWidth(200);

        TextField tfTelefon = new TextField();
        tfTelefon.setPromptText("Telefon");
        tfTelefon.setId("promtfix");
        tfTelefon.setMinWidth(200);

        TextField postSted = new TextField();
        postSted.setPromptText("PostSted");
        postSted.setId("promtfix");
        postSted.setEditable(false);
        postSted.setMinWidth(200);

        tfPostnr.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            Postregister register = new Postregister();
            String poststed = register.getPoststed(tfPostnr.getText());
            if (poststed == null) {
                poststed = "Finnes ikke!";
            }
            if (tfPostnr.getText().equals("")) {
                postSted.setText("");
                postSted.setPromptText("PostSted");
            } else {
                postSted.setText(poststed);
            }
        });

        //Bil
        Label lbBil = new Label();
        lbBil.setText("Bil innformasjon");
        lbBil.setId("promtfix");
        lbBil.setAlignment(Pos.CENTER);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setId("promtfix");
        tfRegnr.setMinWidth(200);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setId("promtfix");
        tfÅrsmodell.setMinWidth(200);

        TextField tfMerke = new TextField();
        tfMerke.setPromptText("eks (BMW)");
        tfMerke.setId("promtfix");
        tfMerke.setMinWidth(200);

        TextField tfModell = new TextField();
        tfModell.setPromptText("eks (5-serie 530xd)");
        tfModell.setId("promtfix");
        tfModell.setMinWidth(200);

        TextField tfKmstand = new TextField();
        tfKmstand.setPromptText("Km-stand");
        tfKmstand.setId("promtfix");
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
        rbtJa.setSelected(false);
        rbtJa.setOnAction(e -> {
            gridPerson.setVisible(true);
        });

        RadioButton rbtNei = new RadioButton("NEI");
        rbtNei.setToggleGroup(eiere);
        rbtNei.setId("rbtNei");
        rbtNei.setSelected(true);
        rbtNei.setOnAction(e -> {
            gridPerson.setVisible(false);
        });

        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Beregn Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        

        Button btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Registrer Bilforsikring");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);

        btnSjekkpris.setOnAction((ActionEvent e) -> {

            double bonus = 0;
            double egenandel = 0;
            int kjøreLengde = 0;
            String regNo = tfRegnr.getText();
            String årsModell = tfÅrsmodell.getText();
            String bilMerke = tfMerke.getText();
            String bilModell = tfModell.getText();
            int kmStand = 0;
            try {
                bonus = convertDou(cbBonus.getValue());
                egenandel = convertDou(cbEgenandel.getValue());
                kjøreLengde = convertInt(cbKjørelengde.getValue());
                kmStand = Integer.parseInt(tfKmstand.getText());

            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat");
            }
            BilForsikring bil = new BilForsikring(bonus, egenandel, kjøreLengde,
                    regNo, bilMerke, bilModell, årsModell, kmStand);
            String form = "0.00";
            DecimalFormat tall = new DecimalFormat(form);
            regLabel.setText("Årlig premie: " + tall.format(bil.getPremie()) + " kr");

        });
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
            String bilMerke = tfMerke.getText();
            String bilModell = tfModell.getText();
            int kmStand = 0;
            try {
                bonus = convertDou(cbBonus.getValue());
                egenandel = convertDou(cbEgenandel.getValue());
                kjøreLengde = convertInt(cbKjørelengde.getValue());
                kmStand = Integer.parseInt(tfKmstand.getText());

            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat");
            }
            BilForsikring bil = new BilForsikring(bonus, egenandel, kjøreLengde, regNo, bilMerke, bilModell, årsModell, kmStand);
            kontroll.setBilForsikring(bil, person);
            regLabel.setText("Bilforsikring Registrert!");

        });

        gridBil.add(lbBil, 0, 0);
        gridBil.add(tfRegnr, 0, 1);
        gridBil.add(tfÅrsmodell, 0, 2);
        gridBil.add(tfMerke, 0, 3);
        gridBil.add(tfModell, 0, 4);
        gridBil.add(tfKmstand, 0, 5);
        gridBil.add(cbBonus, 0, 6);
        gridBil.add(cbEgenandel, 0, 7);
        gridBil.add(cbKjørelengde, 0, 8);
        gridBil.add(lbvelgEier, 0, 9);
        gridBil.add(rbtJa, 0, 10);
        gridBil.add(rbtNei, 0, 11);

        gridPerson.add(lbPerson, 0, 0);
        gridPerson.add(tfFornavn, 0, 1);
        gridPerson.add(tfEtternavn, 0, 2);
        gridPerson.add(tfPersonnr, 0, 3);
        gridPerson.add(tfTelefon, 0, 4);
        gridPerson.add(tfAdresse, 0, 5);
        gridPerson.add(tfPostnr, 0, 6);
        gridPerson.add(postSted, 0, 7);

        //gridBil.setGridLinesVisible(true);
        //gridPerson.setGridLinesVisible(true);
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        //vb.setStyle("-fx-border-color: red;");
        vb.getChildren().addAll(hb, btnSjekkpris, btnRegBilforsikring, regLabel);

        borderPane.setCenter(vb); //Center

        //borderPane.setRight(gridPerson); //Right
        borderPane.getStylesheets().add("CSS/kundeBil.css");

        return borderPane;

    }
}
