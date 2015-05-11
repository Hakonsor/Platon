package GUI;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.Forsikringer;
import Forsikring.ReiseForsikring;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.*;
import javafx.util.Duration;


/**
 * Created by Magnus on 27.04.15.
 */
public class KonsulentsideKunde implements ComboBoxConverter {

    public static Label lbKundenavn;
    public static Label lbKonsulent;
    private Kontroller kontroll;
    private String type;
    private boolean utLeie;
    private HBox hb;
    private HBox hBox;
    private VBox vBox;
    private VBox vb;
    private Button btnSøk;
    private Button btnRegKunde;
    private BorderPane borderPane;
    private GridPane gridAdvarsel;
    private GridPane gridRight;
    private GridPane gridLeft;
    private GridPane gridBil;
    private GridPane gridReise;
    private GridPane gridBåt;
    private GridPane gridBolig;
    private GridPane gridFriBolig;
    private GridPane gridAlle;
    private ListView<String> listView;
    private Label regLabelBil;
    private TextField tfByggSum;
    private TextField tfPostnr;
    private TextField tfRegnr;
    private TextField tfÅrsmodell;
    private TextField tfMerke;
    private TextField tfModell;
    private TextField tfKmstand;
    private TextField tfPostnrF;
    private TextField tfAdresseF;
    private TextField tfByggeårF;
    private TextField tfKvadratF;
    private TextField tfByggSumF;
    private TextField tfInnboSumF;
    private TextField tfInnboSum;
    private TextField tfKvadrat;
    private TextField tfByggeår;
    private TextField tfAdresse;
    private TextField tfYtelse;
    private TextField tfMotormerke;
    private TextField tfAntfot;
    private TextField tfBåtmodell;
    private TextField tfÅrsmodellB;
    private TextField tfRegnrB;
    private TextField tfVerdiB;
    private TextField tfVerdi;
    private TextArea taLes;
    private ComboBox<String> cbKjørelengde;
    private ComboBox<String> cbBonus;
    private ComboBox<String> cbEgenandel;
    private ComboBox<String> cbBoligtypeF;
    private ComboBox<String> cbStandardF;
    private ComboBox<String> cbMatrialeF;
    private ComboBox<String> cbMatriale;
    private ComboBox<String> cbStandard;
    private ComboBox<String> cbBoligtype;
    private Button btnSjekkprisF;
    private CheckBox cbleieF;
    private Label regLabelF;
    private Label regLabelBo;
    private Label regLabelB;
    private Label lbInfo;
    private Label lbPrint;
    private Label lbregBil;
    private Label lbAdvarsel;
    private Button btnRegBåtforsikring;
    private Button btnRegBilforsikring;
    private Button btnSjekkprisBil;
    private Button btnRegBoligforsikringF;
    private Button btnSlett;
    private Button btnBeregn;
    private Button btnBestill;
    private Button btnRegForsikring;
    private Button btnRegBoligforsikring;
    private Button btnSjekkpris;
    private Button btnSjekkprisB;
    private CheckBox cbleie;
    private KundesideBil bil;
    private ToggleGroup båtType;
    private ToggleGroup reise;
    private RadioButton rbtSeilbåt;
    private RadioButton rbtMotorbåt;
    private RadioButton rbtnVerden;
    private RadioButton rbtnEuropa;
    private RadioButton rbtnNorden;

    private ObservableList<String> navn;
    private ObservableList<String> data;

    private ComboBox<String> forsikringComboBox;

    public Pane kundeFane(Kontroller kontroll) {
        this.kontroll = kontroll;

        borderPane = new BorderPane();
        borderPane.setId("borderpane");
        borderPane.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left


        //TOP---------------------------------->

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(130, 10, 20, 0)); //top/right/bottom/left

        lbKonsulent = new Label();
        lbKonsulent.setText("Hei " + "Navn Navnesen");
        lbKonsulent.setId("konsulent");

        lbKundenavn = new Label();
        lbKundenavn.setText("Valgt kunde: " + "\"Ingen kunde er valgt\"");
        lbKundenavn.setId("kundenavn");

        FadeTransition ftKunde = new FadeTransition(Duration.millis(1000), lbKundenavn);
        ftKunde.setFromValue(0.0F);
        ftKunde.setToValue(1.0F);
        ftKunde.setCycleCount(7);

        btnSøk = new Button();
        btnSøk.setText("Finn kunde");
        btnSøk.setId("sok");
        btnSøk.setMinWidth(100);
        btnSøk.setOnAction(e -> {
            kontroll.sok();
        });

