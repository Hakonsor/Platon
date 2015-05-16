package GUI;

import Forsikring.*;
import Person.Bruker;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import Kontroller.Postregister;
import java.text.DecimalFormat;
import java.util.ArrayList;
import Kontroller.Kontroller;
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
    private boolean utLeieF;
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
    private Label postSted;
    private Label postStedF;
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
    private Button btnSjekkprisBo;
    private Button btnSjekkprisF;
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
        lbKonsulent.setText(getKonsulentNavn());
        lbKonsulent.setId("konsulent");

        lbKundenavn = new Label();
        lbKundenavn.setText("Valgt kunde: " + "\"Ingen kunde er valgt\"");
        lbKundenavn.setId("kundenavn");

        FadeTransition ftKunde = new FadeTransition(Duration.millis(1000), lbKundenavn);
        ftKunde.setFromValue(0.0F);
        ftKunde.setToValue(1.0F);
        ftKunde.setCycleCount(5);

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
            if (!lbKundenavn.getText().equals("Valgt kunde: " + "\"Ingen kunde er valgt\"") && !forsikringComboBox.getValue().equals("Velg Forsikring:")) {
                gridAdvarsel.setVisible(false);
                slettForsikring();
            }
            else if (forsikringComboBox.getValue().equals("Velg Forsikring:") && !lbKundenavn.getText().equals("Valgt kunde: " + "\"Ingen kunde er valgt\"")) {
                gridAdvarsel.setVisible(true);
                lbAdvarsel.setText("Du må først velge en forsikring du ønsker å slette");
            }

            else if (lbKundenavn.getText().equals("Valgt kunde: " + "\"Ingen kunde er valgt\"")) {
                gridAdvarsel.setVisible(true);
                lbAdvarsel.setText("Du må velge en kunde fra \"Finn kunde\" først!");
            }
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
                forsikringComboBox.setValue("Velg Forsikring:");
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

        btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Bestill");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);
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
                settListe();
                tfRegnr.clear(); tfÅrsmodell.clear(); tfMerke.clear(); tfModell.clear(); tfKmstand.clear(); cbBonus.setValue("Velg Bonus:"); cbEgenandel.setValue("Velg Egenandel"); cbKjørelengde.setValue("Velg Kjørelengde:");

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


                rbtnEuropa.setSelected(false); rbtnNorden.setSelected(false); rbtnVerden.setSelected(false);
                lbPrint.setText("Reiseforsikring " + type + " bestilt!");
                settListe();
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
                tfRegnrB.clear(); tfÅrsmodellB.clear(); tfBåtmodell.clear(); tfAntfot.clear(); tfMotormerke.clear(); tfYtelse.clear(); tfVerdiB.clear();
                rbtMotorbåt.setSelected(false); rbtSeilbåt.setSelected(false);
                settListe();
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

        tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setId("promtfix");
        tfPostnr.setAlignment(Pos.CENTER_LEFT);
        tfPostnr.setMaxWidth(70);
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

        postSted = new Label();
        postSted.setText("");
        postSted.setId("promtfix");
        postSted.setAlignment(Pos.CENTER_LEFT);
        postSted.setMaxWidth(100);

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

        cbleie = new CheckBox( "Er dette utleiebolig ? ");
        cbleie.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (cbleie.isSelected()) {
                utLeie = true;

            } else {
                utLeie = false;
                System.out.println("Nei");
            }
        });

        regLabelBo = new Label();
        regLabelBo.setText("");
        regLabelBo.setId("regLabel");
        regLabelBo.setAlignment(Pos.CENTER);

        btnSjekkprisBo = new Button();
        btnSjekkprisBo.setText("Sjekk Pris");
        btnSjekkprisBo.setId("btnSjekkpris");
        btnSjekkprisBo.setMaxWidth(200);
        btnSjekkprisBo.setOnAction(e -> {
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
                regLabelBo.setText("Årlig premie: " + tall.format(f.getPremie()) + " kr");
            } else {
                regLabelBo.setText("Sjekk feil i feltene ovenfor");
            }

        });

        btnRegBoligforsikring = new Button();
        btnRegBoligforsikring.setText("Bestill");
        btnRegBoligforsikring.setId("btnRegBoligforsikring");
        btnRegBoligforsikring.setMaxWidth(200);
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

                tfAdresse.clear(); tfPostnr.clear(); tfByggeår.clear(); tfKvadrat.clear(); tfByggSum.clear(); tfInnboSum.clear(); cbBoligtype.setValue("Velg Boligtype:"); cbStandard.setValue("Standard:"); cbMatriale.setValue("Byggematriale:"); cbleie.setSelected(false);
                kontroll.setBoligForsikring(utLeie, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, innboSum);
                settListe();
                regLabelBo.setText("Boligforsikring registrert!");
            } else {
                regLabelBo.setText("Sjekk feil i feltene ovenfor");
            }
        });

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

        gridBolig.add(tfAdresse, 0, 0, 2, 1);
        gridBolig.add(tfPostnr, 0, 1, 2, 1);
        gridBolig.add(postSted, 1, 1);
        gridBolig.add(tfByggeår, 0, 2);
        gridBolig.add(tfKvadrat, 1, 2);
        gridBolig.add(tfByggSum, 0, 3);
        gridBolig.add(tfInnboSum, 1, 3);
        gridBolig.add(cbBoligtype, 0, 4, 2, 1);
        gridBolig.add(cbStandard, 0, 5, 2, 1);
        gridBolig.add(cbMatriale, 0, 6, 2, 1);
        gridBolig.add(cbleie, 0, 7, 2, 1);
        gridBolig.add(btnSjekkprisBo, 0, 8, 2, 1);
        gridBolig.add(btnRegBoligforsikring, 0, 9, 2, 1);
        gridBolig.add(regLabelBo, 0, 10, 2, 1);

        gridBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBolig.setVgap(10);
        gridBolig.setHgap(10);
        gridBolig.setAlignment(Pos.TOP_CENTER);


        //FritidsBolig--------------------------------------------------------------------->
        gridFriBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridFriBolig.setVgap(10);
        gridFriBolig.setHgap(10);
        gridFriBolig.setAlignment(Pos.CENTER);

        tfAdresseF = new TextField();
        tfAdresseF.setPromptText("Adresse");
        tfAdresseF.setId("promtfix");
        tfAdresseF.setMaxWidth(200);
        tfAdresseF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z0-9 _]+";
                String adresse = tfAdresseF.getText();

                if (adresse.matches(regex)) {
                    tfAdresseF.setId("valid");
                } else {
                    tfAdresseF.setId("error");
                }
                if (adresse.length() == 0) {
                    tfAdresseF.setId("promtfix");
                }
            }
        });

        tfByggeårF = new TextField();
        tfByggeårF.setPromptText("Byggeår");
        tfByggeårF.setId("promtfix");
        tfByggeårF.setMaxWidth(95);
        tfByggeårF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String byggår = tfByggeårF.getText();

                if (!byggår.matches(regex) || byggår.length() > 4 || byggår.length() < 4) {
                    tfByggeårF.setId("error");
                } else {
                    tfByggeårF.setId("valid");
                }
                if (byggår.length() == 0) {
                    tfByggeårF.setId("promtfix");
                }
            }
        });

        tfKvadratF = new TextField();
        tfKvadratF.setPromptText("KVM");
        tfKvadratF.setId("promtfix");
        tfKvadratF.setMaxWidth(95);
        tfKvadratF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String KVM = tfKvadratF.getText();

                if (!KVM.matches(regex) || KVM.length() > 6) {
                    tfKvadratF.setId("error");
                } else {
                    tfKvadratF.setId("valid");
                }
                if (KVM.length() == 0) {
                    tfKvadratF.setId("promtfix");
                }
            }
        });

        tfByggSumF = new TextField();
        tfByggSumF.setPromptText("Bolig verdi");
        tfByggSumF.setId("promtfix");
        tfByggSumF.setMaxWidth(95);
        tfByggSumF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String byggsum = tfByggSumF.getText();

                if (!byggsum.matches(regex) || byggsum.length() > 12) {
                    tfByggSumF.setId("error");
                } else {
                    tfByggSumF.setId("valid");
                }
                if (byggsum.length() == 0) {
                    tfByggSumF.setId("promtfix");
                }
            }
        });

        tfInnboSumF = new TextField();
        tfInnboSumF.setPromptText("Innbo verdi");
        tfInnboSumF.setId("promtfix");
        tfInnboSumF.setMaxWidth(95);
        tfInnboSumF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String innbosum = tfInnboSumF.getText();

                if (!innbosum.matches(regex) || innbosum.length() > 12) {
                    tfInnboSumF.setId("error");
                } else {
                    tfInnboSumF.setId("valid");
                }
                if (innbosum.length() == 0) {
                    tfInnboSumF.setId("promtfix");
                }
            }
        });

        tfPostnrF = new TextField();
        tfPostnrF.setPromptText("PostNr");
        tfPostnrF.setId("promtfix");
        tfPostnrF.setAlignment(Pos.CENTER_LEFT);
        tfPostnrF.setMaxWidth(70);
        tfPostnrF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String postnr = tfPostnrF.getText();

                if (!postnr.matches(regex) || postnr.length() > 4 || postnr.length() < 4) {
                    tfPostnrF.setId("error");
                } else {
                    tfPostnrF.setId("valid");
                }
                if (postnr.length() == 0) {
                    tfPostnrF.setId("promtfix");
                }
            }
        });

        postStedF = new Label();
        postStedF.setText("");
        postStedF.setId("promtfix");
        postStedF.setAlignment(Pos.CENTER_LEFT);
        postStedF.setMaxWidth(100);

        cbBoligtypeF = new ComboBox<>();
        cbBoligtypeF.setEditable(false);
        cbBoligtypeF.setId("combobox");
        cbBoligtypeF.setMaxWidth(200);
        cbBoligtypeF.getItems().addAll(
                "Enebolig",
                "Tomannsbolig",
                "Leilighet",
                "Rekkehus"
        );
        cbBoligtypeF.setValue("Velg Boligtype:");

        cbStandardF = new ComboBox<>();
        cbStandardF.setEditable(false);
        cbStandardF.setId("combobox");
        cbStandardF.setMaxWidth(200);
        cbStandardF.getItems().addAll(
                "Dårlig",
                "Gjennomsnittlig",
                "Over gjennomsnitt",
                "Svært Høy"
        );
        cbStandardF.setValue("Standard:");

        cbMatrialeF = new ComboBox<>();
        cbMatrialeF.setEditable(false);
        cbMatrialeF.setId("combobox");
        cbMatrialeF.setMaxWidth(200);
        cbMatrialeF.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMatrialeF.setValue("Byggematriale:");

        cbleieF = new CheckBox( "Er dette utleiebolig ? ");
        cbleieF.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (cbleieF.isSelected()) {
                utLeieF = true;

            } else {
                utLeieF = false;
                System.out.println("Nei");
            }
        });

        regLabelF = new Label();
        regLabelF.setText("");
        regLabelF.setId("regLabel");
        regLabelF.setAlignment(Pos.CENTER);

        btnSjekkprisF = new Button();
        btnSjekkprisF.setText("Sjekk Pris");
        btnSjekkprisF.setId("btnSjekkpris");
        btnSjekkprisF.setMaxWidth(200);
        btnSjekkprisF.setOnAction(e -> {
            if (tfAdresseF.getId().equals("valid")
                    && tfPostnrF.getId().equals("valid")
                    && tfByggeårF.getId().equals("valid")
                    && tfKvadratF.getId().equals("valid")
                    && tfByggSumF.getId().equals("valid")
                    && tfInnboSumF.getId().equals("valid")
                    && !cbBoligtypeF.getValue().equals("Velg Boligtype:")
                    && !cbStandardF.getValue().equals("Standard:")
                    && !cbMatrialeF.getValue().equals("Byggematriale:")
                    ) {

                String postNr = tfPostnrF.getText();
                String adresse = tfAdresseF.getText();
                String standard = cbStandardF.getValue();
                String materiale = cbMatrialeF.getValue();
                String boligType = cbBoligtypeF.getValue();
                int byggeÅr = 0;
                double kvadrat = 0;
                double byggSum = 0;
                double innboSum = 0;
                try {
                    kvadrat = Double.parseDouble(tfKvadratF.getText());
                    byggSum = Double.parseDouble(tfByggSumF.getText());
                    innboSum = Double.parseDouble(tfInnboSumF.getText());
                    byggeÅr = Integer.parseInt(tfByggeårF.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat.");
                }
                BoligForsikring f = new BoligForsikring(utLeieF, kvadrat, adresse, boligType, byggeÅr,
                        materiale, standard, byggSum, innboSum);
                String form = "0.00";
                DecimalFormat tall = new DecimalFormat(form);
                regLabelF.setText("Årlig premie: " + tall.format(f.getPremie()) + " kr");
            } else {
                regLabelF.setText("Sjekk feil i feltene ovenfor");
            }
        });

        btnRegBoligforsikringF = new Button();
        btnRegBoligforsikringF.setText("Bestill");
        btnRegBoligforsikringF.setId("btnRegBoligforsikring");
        btnRegBoligforsikringF.setMaxWidth(200);
        btnRegBoligforsikringF.setOnAction(e -> {
            if (tfAdresseF.getId().equals("valid")
                    && tfPostnrF.getId().equals("valid")
                    && tfByggeårF.getId().equals("valid")
                    && tfKvadratF.getId().equals("valid")
                    && tfByggSumF.getId().equals("valid")
                    && tfInnboSumF.getId().equals("valid")
                    && !cbBoligtypeF.getValue().equals("Velg Boligtype:")
                    && !cbStandardF.getValue().equals("Standard:")
                    && !cbMatrialeF.getValue().equals("Byggematriale:")
                    ) {

                String postNr = tfPostnrF.getText();
                String adresse = tfAdresseF.getText();
                String byggeÅr = tfByggeårF.getText();
                String standard = cbStandardF.getValue();
                String materiale = cbMatrialeF.getValue();
                String boligType = cbBoligtypeF.getValue();
                double kvadrat = 0;
                double byggSum = 0;
                double innboSum = 0;
                int byggeår = 0;

                try {
                    kvadrat = Double.parseDouble(tfKvadratF.getText());
                    byggSum = Double.parseDouble(tfByggSumF.getText());
                    innboSum = Double.parseDouble(tfInnboSumF.getText());
                    byggeår = Integer.parseInt(tfKvadratF.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat.");
                }
                tfAdresseF.clear(); tfPostnrF.clear(); tfByggeårF.clear(); tfKvadratF.clear(); tfByggSumF.clear(); tfInnboSumF.clear(); cbBoligtypeF.setValue("Velg Boligtype:"); cbStandardF.setValue("Standard:"); cbMatrialeF.setValue("Byggematriale:"); cbleieF.setSelected(false);
                kontroll.setFritidsForsikring(utLeieF, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, innboSum);
                settListe();
                regLabelF.setText("Fritidsboligforsikring registrert!");
            } else {
                regLabelF.setText("Sjekk feil i feltene ovenfor");
            }

        });

        tfPostnrF.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Postregister register = new Postregister();
                String poststed = register.getPoststed(tfPostnrF.getText());
                if (poststed == null) {
                    poststed = "Finnes ikke!";
                }
                if (tfPostnrF.getText().equals("")) {
                    postStedF.setText("");
                    postStedF.setText("PostSted");
                } else
                    postStedF.setText(poststed);
            }
        });

        gridFriBolig.add(tfAdresseF, 0, 0, 2, 1);
        gridFriBolig.add(tfPostnrF, 0, 1, 2, 1);
        gridFriBolig.add(postStedF, 1, 1);
        gridFriBolig.add(tfByggeårF, 0, 2);
        gridFriBolig.add(tfKvadratF, 1, 2);
        gridFriBolig.add(tfByggSumF, 0, 3);
        gridFriBolig.add(tfInnboSumF, 1, 3);
        gridFriBolig.add(cbBoligtypeF, 0, 4, 2, 1);
        gridFriBolig.add(cbStandardF, 0, 5, 2, 1);
        gridFriBolig.add(cbMatrialeF, 0, 6, 2, 1);
        gridFriBolig.add(cbleieF, 0, 7, 2, 1);
        gridFriBolig.add(btnSjekkprisF, 0, 8, 2, 1);
        gridFriBolig.add(btnRegBoligforsikringF, 0, 9, 2, 1);
        gridFriBolig.add(regLabelF, 0, 10, 2, 1);

        gridFriBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridFriBolig.setVgap(10);
        gridFriBolig.setHgap(10);
        gridFriBolig.setAlignment(Pos.TOP_CENTER);


        //Alle--------------------------------------------------------------------->
        gridAlle.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridAlle.setVgap(10);
        gridAlle.setHgap(10);
        gridAlle.setAlignment(Pos.TOP_CENTER);

        taLes = new TextArea();
        taLes.setPrefSize(350, 350);
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
        lbAdvarsel.setText("Du må velge en kunde fra \"Finn kunde\" først!");
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
        vb.setAlignment(Pos.TOP_CENTER);
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

        if (forsikringComboBox.getValue().equals("Fritidsbolig")) {
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

    private String getKonsulentNavn(){
        Bruker b = kontroll.getInnloggetKonsulent();
        return "Hei " + b.getFornavn() + " " + b.getEtternavn();
    }

}//End of class
