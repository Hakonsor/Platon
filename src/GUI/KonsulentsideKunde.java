package GUI;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.Forsikringer;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import java.util.ArrayList;

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

import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 * Created by Magnus on 27.04.15.
 */
public class KonsulentsideKunde implements ComboBoxConverter {

    public static Label lbKundenavn;
    private Kontroller kontroll;
    private String type;
    private boolean utLeie;
    private HBox hb;
    private HBox hBox;
    private Button btnSøk;
    private Button btnRegKunde;
    private BorderPane borderPane;
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
    private Label lballe;
    private Label regLabelBo;
    private Label regLabelB;
    private Label lbInfo;
    private Label lbPrint;
    private Button btnRegBåtforsikring;
    private Button btnRegBilforsikring;
    private Button btnSjekkprisBil;
    private Button btnRegBoligforsikringF;
    private Button btnSlett;
    private Button btnRegForsikring;
    private Button btnRegBoligforsikring;
    private Button btnSjekkpris;
    private Button btnSjekkprisB;
    private CheckBox cbleie;

    private ObservableList<String> navn;
    private ObservableList<String> data;

    private ComboBox<String> forsikringComboBox;

    public Pane kundeFane(Kontroller kontroll) {
        this.kontroll = kontroll;

        borderPane = new BorderPane();
        borderPane.setId("borderpane");
        borderPane.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left


        //TOP---------------------------------->
        hb = new HBox();
        hb.setPadding(new Insets(130, 10, 30, 0)); //top/right/bottom/left
        hb.setSpacing(70);
        hb.setAlignment(Pos.CENTER);

        lbKundenavn = new Label();
        lbKundenavn.setText("Du behandler: \"Ingen kunde er valgt\"");
        lbKundenavn.setId("kundenavn");

        btnSøk = new Button();
        btnSøk.setText("Finn kunde");
        btnSøk.setId("sok");
        btnSøk.setMinWidth(100);
        btnSøk.setOnAction(e -> {
            kontroll.sok();
        });

        btnSlett = new Button();
        btnSlett.setText("Slett forsikring");
        btnSlett.setId("slett");
        btnSlett.setOnAction(e -> { slettForsikring(); });

        btnRegKunde = new Button();
        btnRegKunde.setText("Reg. kunde");
        btnRegKunde.setId("regKunde");
        btnRegKunde.setMinWidth(150);
        btnRegKunde.setOnAction(e -> {
            kontroll.regVindu();
        });

        hb.getChildren().addAll(lbKundenavn, btnSøk, btnSlett, btnRegKunde);
        borderPane.setTop(hb);


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

        navn = FXCollections.observableArrayList();
        data = FXCollections.observableArrayList();
        forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll(
                "Alle",
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fritidsbolig"
        );

        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {
            ruteVipper();
        });

        listView = new ListView<>(data);
        listView.setPrefSize(300, 400);
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
        gridBil.setAlignment(Pos.CENTER);

        regLabelBil = new Label();
        regLabelBil.setText("");

        tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);

        tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        tfMerke = new TextField();
        tfMerke.setPromptText("eks (BMW)");
        tfMerke.setId("promtfix");
        tfMerke.setMinWidth(200);

        tfModell = new TextField();
        tfModell.setPromptText("eks (5-serie 530xd)");
        tfModell.setId("promtfix");
        tfModell.setMinWidth(200);

        tfKmstand = new TextField();
        tfKmstand.setPromptText("Km-stand");
        tfKmstand.setMinWidth(200);

        cbKjørelengde = new ComboBox<>();
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

        cbBonus = new ComboBox<>();
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

        cbEgenandel = new ComboBox<>();
        cbEgenandel.setEditable(false);
        cbEgenandel.setMinWidth(200);
        cbEgenandel.getItems().addAll(
                "Egenandel:  4 000,-",
                "Egenandel:  6 000,-",
                "Egenandel: 10 000,-"
        );
        cbEgenandel.setValue("Velg Egenandel:");

        btnSjekkprisBil = new Button();
        btnSjekkprisBil.setText("Beregn Pris");
        btnSjekkprisBil.setId("btnSjekkpris");
        btnSjekkprisBil.setMinWidth(200);
        btnSjekkprisBil.setOnAction(e -> {
            regLabelBil.setText("Prisen er: " + "getPris()");
        });

        btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Registrer Bilforsikring");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);
        btnRegBilforsikring.setOnAction(e -> {
            regBilForsikring();
        });

        gridBil.add(tfRegnr, 0, 0);
        gridBil.add(tfKmstand, 0, 1);
        gridBil.add(tfÅrsmodell, 0, 2);
        gridBil.add(tfMerke, 0, 3);
        gridBil.add(tfModell, 0, 4);
        gridBil.add(cbKjørelengde, 0, 5);
        gridBil.add(cbBonus, 0, 6);
        gridBil.add(cbEgenandel, 0, 7);
        gridBil.add(btnSjekkprisBil, 0, 8);
        gridBil.add(btnRegBilforsikring, 0, 9);
        gridBil.add(regLabelBil, 0, 10);

        //Reise--------------------------------------------------------------------->
        lbInfo = new Label();
        lbInfo.setText("Velg reiseforsikringstype:");
        lbInfo.setId("lbInfo");
        lbInfo.setAlignment(Pos.CENTER_LEFT);

        lbPrint = new Label();
        lbPrint.setId("print");
        lbPrint.setText("");
        lbPrint.setAlignment(Pos.CENTER_LEFT);

        ToggleGroup reise = new ToggleGroup();

        RadioButton rbtnVerden = new RadioButton("Veden");
        rbtnVerden.setId("verden");
        rbtnVerden.setToggleGroup(reise);
        rbtnVerden.setSelected(true);
        rbtnVerden.setAlignment(Pos.CENTER_LEFT);
        rbtnVerden.setOnAction(e -> {
            type = "Verden";
        });

        RadioButton rbtnEuropa = new RadioButton("Europa");
        rbtnEuropa.setId("europa");
        rbtnEuropa.setToggleGroup(reise);
        rbtnEuropa.setSelected(true);
        rbtnEuropa.setOnAction(e -> {
            type = "Europa";
        });

        RadioButton rbtnNorden = new RadioButton("Norden");
        rbtnNorden.setId("norden");
        rbtnNorden.setToggleGroup(reise);
        rbtnNorden.setSelected(true);
        rbtnNorden.setOnAction(e -> {
            type = "Norden";
        });

        Button btnBeregn = new Button();
        btnBeregn.setText("Beregn pris");
        btnBeregn.setMinWidth(100);
        btnBeregn.setId("beregn");
        btnBeregn.setOnAction(e -> {
            lbPrint.setText("Prisen er: getPris()");
        });

        Button btnBestill = new Button();
        btnBestill.setText("Bestill");
        btnBestill.setMinWidth(100);
        btnBestill.setId("bestill");
        btnBestill.setOnAction(eBestill -> {
            lbPrint.setText("Reiseforsikring bestilt!");
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
        gridReise.setAlignment(Pos.CENTER);
        gridReise.setGridLinesVisible(false);


        //Båt--------------------------------------------------------------------->
        gridBåt.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBåt.setVgap(10);
        gridBåt.setHgap(10);
        gridBåt.setAlignment(Pos.CENTER);

        Label lbbåt = new Label("Test tekst, du har vlagt Båt");
        gridBåt.add(lbbåt, 0, 0);

        tfVerdi = new TextField();
        tfVerdi.setPromptText("Båtens verdi");
        tfVerdi.setMinWidth(200);

        tfRegnrB = new TextField();
        tfRegnrB.setPromptText("Reg.Nr");
        tfRegnrB.setMinWidth(200);

        tfÅrsmodellB = new TextField();
        tfÅrsmodellB.setPromptText("Årsmodell");
        tfÅrsmodellB.setMinWidth(200);

        tfBåtmodell = new TextField();
        tfBåtmodell.setPromptText("Båtmodell eks (Ibiza 22");
        tfBåtmodell.setMinWidth(200);

        tfAntfot = new TextField();
        tfAntfot.setPromptText("Antall fot");
        tfAntfot.setMinWidth(200);

        tfMotormerke = new TextField();
        tfMotormerke.setPromptText("Motormerke");
        tfMotormerke.setMinWidth(200);

        tfYtelse = new TextField();
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
        regLabelB = new Label();
        regLabelB.setText("");
        regLabelB.setId("regLabel");
        regLabelB.setAlignment(Pos.CENTER);

        btnSjekkprisB = new Button();
        btnSjekkprisB.setText("Sjekk Pris");
        btnSjekkprisB.setId("btnSjekkpris");
        btnSjekkprisB.setMinWidth(200);
        btnSjekkprisB.setOnAction(e -> {
            regLabelB.setText("Prisen er: " + "getPris()");
        });

        btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Registrer Båtforsikring");
        btnRegBåtforsikring.setId("btnRegBåtforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        btnRegBåtforsikring.setOnAction(e -> {
            regBåtForsikring();
        });

        gridBåt.add(tfVerdi, 0, 0);
        gridBåt.add(tfRegnrB, 0, 1);
        gridBåt.add(tfÅrsmodellB, 0, 2);
        gridBåt.add(tfBåtmodell, 0, 3);
        gridBåt.add(tfAntfot, 0, 4);
        gridBåt.add(tfMotormerke, 0, 5);
        gridBåt.add(tfYtelse, 0, 6);
        gridBåt.add(rbtMotorbåt, 0, 7);
        gridBåt.add(rbtSeilbåt, 0, 8);
        gridBåt.add(btnSjekkprisB, 0, 9);
        gridBåt.add(btnRegBåtforsikring, 0, 10);
        gridBåt.add(regLabelB, 0, 11);


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
        gridAlle.setAlignment(Pos.CENTER);

        taLes = new TextArea();
        taLes.setPrefSize(300, 400);
        taLes.setId("taLes");
        taLes.setEditable(false);

        listView.getSelectionModel().selectedItemProperty().addListener(eA -> {
            oppdaterListe();
        });

        lballe = new Label(" ");
        gridAlle.add(lballe, 0, 0);
        gridAlle.add(taLes, 0, 1);


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

        gridLeft.add(forsikringComboBox, 0, 0);
        gridLeft.add(listView, 0, 1);



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



        //LEFT(grid) + RIGHT(grid) = CENTER(vBox)
        hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        hBox.setSpacing(20);
        hBox.getChildren().addAll(gridLeft, gridRight);

        borderPane.setCenter(hBox);

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