        FadeTransition ftSøk = new FadeTransition(Duration.millis(200), btnSøk);
        ftSøk.setFromValue(0.0F);
        ftSøk.setToValue(1.0F);
        ftSøk.setCycleCount(1);

        btnSlett = new Button();
        btnSlett.setText("Slett forsikring");
        btnSlett.setId("slett");
        btnSlett.setMaxWidth(150);
        btnSlett.setOnAction(e -> {
            slettForsikring();
        });

        FadeTransition ftSlett = new FadeTransition(Duration.millis(200), btnSlett);
        ftSlett.setFromValue(0.0F);
        ftSlett.setToValue(1.0F);
        ftSlett.setCycleCount(1);

        btnRegKunde = new Button();
        btnRegKunde.setText("Reg. kunde");
        btnRegKunde.setId("regKunde");
        btnRegKunde.setMinWidth(100);
        btnRegKunde.setOnAction(e -> {
            kontroll.regVindu();
        });

        FadeTransition ftReg = new FadeTransition(Duration.millis(200), btnRegKunde);
        ftReg.setFromValue(0.0F);
        ftReg.setToValue(1.0F);
        ftReg.setCycleCount(1);

        navn = FXCollections.observableArrayList();
        data = FXCollections.observableArrayList();
        forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.setId("comboboxForsikring");
        forsikringComboBox.getItems().addAll(
                "Alle",
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fritidsbolig"
        );

