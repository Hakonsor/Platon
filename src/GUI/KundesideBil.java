package GUI;

import Forsikring.BilForsikring;
import Forsikring.Forsikringer;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import Kontroller.Postregister;
import Person.Person;
import java.text.DecimalFormat;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
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
import javafx.util.Duration;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBil implements ComboBoxConverter {


    private BorderPane borderPane;
    private HBox hb;
    private GridPane gridBil;
    private GridPane gridPerson;
    private Label lbPerson;
    private TextField tfFornavn;
    private TextField tfEtternavn;
    private TextField tfPersonnr;
    private TextField tfAdresse;
    private TextField tfPostnr;
    private TextField tfTelefon;
    private TextField postSted;
    private Label lbBil;
    private TextField tfRegnr;
    private TextField tfÅrsmodell;
    private TextField tfMerke;
    private TextField tfModell;
    private TextField tfKmstand;
    private ComboBox<String> cbKjørelengde;
    private ComboBox<String> cbBonus;
    private ComboBox<String> cbEgenandel;
    private Label lbvelgEier;
    private ToggleGroup eiere;
    private RadioButton rbtJa;
    private RadioButton rbtNei;
    private Label regLabel;
    private Button btnSjekkpris;
    private Button btnRegBilforsikring;
    private HBox hbKnapper;
    private VBox vb;
    private Kontroller kontroller;




    public Pane bilFane(Kontroller kontroll) {
        this.kontroller = kontroll;
        borderPane = new BorderPane();
        borderPane.setId("borderpane");

        hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        gridBil = new GridPane();
        gridBil.setAlignment(Pos.TOP_CENTER);
        gridBil.setHgap(10);
        gridBil.setVgap(10);

        gridPerson = new GridPane();
        gridPerson.setAlignment(Pos.TOP_CENTER);
        gridPerson.setHgap(10);
        gridPerson.setVgap(10);
        gridPerson.setVisible(false);

        hb.getChildren().addAll(gridBil, gridPerson);

        //Person
        lbPerson = new Label();
        lbPerson.setText("Bileier innformasjon");
        lbPerson.setId("lbPerson");
        lbPerson.setAlignment(Pos.CENTER);

        tfFornavn = new TextField();
        tfFornavn.setPromptText("Fornavn");
        tfFornavn.setId("promtfix");
        tfFornavn.setMinWidth(200);
        tfFornavn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z]+";
                String fornavn = tfFornavn.getText();

                if (fornavn.matches(regex)) {
                    tfFornavn.setId("valid");
                } else {
                    tfFornavn.setId("error");
                }
                if (fornavn.length() == 0) {
                    tfFornavn.setId("promtfix");
                }
            }
        });

        tfEtternavn = new TextField();
        tfEtternavn.setPromptText("Etternavn");
        tfEtternavn.setId("promtfix");
        tfEtternavn.setMinWidth(200);
        tfEtternavn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z]+";
                String etternavn = tfEtternavn.getText();

                if (etternavn.matches(regex)) {
                    tfEtternavn.setId("valid");
                } else {
                    tfEtternavn.setId("error");
                }
                if (etternavn.length() == 0) {
                    tfEtternavn.setId("promtfix");
                }
            }
        });

        tfPersonnr = new TextField();
        tfPersonnr.setPromptText("PersonNr");
        tfPersonnr.setId("promtfix");
        tfPersonnr.setMinWidth(200);
        tfPersonnr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String personnr = tfPersonnr.getText();

                if (!personnr.matches(regex) || personnr.length() > 11 || personnr.length() < 11) {
                    tfPersonnr.setId("error");
                } else {
                    tfPersonnr.setId("valid");
                }
                if (personnr.length() == 0) {
                    tfPersonnr.setId("promtfix");
                }
            }
        });

        tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setId("promtfix");
        tfAdresse.setMinWidth(200);
        tfAdresse.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z0-9 _]+";
                String adresse = tfAdresse.getText();

                if (adresse.matches(regex)) {
                    tfAdresse.setId("valid");
                } else {
                    tfAdresse.setId("error");
                }
                if (adresse.length() == 0) {
                    tfAdresse.setId("promtfix");
                }
            }
        });

        tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setId("promtfix");
        tfPostnr.setMinWidth(200);
        tfPostnr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String postnr = tfPostnr.getText();

                if (!postnr.matches(regex) || postnr.length() > 4 || postnr.length() < 4) {
                    tfPostnr.setId("error");
                } else {
                    tfPostnr.setId("valid");
                }
                if (postnr.length() == 0) {
                    tfPostnr.setId("promtfix");
                }
            }
        });

        tfTelefon = new TextField();
        tfTelefon.setPromptText("Telefon");
        tfTelefon.setId("promtfix");
        tfTelefon.setMinWidth(200);
        tfTelefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String telefon = tfTelefon.getText();

                if (!telefon.matches(regex) || telefon.length() > 8 || telefon.length() < 8) {
                    tfTelefon.setId("error");
                } else {
                    tfTelefon.setId("valid");
                }
                if (telefon.length() == 0) {
                    tfTelefon.setId("promtfix");
                }
            }
        });

        postSted = new TextField();
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
        lbBil = new Label();
        lbBil.setText("Bil innformasjon");
        lbBil.setId("promtfix");
        lbBil.setAlignment(Pos.CENTER);

        tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setId("promtfix");
        tfRegnr.setMinWidth(200);
        tfRegnr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "^[a-zA-Z]{2}\\d{5}$";
                String regnr = tfRegnr.getText();

                if (!regnr.matches(regex)) {
                    tfRegnr.setId("error");
                } else {
                    tfRegnr.setId("valid");
                }
                if (regnr.length() == 0) {
                    tfRegnr.setId("promtfix");
                }
            }
        });

        TranslateTransition ttRegnr = new TranslateTransition(Duration.millis(100), tfRegnr);
        ttRegnr.setFromX(800);
        ttRegnr.setToX(0);
        ttRegnr.setCycleCount(1);

        tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setId("promtfix");
        tfÅrsmodell.setMinWidth(200);
        tfÅrsmodell.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String årsmodell = tfÅrsmodell.getText();

                if (!årsmodell.matches(regex) || årsmodell.length() > 4 || årsmodell.length() < 4) {
                    tfÅrsmodell.setId("error");
                } else {
                    tfÅrsmodell.setId("valid");
                }
                if (årsmodell.length() == 0) {
                    tfÅrsmodell.setId("promtfix");
                }
            }
        });

        TranslateTransition ttÅrsmodell = new TranslateTransition(Duration.millis(100), tfÅrsmodell);
        ttÅrsmodell.setFromX(800);
        ttÅrsmodell.setToX(0);
        ttÅrsmodell.setCycleCount(1);

        tfMerke = new TextField();
        tfMerke.setPromptText("eks (BMW)");
        tfMerke.setId("promtfix");
        tfMerke.setMinWidth(200);
        tfMerke.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[ÆØÅæøåA-Za-z]+";
                String merke = tfMerke.getText();

                if (merke.matches(regex)) {
                    tfMerke.setId("valid");
                } else {
                    tfMerke.setId("error");
                }
                if (merke.length() == 0) {
                    tfMerke.setId("promtfix");
                }
            }
        });

        TranslateTransition ttMerke = new TranslateTransition(Duration.millis(100), tfMerke);
        ttMerke.setFromX(800);
        ttMerke.setToX(0);
        ttMerke.setCycleCount(1);

        tfModell = new TextField();
        tfModell.setPromptText("eks (5-serie 530xd)");
        tfModell.setId("promtfix");
        tfModell.setMinWidth(200);
        tfModell.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (tfModell.getLength() > 0) {
                    tfModell.setId("valid");
                } else {
                    tfModell.setId("promtfix");
                }
            }
        });

        TranslateTransition ttModell = new TranslateTransition(Duration.millis(100), tfModell);
        ttModell.setFromX(800);
        ttModell.setToX(0);
        ttModell.setCycleCount(1);

        tfKmstand = new TextField();
        tfKmstand.setPromptText("Km-stand");
        tfKmstand.setId("promtfix");
        tfKmstand.setMinWidth(200);
        tfKmstand.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String kmstand = tfKmstand.getText();

                if (!kmstand.matches(regex) || kmstand.length() > 6) {
                    tfKmstand.setId("error");
                } else {
                    tfKmstand.setId("valid");
                }
                if (kmstand.length() == 0) {
                    tfKmstand.setId("promtfix");
                }
            }
        });

        TranslateTransition ttKmstand = new TranslateTransition(Duration.millis(100), tfKmstand);
        ttKmstand.setFromX(800);
        ttKmstand.setToX(0);
        ttKmstand.setCycleCount(1);

        cbKjørelengde = new ComboBox<>();
        cbKjørelengde.setEditable(false);
        cbKjørelengde.setId("combobox");
        cbKjørelengde.setMinWidth(200);
        cbKjørelengde.getItems().addAll(
                "Kjørelengde:  5 000 km",
                "Kjørelengde: 10 000 km",
                "Kjørelengde: 20 000 km",
                "Kjørelengde: 30 000 km",
                "Kjørelengde: Ubegrenset"
        );
        cbKjørelengde.setValue("Velg Kjørelengde:");

        TranslateTransition ttKjørelengde = new TranslateTransition(Duration.millis(100), cbKjørelengde);
        ttKjørelengde.setFromX(800);
        ttKjørelengde.setToX(0);
        ttKjørelengde.setCycleCount(1);

        cbBonus = new ComboBox<>();
        cbBonus.setEditable(false);
        cbBonus.setId("combobox");
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

        TranslateTransition ttBonus = new TranslateTransition(Duration.millis(100), cbBonus);
        ttBonus.setFromX(800);
        ttBonus.setToX(0);
        ttBonus.setCycleCount(1);

        cbEgenandel = new ComboBox<>();
        cbEgenandel.setEditable(false);
        cbEgenandel.setId("combobox");
        cbEgenandel.setMinWidth(200);
        cbEgenandel.getItems().addAll(
                "Egenandel:  4 000,-",
                "Egenandel:  6 000,-",
                "Egenandel: 10 000,-"
        );
        cbEgenandel.setValue("Velg Egenandel:");

        TranslateTransition ttEgenandel = new TranslateTransition(Duration.millis(100), cbEgenandel);
        ttEgenandel.setFromX(800);
        ttEgenandel.setToX(0);
        ttEgenandel.setCycleCount(1);

        //Registrer knapp & Label & Toggle
        lbvelgEier = new Label();
        lbvelgEier.setText("Annen eier?");
        lbvelgEier.setId("velgeier");
        lbvelgEier.setAlignment(Pos.CENTER);

        TranslateTransition ttVelgEier = new TranslateTransition(Duration.millis(100), lbvelgEier);
        ttVelgEier.setFromX(800);
        ttVelgEier.setToX(0);
        ttVelgEier.setCycleCount(1);

        eiere = new ToggleGroup();

        rbtJa = new RadioButton("JA");
        rbtJa.setToggleGroup(eiere);
        rbtJa.setId("rbtJa");
        rbtJa.setSelected(false);
        rbtJa.setOnAction(e -> {
            gridPerson.setVisible(true);
        });


        TranslateTransition ttJa = new TranslateTransition(Duration.millis(100), rbtJa);
        ttJa.setFromX(800);
        ttJa.setToX(0);
        ttJa.setCycleCount(1);

        rbtNei = new RadioButton("NEI");
        rbtNei.setToggleGroup(eiere);
        rbtNei.setId("rbtNei");
        rbtNei.setSelected(true);
        rbtNei.setOnAction(e -> {
            gridPerson.setVisible(false);
        });

        TranslateTransition ttNei = new TranslateTransition(Duration.millis(100), rbtNei);
        ttNei.setFromX(800);
        ttNei.setToX(0);
        ttNei.setCycleCount(1);

        regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);

        FadeTransition ftSjekkpris = new FadeTransition(Duration.millis(100), btnSjekkpris);
        ftSjekkpris.setFromValue(0.0F);
        ftSjekkpris.setToValue(1.0F);
        ftSjekkpris.setCycleCount(1);
        

        btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Bestill");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);

        btnSjekkpris.setOnAction((ActionEvent e) -> {
            if (tfRegnr.getId().equals("valid")
                    && tfÅrsmodell.getId().equals("valid")
                    && tfMerke.getId().equals("valid")
                    && tfModell.getId().equals("valid")
                    && tfKmstand.getId().equals("valid")
                    && !cbBonus.getValue().equals("Velg Bonus:")
                    && !cbEgenandel.getValue().equals("Velg Egenandel:")
                    && !cbKjørelengde.getValue().equals("Velg Kjørelengde:")
                    ){

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
            }
            else {
                regLabel.setText("Sjekk feil i feltene ovenfor");
            }
        });

        btnRegBilforsikring.setOnAction(e -> {
            if (rbtJa.isSelected()){
                ja();
            }
            if (rbtNei.isSelected()){
                nei();
            }
        });


        FadeTransition ftBestill = new FadeTransition(Duration.millis(100), btnRegBilforsikring);
        ftBestill.setFromValue(0.0F);
        ftBestill.setToValue(1.0F);
        ftBestill.setCycleCount(1);

        SequentialTransition st = new SequentialTransition(ttRegnr, ttÅrsmodell, ttMerke, ttModell, ttKmstand, ttBonus, ttEgenandel, ttKjørelengde, ttVelgEier, ttJa, ttNei, ftSjekkpris, ftBestill);
        st.play();

        //gridBil.add(lbBil, 0, 0);
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

        //gridPerson.add(lbPerson, 0, 0);
        gridPerson.add(tfFornavn, 0, 1);
        gridPerson.add(tfEtternavn, 0, 2);
        gridPerson.add(tfPersonnr, 0, 3);
        gridPerson.add(tfTelefon, 0, 4);
        gridPerson.add(tfAdresse, 0, 5);
        gridPerson.add(tfPostnr, 0, 6);
        gridPerson.add(postSted, 0, 7);

        //gridBil.setGridLinesVisible(true);
        //gridPerson.setGridLinesVisible(true);

        hbKnapper = new HBox();
        hbKnapper.setAlignment(Pos.CENTER);
        hbKnapper.setSpacing(10);
        hbKnapper.getChildren().addAll(btnSjekkpris, btnRegBilforsikring);

        vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        //vb.setStyle("-fx-border-color: red;");
        vb.setPadding(new Insets(50, 120, 10, 10));//top/right/bottom/left
        vb.getChildren().addAll(hb, hbKnapper, regLabel);

        borderPane.setRight(vb); //Center

        //borderPane.setRight(gridPerson); //Right
        borderPane.getStylesheets().add("CSS/kundeBil.css");

        return borderPane;

    }

    public void ja() {
        if (tfRegnr.getId().equals("valid")
                && tfÅrsmodell.getId().equals("valid")
                && tfMerke.getId().equals("valid")
                && tfModell.getId().equals("valid")
                && tfKmstand.getId().equals("valid")
                && !cbBonus.getValue().equals("Velg Bonus:")
                && !cbEgenandel.getValue().equals("Velg Egenandel:")
                && !cbKjørelengde.getValue().equals("Velg Kjørelengde:")
                && tfFornavn.getId().equals("valid")
                && tfEtternavn.getId().equals("valid")
                && tfPersonnr.getId().equals("valid")
                && tfTelefon.getId().equals("valid")
                && tfAdresse.getId().equals("valid")
                && tfPostnr.getId().equals("valid")
                ) {
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
            kontroller.setBilForsikring(bil, person);
            regLabel.setText("Bilforsikring Registrert!");

        } else {
            regLabel.setText("Sjekk feil i feltene ovenfor");
        }
    }


    public void nei(){

        if (tfRegnr.getId().equals("valid")
                && tfÅrsmodell.getId().equals("valid")
                && tfMerke.getId().equals("valid")
                && tfModell.getId().equals("valid")
                && tfKmstand.getId().equals("valid")
                && !cbBonus.getValue().equals("Velg Bonus:")
                && !cbEgenandel.getValue().equals("Velg Egenandel:")
                && !cbKjørelengde.getValue().equals("Velg Kjørelengde:")
                ) {
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
            kontroller.setBilForsikring(bil, person);
            regLabel.setText("Bilforsikring Registrert!");

        } else {
            regLabel.setText("Sjekk feil i feltene ovenfor");
        }
    }
}
