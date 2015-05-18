package GUI;

import Forsikring.BoligForsikring;
import Kontroller.Kontroller;
import java.text.DecimalFormat;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import Kontroller.Postregister;
import javafx.util.Duration;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBolig {

    private boolean utLeie;
    private BorderPane borderPane;
    private GridPane grid;
    private TextField tfAdresse;
    private TextField tfByggeår;
    private TextField tfKvadrat;
    private TextField tfByggSum;
    private TextField tfInnboSum;
    private TextField tfPostnr;
    private Label postSted;
    private ComboBox<String> cbBoligtype;
    private ComboBox<String> cbStandard;
    private ComboBox<String> cbMatriale;
    private CheckBox cbleie;
    private Label regLabel;
    private Button btnSjekkpris;
    private Button btnRegBoligforsikring;


    public Pane boligFane(Kontroller kontroller) {
        borderPane = new BorderPane();
        borderPane.setId("borderpane");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(60, 150, 10, 10));//top/right/bottom/left

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);

        //Bolig
        tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setId("promtfix");
        tfAdresse.setMaxWidth(200);
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

        FadeTransition ftadresse = new FadeTransition(Duration.millis(100), tfAdresse);
        ftadresse.setFromValue(0.0F);
        ftadresse.setToValue(1.0F);
        ftadresse.setCycleCount(1);

        tfByggeår = new TextField();
        tfByggeår.setPromptText("Byggeår");
        tfByggeår.setId("promtfix");
        tfByggeår.setMaxWidth(95);
        tfByggeår.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String byggår = tfByggeår.getText();

                if (!byggår.matches(regex) || byggår.length() > 4 || byggår.length() < 4) {
                    tfByggeår.setId("error");
                } else {
                    tfByggeår.setId("valid");
                }
                if (byggår.length() == 0) {
                    tfByggeår.setId("promtfix");
                }
            }
        });

        FadeTransition ftbyggår = new FadeTransition(Duration.millis(100), tfByggeår);
        ftbyggår.setFromValue(0.0F);
        ftbyggår.setToValue(1.0F);
        ftbyggår.setCycleCount(1);

        tfKvadrat = new TextField();
        tfKvadrat.setPromptText("KVM");
        tfKvadrat.setId("promtfix");
        tfKvadrat.setMaxWidth(95);
        tfKvadrat.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String KVM = tfKvadrat.getText();

                if (!KVM.matches(regex) || KVM.length() > 6) {
                    tfKvadrat.setId("error");
                } else {
                    tfKvadrat.setId("valid");
                }
                if (KVM.length() == 0) {
                    tfKvadrat.setId("promtfix");
                }
            }
        });

        FadeTransition ftkvadrat = new FadeTransition(Duration.millis(100), tfKvadrat);
        ftkvadrat.setFromValue(0.0F);
        ftkvadrat.setToValue(1.0F);
        ftkvadrat.setCycleCount(1);

        tfByggSum = new TextField();
        tfByggSum.setPromptText("Bolig verdi");
        tfByggSum.setId("promtfix");
        tfByggSum.setMaxWidth(95);
        tfByggSum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String byggsum = tfByggSum.getText();

                if (!byggsum.matches(regex) || byggsum.length() > 12) {
                    tfByggSum.setId("error");
                } else {
                    tfByggSum.setId("valid");
                }
                if (byggsum.length() == 0) {
                    tfByggSum.setId("promtfix");
                }
            }
        });

        FadeTransition ftbyggsum = new FadeTransition(Duration.millis(100), tfByggSum);
        ftbyggsum.setFromValue(0.0F);
        ftbyggsum.setToValue(1.0F);
        ftbyggsum.setCycleCount(1);

        tfInnboSum = new TextField();
        tfInnboSum.setPromptText("Innbo verdi");
        tfInnboSum.setId("promtfix");
        tfInnboSum.setMaxWidth(95);
        tfInnboSum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String innbosum = tfInnboSum.getText();

                if (!innbosum.matches(regex) || innbosum.length() > 12) {
                    tfInnboSum.setId("error");
                } else {
                    tfInnboSum.setId("valid");
                }
                if (innbosum.length() == 0) {
                    tfInnboSum.setId("promtfix");
                }
            }
        });

        FadeTransition ftinnbo = new FadeTransition(Duration.millis(100), tfInnboSum);
        ftinnbo.setFromValue(0.0F);
        ftinnbo.setToValue(1.0F);
        ftinnbo.setCycleCount(1);

        tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setId("promtfix");
        tfPostnr.setAlignment(Pos.CENTER_LEFT);
        tfPostnr.setMaxWidth(70);

        FadeTransition ftpostnr = new FadeTransition(Duration.millis(100), tfPostnr);
        ftpostnr.setFromValue(0.0F);
        ftpostnr.setToValue(1.0F);
        ftpostnr.setCycleCount(1);

        postSted = new Label();
        postSted.setText("");
        postSted.setId("promtfix");
        postSted.setAlignment(Pos.CENTER_LEFT);
        postSted.setMaxWidth(100);
        tfPostnr.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "[0-9]+";
            String Postnr = tfPostnr.getText();

            Postregister register = new Postregister();
            String Poststed = register.getPoststed(tfPostnr.getText());

            if (!Postnr.matches(regex) || Postnr.length() > 4 || Postnr.length() < 4) {
                tfPostnr.setId("error");
            }
            if (Poststed != null) {
                tfPostnr.setId("valid");
            }
            if (Postnr.length() == 0) {
                tfPostnr.setId("promtfix");
            }

            if (Poststed == null) {
                postSted.setText("Finnes ikke!");
            }
            if (tfPostnr.getText().length() == 0) {
                postSted.setText("");
            } else {
                postSted.setText(Poststed);
            }
        });

        cbBoligtype = new ComboBox<>();
        cbBoligtype.setEditable(false);
        cbBoligtype.setId("combobox");
        cbBoligtype.setMaxWidth(200);
        cbBoligtype.getItems().addAll(
                "Enebolig",
                "Tomannsbolig",
                "Leilighet",
                "Rekkehus"
        );
        cbBoligtype.setValue("Velg Boligtype:");

        FadeTransition ftboligtype = new FadeTransition(Duration.millis(100), cbBoligtype);
        ftboligtype.setFromValue(0.0F);
        ftboligtype.setToValue(1.0F);
        ftboligtype.setCycleCount(1);

        cbStandard = new ComboBox<>();
        cbStandard.setEditable(false);
        cbStandard.setId("combobox");
        cbStandard.setMaxWidth(200);
        cbStandard.getItems().addAll(
                "Dårlig",
                "Gjennomsnittlig",
                "Over gjennomsnitt",
                "Svært Høy"
        );
        cbStandard.setValue("Standard:");

        FadeTransition ftstandard = new FadeTransition(Duration.millis(100), cbStandard);
        ftstandard.setFromValue(0.0F);
        ftstandard.setToValue(1.0F);
        ftstandard.setCycleCount(1);

        cbMatriale = new ComboBox<>();
        cbMatriale.setEditable(false);
        cbMatriale.setId("combobox");
        cbMatriale.setMaxWidth(200);
        cbMatriale.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMatriale.setValue("Byggematriale:");

        FadeTransition ftmatriale = new FadeTransition(Duration.millis(100), cbMatriale);
        ftmatriale.setFromValue(0.0F);
        ftmatriale.setToValue(1.0F);
        ftmatriale.setCycleCount(1);

        cbleie = new CheckBox( "Er dette utleiebolig ? ");
        cbleie.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (cbleie.isSelected()) {
                utLeie = true;

            } else {
                utLeie = false;
                System.out.println("Nei");
            }
        });

        FadeTransition ftCheckbox = new FadeTransition(Duration.millis(100), cbleie);
        ftCheckbox.setFromValue(0.0F);
        ftCheckbox.setToValue(1.0F);
        ftCheckbox.setCycleCount(1);

        regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMaxWidth(200);

        FadeTransition ftsjekkpris = new FadeTransition(Duration.millis(100), btnSjekkpris);
        ftsjekkpris.setFromValue(0.0F);
        ftsjekkpris.setToValue(1.0F);
        ftsjekkpris.setCycleCount(1);

        btnRegBoligforsikring = new Button();
        btnRegBoligforsikring.setText("Bestill");
        btnRegBoligforsikring.setId("btnRegBoligforsikring");
        btnRegBoligforsikring.setMaxWidth(200);

        FadeTransition ftBestill = new FadeTransition(Duration.millis(100), btnRegBoligforsikring);
        ftBestill.setFromValue(0.0F);
        ftBestill.setToValue(1.0F);
        ftBestill.setCycleCount(1);

        tfPostnr.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Postregister register = new Postregister();
                String poststed = register.getPoststed(tfPostnr.getText());
                if (poststed == null) {
                    poststed = "Finnes ikke!";
                }
                if (tfPostnr.getText().equals("")) {
                    postSted.setText("");
                    postSted.setText("PostSted");
                } else
                    postSted.setText(poststed);
            }
        });

        SequentialTransition st = new SequentialTransition(ftadresse, ftpostnr, ftbyggår, ftkvadrat, ftbyggsum, ftinnbo, ftboligtype, ftstandard, ftmatriale, ftCheckbox, ftsjekkpris, ftBestill);
        st.play();

        grid.add(tfAdresse, 0, 0, 2, 1);
        grid.add(tfPostnr, 0, 1, 2, 1);
        grid.add(postSted, 1, 1);
        grid.add(tfByggeår, 0, 2);
        grid.add(tfKvadrat, 1, 2);
        grid.add(tfByggSum, 0, 3);
        grid.add(tfInnboSum, 1, 3);
        grid.add(cbBoligtype, 0, 4, 2, 1);
        grid.add(cbStandard, 0, 5, 2, 1);
        grid.add(cbMatriale, 0, 6, 2, 1);
        grid.add(cbleie, 0, 7, 2, 1);
        grid.add(btnSjekkpris, 0, 8, 2, 1);
        grid.add(btnRegBoligforsikring, 0, 9, 2, 1);
        grid.add(regLabel, 0, 10, 2, 1);

        grid.setGridLinesVisible(false);
        borderPane.setLeft(grid); // CENTER

        //Oppretter en forsikring, slik at man kan sjekke pris. Objektet lagres ikke,
        //men hvis man trykker på kjøp rett etter vil det opprettes et nytt objekt som lagres
        btnSjekkpris.setOnAction(e -> {
            if (tfAdresse.getId().equals("valid")
                    && tfPostnr.getId().equals("valid")
                    && tfByggeår.getId().equals("valid")
                    && tfKvadrat.getId().equals("valid")
                    && tfByggSum.getId().equals("valid")
                    && tfInnboSum.getId().equals("valid")
                    && !cbBoligtype.getValue().equals("Velg Boligtype:")
                    && !cbStandard.getValue().equals("Standard:")
                    && !cbMatriale.getValue().equals("Byggematriale:")
                    ){

                String postNr = tfPostnr.getText();
                String adresse = tfAdresse.getText();
                String standard = cbStandard.getValue();
                String materiale = cbMatriale.getValue();
                String boligType = cbBoligtype.getValue();
                int byggeÅr = 0;
                double kvadrat = 0;
                double byggSum = 0;
                double innboSum = 0;
                try {
                    kvadrat = Double.parseDouble(tfKvadrat.getText());
                    byggSum = Double.parseDouble(tfByggSum.getText());
                    innboSum = Double.parseDouble(tfInnboSum.getText());
                    byggeÅr = Integer.parseInt(tfByggeår.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat.");
                }
                BoligForsikring f = new BoligForsikring(utLeie, kvadrat, adresse, boligType, byggeÅr,
                        materiale, standard, byggSum, innboSum);
                String form = "0.00";
                DecimalFormat tall = new DecimalFormat(form);
                regLabel.setText("Årlig premie: " + tall.format(f.getPremie()) + " kr");
            }
            else {
                regLabel.setText("Sjekk feil i feltene ovenfor");
            }

        });
        //registrerer boligforsikring og setter sen inn i forsikringsregisteret.
        btnRegBoligforsikring.setOnAction(e -> {
            if (tfAdresse.getId().equals("valid")
                    && tfPostnr.getId().equals("valid")
                    && tfByggeår.getId().equals("valid")
                    && tfKvadrat.getId().equals("valid")
                    && tfByggSum.getId().equals("valid")
                    && tfInnboSum.getId().equals("valid")
                    && !cbBoligtype.getValue().equals("Velg Boligtype:")
                    && !cbStandard.getValue().equals("Standard:")
                    && !cbMatriale.getValue().equals("Byggematriale:")
                    ) {

                String postNr = tfPostnr.getText();
                String adresse = tfAdresse.getText();
                String byggeÅr = tfByggeår.getText();
                String standard = cbStandard.getValue();
                String materiale = cbMatriale.getValue();
                String boligType = cbBoligtype.getValue();
                double kvadrat = 0;
                double byggSum = 0;
                double innboSum = 0;
                int byggeår = 0;

                try {
                    kvadrat = Double.parseDouble(tfKvadrat.getText());
                    byggSum = Double.parseDouble(tfByggSum.getText());
                    innboSum = Double.parseDouble(tfInnboSum.getText());
                    byggeår = Integer.parseInt(tfKvadrat.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat.");
                }

                kontroller.setBoligForsikring(utLeie, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, innboSum);
                tfAdresse.clear(); tfPostnr.clear(); tfByggeår.clear(); tfKvadrat.clear(); tfByggSum.clear(); tfInnboSum.clear(); cbleie.setSelected(false); postSted.setText(""); cbBoligtype.setValue("Velg Boligtype:"); cbStandard.setValue("Standard:"); cbMatriale.setValue("Byggematriale:");
                regLabel.setText("Boligforsikring registrert!");
            }
            else {
                regLabel.setText("Sjekk feil i feltene ovenfor");
            }

        });

        borderPane.getStylesheets().add("CSS/kundebolig.css");
        return borderPane;
    }
}