        FadeTransition ftCombo = new FadeTransition(Duration.millis(200), forsikringComboBox);
        ftCombo.setFromValue(0.0F);
        ftCombo.setToValue(1.0F);
        ftCombo.setCycleCount(1);

        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {
            if (!lbKundenavn.getText().equals("Valgt kunde: " + "\"Ingen kunde er valgt\"")) {
                gridAdvarsel.setVisible(false);
                ruteVipper();
            } else {
                gridAdvarsel.setVisible(true);
            }
        });

        hb = new HBox();
        hb.setSpacing(70);
        hb.setAlignment(Pos.CENTER);

        hb.getChildren().addAll(forsikringComboBox, btnSlett, btnSøk, btnRegKunde);

        vBox.getChildren().addAll(lbKonsulent, lbKundenavn);

        borderPane.setTop(vBox);

        SequentialTransition st = new SequentialTransition(ftCombo, ftSlett, ftSøk, ftReg, ftKunde);
        st.play();



        //GRID RIGHT setVisible(false)---------------->
        gridBil = new GridPane();
        gridBil.setVisible(false);

        gridReise = new GridPane();
        gridReise.setVisible(false);

        gridBåt = new GridPane();
        gridBåt.setVisible(false);

        gridBolig = new GridPane();
        gridBolig.setVisible(false);

        gridFriBolig = new GridPane();
        gridFriBolig.setVisible(false);

        gridAlle = new GridPane();
        gridAlle.setVisible(false);


        //LEFT-------------------------------------->

        listView = new ListView<>(data);
        listView.setPrefSize(250, 350);
        listView.setEditable(false);

        data.addAll("Dobbel klikk for å velge:");

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));


        //RIGHT---------------------------------------------->

        //>---------GRID av forsikringene --------------<

        //Bil--------------------------------------------------------------------->
        gridBil.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBil.setVgap(10);
        gridBil.setHgap(10);
        gridBil.setAlignment(Pos.TOP_CENTER);

        bil = new KundesideBil();

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

        cbKjørelengde = new ComboBox<>();
        cbKjørelengde.setEditable(false);
        cbKjørelengde.setId("combobox");
        cbKjørelengde.setMaxWidth(200);
        cbKjørelengde.getItems().addAll(
                "Kjørelengde:  5 000 km",
                "Kjørelengde: 10 000 km",
                "Kjørelengde: 20 000 km",
                "Kjørelengde: 30 000 km",
                "Kjørelengde: Ubegrenset"
        );
        cbKjørelengde.setValue("Velg Kjørelengde:");

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


        lbregBil = new Label();
        lbregBil.setText("");
        lbregBil.setId("regLabel");
        lbregBil.setAlignment(Pos.CENTER);

        btnSjekkprisBil = new Button();
        btnSjekkprisBil.setText("Sjekk Pris");
        btnSjekkprisBil.setId("btnSjekkpris");
        btnSjekkprisBil.setMinWidth(200);


        btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Bestill");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);

        btnSjekkprisBil.setOnAction(e -> {
            if (tfRegnr.getId().equals("valid")
                    && tfÅrsmodell.getId().equals("valid")
                    && tfMerke.getId().equals("valid")
                    && tfModell.getId().equals("valid")
                    && tfKmstand.getId().equals("valid")
                    && !cbBonus.getValue().equals("Velg Bonus:")
                    && !cbEgenandel.getValue().equals("Velg Egenandel:")
                    && !cbKjørelengde.getValue().equals("Velg Kjørelengde:")
                    ) {
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
                lbregBil.setText("Årlig premie: " + tall.format(bil.getPremie()) + " kr");
            } else {
                lbregBil.setText("Sjekk feil i feltene ovenfor");
            }
        });

        btnRegBilforsikring.setOnAction(e -> {
            if (tfRegnr.getId().equals("valid")
                    && tfÅrsmodell.getId().equals("valid")
                    && tfMerke.getId().equals("valid")
                    && tfModell.getId().equals("valid")
                    && tfKmstand.getId().equals("valid")
                    && !cbBonus.getValue().equals("Velg Bonus:")
                    && !cbEgenandel.getValue().equals("Velg Egenandel:")
                    && !cbKjørelengde.getValue().equals("Velg Kjørelengde:")
                    ) {
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
                kontroll.setBilForsikring(bil, null);
                lbregBil.setText("Bilforsikring Registrert!");

            } else {
                lbregBil.setText("Sjekk feil i feltene ovenfor");
            }
        });

        gridBil.add(tfRegnr, 0, 0);
        gridBil.add(tfKmstand, 0, 1);
        gridBil.add(tfÅrsmodell, 0, 2);
        gridBil.add(tfMerke, 0, 3);
        gridBil.add(tfModell, 0, 4);

        gridBil.add(cbBonus, 1, 0);
        gridBil.add(cbEgenandel, 1, 1);
        gridBil.add(cbKjørelengde, 1, 2);
        gridBil.add(btnSjekkprisBil, 1, 3);
        gridBil.add(btnRegBilforsikring, 1, 4);
        gridBil.add(lbregBil, 1, 5);


        //Reise--------------------------------------------------------------------->
        lbInfo = new Label();
        lbInfo.setText("Velg reiseforsikringstype:");
        lbInfo.setId("lbInfo");
        lbInfo.setAlignment(Pos.CENTER);

        lbPrint = new Label();
        lbPrint.setId("print");
        lbPrint.setText("");
        lbPrint.setAlignment(Pos.CENTER_LEFT);

        reise = new ToggleGroup();

        rbtnVerden = new RadioButton("Verden");
        rbtnVerden.setId("verden");
        rbtnVerden.setToggleGroup(reise);
        rbtnVerden.setSelected(false);
        rbtnVerden.setAlignment(Pos.CENTER);
        rbtnVerden.setOnAction(e -> {
            type = "Verden";
        });

        rbtnEuropa = new RadioButton("Europa");
        rbtnEuropa.setId("europa");
        rbtnEuropa.setToggleGroup(reise);
        rbtnEuropa.setSelected(false);
        rbtnEuropa.setOnAction(e -> {
            type = "Europa";
        });


        rbtnNorden = new RadioButton("Norden");
        rbtnNorden.setId("norden");
        rbtnNorden.setToggleGroup(reise);
        rbtnNorden.setSelected(false);
        rbtnNorden.setOnAction(e -> {
            type = "Norden";
        });


        btnBeregn = new Button();
        btnBeregn.setText("Beregn pris");
        btnBeregn.setMinWidth(200);
        btnBeregn.setId("beregn");
        btnBeregn.setOnAction(e -> {
            if (reise.getSelectedToggle() != null) {
                String form = "0.00";
                DecimalFormat tall = new DecimalFormat(form);
                ReiseForsikring f = new ReiseForsikring();
                f.setType(type);
                f.setPremieOgForsSum(type);

                lbPrint.setText("Prisen er: " + tall.format(f.getPremie()) + " kr");
            } else {
                lbPrint.setText("Du må velge en forsikringstype");
            }
        });


        btnBestill = new Button();
        btnBestill.setText("Bestill");
        btnBestill.setMinWidth(200);
        btnBestill.setId("bestill");
        btnBestill.setOnAction(e -> {
            if (reise.getSelectedToggle() != null) {
                ReiseForsikring f = new ReiseForsikring();
                f.setType(type);
                f.setPremieOgForsSum(type);
                kontroll.setReiseForsikring(f);

                lbPrint.setText("Reiseforsikring " + type + " bestilt!");
            } else {
                lbPrint.setText("Du må velge en forsikringstype");
            }
        });

        gridReise.add(lbInfo, 0, 0);
        gridReise.add(rbtnVerden, 0, 1);
        gridReise.add(rbtnEuropa, 0, 2);
        gridReise.add(rbtnNorden, 0, 3);
        gridReise.add(btnBeregn, 0, 4);
        gridReise.add(btnBestill, 0, 5);
        gridReise.add(lbPrint, 0, 6);

        gridReise.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridReise.setVgap(20);
        gridReise.setHgap(10);
        gridReise.setAlignment(Pos.TOP_CENTER);
        gridReise.setGridLinesVisible(false);


        //Båt--------------------------------------------------------------------->
        gridBåt.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBåt.setVgap(10);
        gridBåt.setHgap(10);
        gridBåt.setAlignment(Pos.TOP_CENTER);

        tfRegnrB = new TextField();
        tfRegnrB.setPromptText("Reg.Nr eks (ABC123)");
        tfRegnrB.setMinWidth(200);
        tfRegnrB.setId("promtfix");
        tfRegnrB.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "^[a-zA-Z]{3}\\d{3}$";
                String regnr = tfRegnrB.getText();

                if (!regnr.matches(regex)) {
                    tfRegnrB.setId("error");
                } else {
                    tfRegnrB.setId("valid");
                }
                if (regnr.length() == 0) {
                    tfRegnrB.setId("promtfix");
                }
            }
        });

        tfÅrsmodellB = new TextField();
        tfÅrsmodellB.setPromptText("Årsmodell 4-tall");
        tfÅrsmodellB.setMinWidth(200);
        tfÅrsmodellB.setId("promtfix");
        tfÅrsmodellB.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String årsmodell = tfÅrsmodellB.getText();

                if (!årsmodell.matches(regex) || årsmodell.length() > 4 || årsmodell.length() < 4) {
                    tfÅrsmodellB.setId("error");
                } else {
                    tfÅrsmodellB.setId("valid");
                }
                if (årsmodell.length() == 0) {
                    tfÅrsmodellB.setId("promtfix");
                }
            }
        });


        tfBåtmodell = new TextField();
        tfBåtmodell.setPromptText("Båtmodell eks (Ibiza 22)");
        tfBåtmodell.setMinWidth(200);
        tfBåtmodell.setId("promtfix");
        tfBåtmodell.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (tfBåtmodell.getLength() > 0) {
                    tfBåtmodell.setId("valid");
                } else {
                    tfBåtmodell.setId("promtfix");
                }
            }
        });


        tfAntfot= new TextField();
        tfAntfot.setPromptText("Antall fot");
        tfAntfot.setMinWidth(200);
        tfAntfot.setId("promtfix");
        tfAntfot.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String fot = tfAntfot.getText();

                if (!fot.matches(regex) || fot.length() > 4) {
                    tfAntfot.setId("error");
                } else {
                    tfAntfot.setId("valid");
                }
                if (fot.length() == 0) {
                    tfAntfot.setId("promtfix");
                }
            }
        });

        tfMotormerke = new TextField();
        tfMotormerke.setPromptText("Motormerke");
        tfMotormerke.setMinWidth(200);
        tfMotormerke.setId("promtfix");
        tfMotormerke.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[ÆØÅæøåA-Za-z]+";
                String merke = tfMotormerke.getText();

                if (merke.matches(regex)) {
                    tfMotormerke.setId("valid");
                } else {
                    tfMotormerke.setId("error");
                }
                if (merke.length() == 0) {
                    tfMotormerke.setId("promtfix");
                }
            }
        });

        tfYtelse = new TextField();
        tfYtelse.setPromptText("Ytelse (hk)");
        tfYtelse.setMinWidth(200);
        tfYtelse.setId("promtfix");
        tfYtelse.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String ytelse = tfYtelse.getText();

                if (!ytelse.matches(regex) || ytelse.length() > 5) {
                    tfYtelse.setId("error");
                } else {
                    tfYtelse.setId("valid");
                }
                if (ytelse.length() == 0) {
                    tfYtelse.setId("promtfix");
                }
            }
        });

        tfVerdiB = new TextField();
        tfVerdiB.setPromptText("Verdi på båten");
        tfVerdiB.setMinWidth(200);
        tfVerdiB.setId("promtfix");
        tfVerdiB.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String verdi = tfVerdiB.getText();

                if (!verdi.matches(regex) || verdi.length() > 13) {
                    tfVerdiB.setId("error");
                } else {
                    tfVerdiB.setId("valid");
                }
                if (verdi.length() == 0) {
                    tfVerdiB.setId("promtfix");
                }
            }
        });

        båtType = new ToggleGroup();
        rbtSeilbåt = new RadioButton("Seilbåt");
        rbtSeilbåt.setToggleGroup(båtType);
        rbtSeilbåt.setSelected(false);
        rbtSeilbåt.setOnAction(e -> {
            type = "Seilbåt";
        });

        rbtMotorbåt = new RadioButton("Motorbåt");
        rbtMotorbåt.setToggleGroup(båtType);
        rbtMotorbåt.setSelected(false);
        rbtMotorbåt.setOnAction(e -> {
            type = "Motorbåt";
        });


        regLabelB = new Label();
        regLabelB.setText("");
        regLabelB.setId("regLabel");
        regLabelB.setAlignment(Pos.CENTER);

        btnSjekkprisB = new Button();
        btnSjekkprisB.setText("Sjekk Pris");
        btnSjekkprisB.setId("btnSjekkpris");
        btnSjekkprisB.setMinWidth(200);
        btnSjekkprisB.setOnAction(e -> {
            regLabelB.setText("Premien er: " + "getPris()");
        });


        btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Bestill");
        btnRegBåtforsikring.setId("btnRegBatforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        btnRegBåtforsikring.setOnAction(e -> {
            regLabelB.setText("Båtforsikring Registrert!");

            if (tfRegnrB.getId().equals("valid")
                    && tfÅrsmodellB.getId().equals("valid")
                    && tfBåtmodell.getId().equals("valid")
                    && tfAntfot.getId().equals("valid")
                    && tfMotormerke.getId().equals("valid")
                    && tfYtelse.getId().equals("valid")
                    && tfVerdiB.getId().equals("valid")) {
                double verdi = 0;
                int lengdeFot = 0;
                String regNo = tfRegnrB.getText();
                try {
                    verdi = Double.parseDouble(tfVerdiB.getText());
                    lengdeFot = Integer.parseInt(tfYtelse.getText());
                    BatForsikring båt = new BatForsikring(verdi, lengdeFot, regNo, type, "modell", "årsModell", 10, "motormerke");
                    kontroll.setBåtForsikring(båt);
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat");
                }

                regLabelB.setText("Båtforsikring Registrert!");

            } else {
                regLabelB.setText("Sjekk feil i feltene ovenfor");
            }
        });

        gridBåt.add(tfRegnrB, 0, 0);
        gridBåt.add(tfÅrsmodellB, 0, 1);
        gridBåt.add(tfMotormerke, 0, 2);
        gridBåt.add(tfVerdiB, 0, 3);
        gridBåt.add(tfYtelse, 0, 4);


        gridBåt.add(tfBåtmodell, 1, 0);
        gridBåt.add(tfAntfot, 1, 1);
        gridBåt.add(rbtMotorbåt, 1, 2);
        gridBåt.add(rbtSeilbåt, 1, 3);

        gridBåt.add(btnSjekkprisB, 0, 5);
        gridBåt.add(btnRegBåtforsikring, 1, 5);
        gridBåt.add(regLabelB, 1, 6);



        //Bolig--------------------------------------------------------------------->
        gridBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBolig.setVgap(10);
        gridBolig.setHgap(10);
        gridBolig.setAlignment(Pos.CENTER);

        tfPostnr = new TextField();
        tfPostnr.setPromptText("Postnummer");
        tfPostnr.setMinWidth(200);

        tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setMinWidth(200);

        tfByggeår = new TextField();
        tfByggeår.setPromptText("Byggeår");
        tfByggeår.setMinWidth(200);

        tfKvadrat = new TextField();
        tfKvadrat.setPromptText("Kvadratmeter");
        tfKvadrat.setMinWidth(200);

        tfByggSum = new TextField();
        tfByggSum.setPromptText("Bolig verdi");
        tfByggSum.setMinWidth(200);

        tfInnboSum = new TextField();
        tfInnboSum.setPromptText("Innbo verdi");
        tfInnboSum.setMinWidth(200);

        cbBoligtype = new ComboBox<>();
        cbBoligtype.setEditable(false);
        cbBoligtype.setMinWidth(200);
        cbBoligtype.getItems().addAll(
                "Enebolig",
                "Tomannsbolig",
                "Leilighet",
                "Rekkehus"
        );
        cbBoligtype.setValue("Velg Boligtype:");

        cbStandard = new ComboBox<>();
        cbStandard.setEditable(false);
        cbStandard.setMinWidth(200);
        cbStandard.getItems().addAll(
                "Dårlig",
                "Gjennomsnittlig",
                "Over gjennomsnitt",
                "Svært Høy"
        );
        cbStandard.setValue("Standard:");

        cbMatriale = new ComboBox<>();
        cbMatriale.setEditable(false);
        cbMatriale.setMinWidth(200);
        cbMatriale.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMatriale.setValue("Byggematriale:");

        cbleie = new CheckBox(" UtleieBolig? ");
        cbleie.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            utLeie = cbleie.isSelected() == true;
        });

        //Registrer knapp & Label
        regLabelBo = new Label();
        regLabelBo.setText("");
        regLabelBo.setId("regLabel");
        regLabelBo.setAlignment(Pos.CENTER);

        btnSjekkpris = new Button();
        btnSjekkpris.setText("Beregn pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> {
            regLabelBo.setText("Prisen er: " + "getPris()");
        });

        btnRegBoligforsikring = new Button();
        btnRegBoligforsikring.setText("Registrer Boligforsikring");
        btnRegBoligforsikring.setId("btnRegBoligforsikring");
        btnRegBoligforsikring.setMinWidth(200);
        btnRegBoligforsikring.setOnAction(eB -> {
            regBorligForsikring();
        });

        gridBolig.add(tfPostnr, 0, 0);
        gridBolig.add(tfAdresse, 0, 1);
        gridBolig.add(tfByggeår, 0, 2);
        gridBolig.add(tfKvadrat, 0, 3);
        gridBolig.add(tfByggSum, 0, 4);
        gridBolig.add(tfInnboSum, 0, 5);
        gridBolig.add(cbBoligtype, 0, 6);
        gridBolig.add(cbStandard, 0, 7);
        gridBolig.add(cbMatriale, 0, 8);
        gridBolig.add(cbleie, 0, 9);
        gridBolig.add(btnSjekkpris, 0, 10);
        gridBolig.add(btnRegBoligforsikring, 0, 11);
        gridBolig.add(regLabelBo, 0, 12);

        gridBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBolig.setVgap(10);
        gridBolig.setHgap(10);
        gridBolig.setAlignment(Pos.CENTER);


        //FritidsBolig--------------------------------------------------------------------->
        gridFriBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridFriBolig.setVgap(10);
        gridFriBolig.setHgap(10);
        gridFriBolig.setAlignment(Pos.CENTER);

        tfPostnrF = new TextField();
        tfPostnrF.setPromptText("Postnummer");
        tfPostnrF.setMinWidth(200);

        tfAdresseF = new TextField();
        tfAdresseF.setPromptText("Adresse");
        tfAdresseF.setMinWidth(200);

        tfByggeårF = new TextField();
        tfByggeårF.setPromptText("Byggeår");
        tfByggeårF.setMinWidth(200);

        tfKvadratF = new TextField();
        tfKvadratF.setPromptText("Kvadratmeter");
        tfKvadratF.setMinWidth(200);

        tfByggSumF = new TextField();
        tfByggSumF.setPromptText("Bolig verdi");
        tfByggSumF.setMinWidth(200);

        tfInnboSumF = new TextField();
        tfInnboSumF.setPromptText("Innbo verdi");
        tfInnboSumF.setMinWidth(200);

        cbBoligtypeF = new ComboBox<>();
        cbBoligtypeF.setEditable(false);
        cbBoligtypeF.setMinWidth(200);
        cbBoligtypeF.getItems().addAll(
                "Enebolig",
                "Tomannsbolig",
                "Leilighet",
                "Rekkehus"
        );
        cbBoligtypeF.setValue("Velg Boligtype:");

        cbStandardF = new ComboBox<>();
        cbStandardF.setEditable(false);
        cbStandardF.setMinWidth(200);
        cbStandardF.getItems().addAll(
                "Dårlig",
                "Gjennomsnittlig",
                "Over gjennomsnitt",
                "Svært Høy"
        );
        cbStandardF.setValue("Standard:");

        cbMatrialeF = new ComboBox<>();
        cbMatrialeF.setEditable(false);
        cbMatrialeF.setMinWidth(200);
        cbMatrialeF.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMatrialeF.setValue("Byggematriale:");

        cbleieF = new CheckBox("Merk om du har utleiemulighet");
        cbleieF.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            utLeie = cbleie.isSelected() == true;
        });

        //Registrer knapp & Label
        regLabelF = new Label();
        regLabelF.setText("");
        regLabelF.setId("regLabel");
        regLabelF.setAlignment(Pos.CENTER);

        btnSjekkprisF = new Button();
        btnSjekkprisF.setText("Beregn pris");
        btnSjekkprisF.setId("btnSjekkpris");
        btnSjekkprisF.setMinWidth(200);
        btnSjekkprisF.setOnAction(eF -> {
            regLabelF.setText("Prisen er: " + "getPris()");
        });

        btnRegBoligforsikringF = new Button();
        btnRegBoligforsikringF.setText("Registrer Boligforsikring");
        btnRegBoligforsikringF.setId("btnRegBoligforsikring");
        btnRegBoligforsikringF.setMinWidth(200);
        btnRegBoligforsikringF.setOnAction(eBF -> {
            regFriBorligForsikring();
        });

        gridFriBolig.add(tfPostnrF, 0, 0);
        gridFriBolig.add(tfAdresseF, 0, 1);
        gridFriBolig.add(tfByggeårF, 0, 2);
        gridFriBolig.add(tfKvadratF, 0, 3);
        gridFriBolig.add(tfByggSumF, 0, 4);
        gridFriBolig.add(tfInnboSumF, 0, 5);
        gridFriBolig.add(cbBoligtypeF, 0, 6);
        gridFriBolig.add(cbStandardF, 0, 7);
        gridFriBolig.add(cbMatrialeF, 0, 8);
        gridFriBolig.add(cbleieF, 0, 9);
        gridFriBolig.add(btnSjekkprisF, 0, 10);
        gridFriBolig.add(btnRegBoligforsikringF, 0, 11);
        gridFriBolig.add(regLabelF, 0, 12);

        gridFriBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridFriBolig.setVgap(10);
        gridFriBolig.setHgap(10);
        gridFriBolig.setAlignment(Pos.CENTER);


        //Alle--------------------------------------------------------------------->
        gridAlle.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridAlle.setVgap(10);
        gridAlle.setHgap(10);
        gridAlle.setAlignment(Pos.TOP_CENTER);

        taLes = new TextArea();
        taLes.setPrefSize(250, 350);
        taLes.setId("taLes");
        taLes.setEditable(false);

        listView.getSelectionModel().selectedItemProperty().addListener(eA -> {
            oppdaterListe();
        });

        gridAlle.add(taLes, 0, 0);

        gridAdvarsel = new GridPane();
        gridAdvarsel.setAlignment(Pos.TOP_CENTER);
        gridAdvarsel.setVisible(false);

        lbAdvarsel = new Label();
        lbAdvarsel.setText("Du må velge en kunde først!");
        lbAdvarsel.setId("advarsel");

        gridAdvarsel.add(lbAdvarsel, 0, 0);


        //--------------------------------------------------------------------------------->>
        //--------------------------------------------------------------------------------->>
        //--------------------------------------------------------------------------------->>
        //--------------------------------------------------------------------------------->>

        //LEFT
        gridLeft = new GridPane();
        gridLeft.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridLeft.setVgap(10);
        gridLeft.setHgap(10);
        gridLeft.setAlignment(Pos.TOP_CENTER);

        gridLeft.add(listView, 0, 0);



        //RIGHT
        gridRight = new GridPane();
        gridRight.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridRight.setVgap(10);
        gridRight.setHgap(10);
        gridRight.setAlignment(Pos.TOP_CENTER);

        gridRight.add(gridBil, 0, 0);
        gridRight.add(gridBåt, 0, 0);
        gridRight.add(gridReise, 0, 0);
        gridRight.add(gridBolig, 0, 0);
        gridRight.add(gridFriBolig, 0, 0);
        gridRight.add(gridAlle, 0, 0);
        gridRight.add(gridAdvarsel, 0, 0);


        vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        //LEFT(grid) + RIGHT(grid) = CENTER(vBox)
        hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        hBox.setSpacing(20);
        hBox.getChildren().addAll(gridLeft, gridRight);

        vb.getChildren().addAll(hb, hBox);

        borderPane.setCenter(vb);

        borderPane.getStylesheets().add("CSS/konsulentkunde.css");
        return borderPane;


    }//End of kundeFane








    //METODER------------------------------->

    private void ruteVipper() {

        ArrayList<String> forsikringliste = kontroll.getInfoForsikringListe(forsikringComboBox.getItems().indexOf(forsikringComboBox.getValue()));
        if (forsikringComboBox.getValue().equals("Bilforsikring")) {
            gridBil.setVisible(true);
        } else {
            gridBil.setVisible(false);
        }

        if (forsikringComboBox.getValue().equals("Reiseforsikring")) {
            gridReise.setVisible(true);
        } else {
            gridReise.setVisible(false);
        }

        if (forsikringComboBox.getValue().equals("Båtforsikring")) {
            gridBåt.setVisible(true);
        } else {
            gridBåt.setVisible(false);
        }

        if (forsikringComboBox.getValue().equals("Boligforsikring")) {
            gridBolig.setVisible(true);
        } else {
            gridBolig.setVisible(false);
        }

        if (forsikringComboBox.getValue().equals("Fri.Boligforsikring")) {
            gridFriBolig.setVisible(true);
        } else {
            gridFriBolig.setVisible(false);
        }

        if (forsikringComboBox.getValue().equals("Alle")) {
            gridAlle.setVisible(true);
        } else {
            gridAlle.setVisible(false);
        }

        if (forsikringliste == null) {
            navn.clear();
            navn.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
        } else {
            navn.setAll(forsikringliste);
        }
    }

    private void regBilForsikring() {

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
        kontroll.setBilForsikring(bil, null);
        regLabelBil.setText("Bilforsikring Registrert!");
    }

    private void regBåtForsikring() {

        regLabelB.setText("Båtforsikring Registrert!");
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
            BatForsikring båt = new BatForsikring(verdi, lengdeFot, regNo, type, modell, årsModell, motorYtelse, motorMerke);
            kontroll.setBåtForsikring(båt);
        } catch (NumberFormatException nfe) {
            System.out.println("Feil tallformat");
        }
    }

    private void regBorligForsikring() {

        String postNr = tfPostnr.getText();
        String adresse = tfAdresse.getText();
        String byggeÅr = tfByggeår.getText();
        double kvadrat = 0;
        double byggSum = 0;
        double innboSum = 0;
        int byggeår = 0;
        String mertiale = cbMatriale.getValue();

        try {
            kvadrat = Double.parseDouble(tfKvadrat.getText());
            byggSum = Double.parseDouble(tfByggSum.getText());
            innboSum = Double.parseDouble(tfInnboSum.getText());
            byggeår = Integer.parseInt(tfKvadrat.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("Feil tallformat.");
        }

        kontroll.setBoligForsikring(utLeie, kvadrat, adresse, "hei", byggeår, "tre", "dårlig", byggSum, innboSum);
        regLabelBo.setText("Boligforsikring registrert!");
    }

    private void regFriBorligForsikring() {
        String postNr = tfPostnr.getText();
        String adresse = tfAdresse.getText();
        String byggeÅr = tfByggeår.getText();
        double kvadrat = 0;
        double byggSum = 0;
        double innboSum = 0;
        int byggeår = 0;
        String mertiale = cbMatriale.getValue();

        try {
            kvadrat = Double.parseDouble(tfKvadrat.getText());
            byggSum = Double.parseDouble(tfByggSum.getText());
            innboSum = Double.parseDouble(tfInnboSum.getText());
            byggeår = Integer.parseInt(tfKvadrat.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("Feil tallformat.");
        }

        kontroll.setFritidsForsikring(utLeie, kvadrat, adresse, "hei", byggeår, "tre", "dårlig", byggSum, innboSum);
        regLabelF.setText("FritidsBoligforsikring registrert!");
    }

    public void oppdaterListe() {
        String polisNr = listView.getSelectionModel().getSelectedItem();
        if (polisNr != null) {
            Forsikringer s = kontroll.getForsikring(Integer.parseInt(polisNr.substring(0, 6).replaceAll("[^0-9]", "0")));
            if (s != null) {
                taLes.setText(s.toString());
            }
        }

    }

    public void settListe() {
        ArrayList<String> forsikringliste = kontroll.
                getInfoForsikringListe(forsikringComboBox.getItems().
                        indexOf(forsikringComboBox.getValue()));
        System.out.println(forsikringliste);
        if (forsikringliste == null) {
            navn.clear();
            navn.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
        } else {
            navn.setAll(forsikringliste);
        }
    }


    public void slettForsikring() {
        String polisNr = listView.getSelectionModel().getSelectedItem();
        if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
            polisNr = polisNr.substring(0, 6);
        } else {
            return;
        }
        kontroll.slettForsikring(Integer.parseInt(polisNr));
        settListe();
    }

}//End of class
