package GUI;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.BoligForsikring;
import Forsikring.Forsikringer;
import Forsikring.FritidsBolig;
import Forsikring.ReiseForsikring;
import Kontroller.Kontroller;
import SkadeMeldinger.BatSkadeMelding;
import SkadeMeldinger.BilSkadeMelding;
import SkadeMeldinger.BoligSkadeMelding;
import SkadeMeldinger.FritidsBoligMelding;
import SkadeMeldinger.ReiseSkadeMelding;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by Magnus on 27.04.15.
 *
 * @author Therese, Håkon
 *
 * 
 */
public class KundesideSkade {

    Kontroller  kontroll;
    private Calendar dato;
    private String skade = "BrannSkade";
    private ObservableList<String> data = FXCollections.observableArrayList();
    private ListView<String> listView = new ListView<>(data);
    private TextField tfBeløp;
    private BorderPane borderPane;
    private VBox vb;
    private GridPane gridFelt;
    private GridPane grid;
    private ComboBox<String> forsikringComboBox;
    private Label lbInfo;
    private TextArea skriveOmråde;
    
    private ToggleGroup skadeType;
    private RadioButton rbtVann;
    private RadioButton rbtRør;
    private RadioButton rbtBrann;
    
    private GridPane radioGrid;
    private Label lbSkadebeløp;
    private Label lbDato;
    private DatePicker dpDato;
    private FileChooser fileChooser;
    private Button btnÅpnefil;
    private Label lbSkade;
    private Button btnRapSkade;
    private Label lbFeilFormat;
    

    public Pane skadeFane(Kontroller kontroll) {
        this.kontroll = kontroll;

        borderPane = new BorderPane();
        borderPane.setId("borderpane");

        vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        vb.setPadding(new Insets(60, 10, 10, 10));//top/right/bottom/left
        //vb.setStyle("-fx-border-color: blue;");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        //grid.setPadding(new Insets(10));

        //Skjema
        forsikringComboBox = new ComboBox<String>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.setId("forsikring");
        forsikringComboBox.getItems().addAll(
                "Alle",
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {
            SkrivListe();
        });

        FadeTransition ftcombo = new FadeTransition(Duration.millis(100), forsikringComboBox);
        ftcombo.setFromValue(0.0F);
        ftcombo.setToValue(1.0F);
        ftcombo.setCycleCount(1);

        FadeTransition ftcombo = new FadeTransition(Duration.millis(100), forsikringComboBox);
        ftcombo.setFromValue(0.0F);
        ftcombo.setToValue(1.0F);
        ftcombo.setCycleCount(1);

        lbInfo = new Label();
        lbInfo.setText("Info om skaden:");
        lbInfo.setId("lbInfo");
        lbInfo.setVisible(false);

        gridFelt = new GridPane();
        gridFelt.setAlignment(Pos.CENTER);
        gridFelt.setHgap(10);
        gridFelt.setVgap(10);

        skriveOmråde = new TextArea();
        skriveOmråde.setEditable(true);
        skriveOmråde.setId("felt");
        skriveOmråde.setPromptText("Skriv innformasjon om skaden");
        skriveOmråde.setPrefSize(300, 300);
        skriveOmråde.setOnMouseEntered(e -> {
            skriveOmråde.setPromptText("Skriv innformasjon om skaden");
        });
        skriveOmråde.setStyle("-fx-prompt-text-fill: rgba(0, 0, 0)");

        FadeTransition ftskrive = new FadeTransition(Duration.millis(100), skriveOmråde);
        ftskrive.setFromValue(0.0F);
        ftskrive.setToValue(1.0F);
        ftskrive.setCycleCount(1);
        
        listView.setPrefSize(200, 300);
        listView.setId("felt");
        listView.setEditable(false);

        data.addAll("   ");

        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(data));
        listView.getSelectionModel().selectedItemProperty().addListener((Observable e) -> {
            settKnapper();
        });

        FadeTransition ftlist = new FadeTransition(Duration.millis(100), listView);
        ftlist.setFromValue(0.0F);
        ftlist.setToValue(1.0F);
        ftlist.setCycleCount(1);

        skadeType = new ToggleGroup();
        rbtVann = new RadioButton("Vannskade");
        rbtVann.setToggleGroup(skadeType);
        rbtVann.setSelected(true);
        rbtVann.setOnAction(e -> {
            skade = "VannSkade";
        });
        rbtVann.setVisible(false);

        rbtRør = new RadioButton("Rørskade");
        rbtRør.setToggleGroup(skadeType);
        rbtRør.setSelected(true);
        rbtRør.setOnAction(e -> {
            skade = "RørSkade";
        });
        rbtRør.setVisible(false);

        rbtBrann = new RadioButton("Brannskade");
        rbtBrann.setToggleGroup(skadeType);
        rbtBrann.setSelected(true);
        rbtBrann.setOnAction(e -> {
            skade = "BrannSkade";
        });
        rbtBrann.setVisible(false);

        gridFelt.add(forsikringComboBox, 0, 0);
        gridFelt.add(listView, 0, 1);
        gridFelt.add(skriveOmråde, 1, 1);

        lbSkadebeløp = new Label();
        lbSkadebeløp.setText("Samlet skadebeløp:");
        lbSkadebeløp.setId("lbSkadebeløp");

        FadeTransition ftLabelskadebeløp = new FadeTransition(Duration.millis(100), lbSkadebeløp);
        ftLabelskadebeløp.setFromValue(0.0F);
        ftLabelskadebeløp.setToValue(1.0F);
        ftLabelskadebeløp.setCycleCount(1);

        tfBeløp = new TextField();
        tfBeløp.setMaxWidth(100);
        tfBeløp.setId("promtfix");
        tfBeløp.setAlignment(Pos.CENTER_LEFT);
        tfBeløp.setPromptText("Beløp:");
        tfBeløp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String beløp = tfBeløp.getText();

                if (!beløp.matches(regex) || beløp.length() > 12) {
                    tfBeløp.setId("error");
                } else {
                    tfBeløp.setId("valid");
                }
                if (beløp.length() == 0) {
                    tfBeløp.setId("promtfix");
                }
            }
        });

        FadeTransition ftBeløp = new FadeTransition(Duration.millis(100), tfBeløp);
        ftBeløp.setFromValue(0.0F);
        ftBeløp.setToValue(1.0F);
        ftBeløp.setCycleCount(1);

        lbDato = new Label();
        lbDato.setText("Velg dato for hendelsen:");
        lbDato.setId("lbDato");

        FadeTransition ftlbdato = new FadeTransition(Duration.millis(100), lbDato);
        ftlbdato.setFromValue(0.0F);
        ftlbdato.setToValue(1.0F);
        ftlbdato.setCycleCount(1);

        dpDato = new DatePicker();
        dpDato.setId("promtfix");
        dpDato.setMaxWidth(120);
        dpDato.setPromptText("dd.mm.åååå");
        dpDato.setEditable(false);
        dpDato.setOnAction((ActionEvent e) -> {
            sjekkDate();
        });
        dpDato.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                if (dpDato.getValue() != null) {
                    dpDato.setId("valid");
                } else {
                    dpDato.setId("promtfix");
                }
            }
        });

        FadeTransition ftdato = new FadeTransition(Duration.millis(100), dpDato);
        ftdato.setFromValue(0.0F);
        ftdato.setToValue(1.0F);
        ftdato.setCycleCount(1);

        fileChooser = new FileChooser();

        btnÅpnefil = new Button("Velg fil");
        btnÅpnefil.setMaxWidth(100);
        btnÅpnefil.setId("fil");
        btnÅpnefil.setOnAction(e -> {
            fileChooser.showOpenMultipleDialog(new Stage());
        });

        FadeTransition ftfil = new FadeTransition(Duration.millis(100), btnÅpnefil);
        ftfil.setFromValue(0.0F);
        ftfil.setToValue(1.0F);
        ftfil.setCycleCount(1);

        btnRapSkade = new Button();
        btnRapSkade.setText("Meld skade");
        btnRapSkade.setId("btnRapSkade");
        btnRapSkade.setMinWidth(100);
        btnRapSkade.setOnAction((ActionEvent e) -> {
            repSkade();
        });

        FadeTransition ftmeldskade = new FadeTransition(Duration.millis(100), btnRapSkade);
        ftmeldskade.setFromValue(0.0F);
        ftmeldskade.setToValue(1.0F);
        ftmeldskade.setCycleCount(1);

        SequentialTransition st = new SequentialTransition(ftcombo, ftlist, ftskrive, ftLabelskadebeløp, ftlbdato, ftBeløp, ftdato, ftfil, ftmeldskade);
        st.play();

        grid.add(rbtBrann, 2, 0);
        grid.add(rbtRør, 2, 1);
        grid.add(rbtVann, 2, 2);

        grid.add(lbSkadebeløp, 0, 0);
        grid.add(tfBeløp, 0, 1);
        grid.add(btnÅpnefil, 0, 2);

        grid.add(lbDato, 1, 0);
        grid.add(dpDato, 1, 1);
        grid.add(btnRapSkade, 1, 2);

        vb.getChildren().addAll(gridFelt, grid, lbInfo);

        gridFelt.setGridLinesVisible(false);
        grid.setGridLinesVisible(false);
        borderPane.setCenter(vb); // CENTER
        

        // finner ut hvilken forsikring det er og legger skademeldingen i køen,
        // her beregnes også skadesummen samt nye premier, men premien settes endelig,
        // først når konsulenten har godkjent beløpet/ skademeldingen.

        borderPane.getStylesheets().add("CSS/kundeskade.css");
        return borderPane;
    }




      // henter datoen og konverterer den til Calendar
    private void sjekkDate(){
                LocalDate date = dpDato.getValue();
                Date dat = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                dato = Calendar.getInstance();
                dato.setTime(dat);
    }
    private void SkrivListe(){
        skriveOmråde.clear();
            ArrayList<String> forsikringliste = kontroll.
                    getInfoForsikringListe(forsikringComboBox.getItems().
                            indexOf(forsikringComboBox.getValue()));
            if (forsikringliste == null) {
                data.clear();
                data.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
            } else {
                data.setAll(forsikringliste);
        }
    }
    private void settKnapper(){
    
            skriveOmråde.clear();
            String polisNr = listView.getSelectionModel().getSelectedItem();
            if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
                polisNr = polisNr.substring(0, 6);
            }else{
                lbInfo.setText("Vennligst velg en forsikring");
                return;
            }
            //heter inn en string brukeren har stykketpå og kutter av alt etter 6 tegn og fjerner alle bokstaver og leter etter en forsikring med det som er igjen
            Forsikringer fors = kontroll.getForsikring(
                    Integer.parseInt(polisNr));
            if (fors != null) {
                skriveOmråde.setEditable(true);
                if (fors instanceof BoligForsikring || fors instanceof FritidsBolig) {
                    rbtVann.setVisible(true);
                    rbtBrann.setVisible(true);
                    rbtRør.setVisible(true);
                } else {
                    rbtVann.setVisible(false);
                    rbtBrann.setVisible(false);
                    rbtRør.setVisible(false);
                }
            } else {
                skriveOmråde.setEditable(false);
            }
        }

        // finner ut hvilken forsikring det er og legger skademeldingen i køen,
        // her beregnes også skadesummen samt nye premier, men premien settes endelig,
        // først når konsulenten har godkjent beløpet/ skademeldingen.
        public void repSkade(){
            String polisNr = listView.getSelectionModel().getSelectedItem();
            if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
                polisNr = polisNr.substring(0, 6);
            }else{
                lbInfo.setText("Vennligst velg en forsikring");
                return;
            }
            if(dato == null || dato.after(Calendar.getInstance())){
                lbInfo.setText("Vennligst sett en gyldig dato");
                return;
            }

            Forsikringer fors = kontroll.getForsikring(Integer.parseInt(polisNr));
            try {
                //skriveOmråde.clear();
                if (fors instanceof BilForsikring) {

                    BilForsikring f = (BilForsikring) fors;
                    BilSkadeMelding bil = new BilSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bil.setForsikring(f);
                    bil.setUtbetaling(f.utbetal(200000, Integer.parseInt(tfBeløp.getText())));
                    f.premieTilGodkjenning(f.premieEtterSkade(f.getBonus()));
                    f.nyBonusTilGodkjenning(f.bonusEtterSkade(f.getBonus()));
                    kontroll.addSkade(bil);
                    skriveOmråde.setText(bil.melding());

                } else if (fors instanceof BatForsikring) {

                    BatForsikring f = (BatForsikring) fors;
                    BatSkadeMelding bat = new BatSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bat.setForsikring(f);
                    bat.setUtbetaling(Double.parseDouble(tfBeløp.getText()) - f.getEgenAndel());
                    f.premieEtterSkade(f.getPremie());
                    kontroll.addSkade(bat);
                    skriveOmråde.setText(bat.melding());

                } else if (fors instanceof BoligForsikring) {

                    BoligForsikring f = (BoligForsikring) fors;
                    BoligSkadeMelding bolig = new BoligSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bolig.setForsikring(f);
                    int egenandel = f.egenandel(skade, false);
                    bolig.setUtbetaling(f.utbetaling(Integer.parseInt(tfBeløp.getText()), f.getForsikringsSum(), 2015, egenandel));
                    f.premieTilGodkjenning(f.nyPremie());
                    kontroll.addSkade(bolig);
                    skriveOmråde.setPromptText(bolig.melding());

                } else if (fors instanceof FritidsBolig) {

                    FritidsBolig f = (FritidsBolig) fors;
                    FritidsBoligMelding fri = new FritidsBoligMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    fri.setForsikring(f);
                    int egenandel = f.egenandel(skade, false);
                    fri.setUtbetaling(f.utbetaling(Integer.parseInt(tfBeløp.getText()), f.getForsikringsSum(), 2015, egenandel));
                    f.premieTilGodkjenning(f.nyPremie());
                    kontroll.addSkade(fri);
                    skriveOmråde.setText(fri.melding());

                } else if (fors instanceof ReiseForsikring) {

                    ReiseForsikring f = (ReiseForsikring) fors;
                    ReiseSkadeMelding reise = new ReiseSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    reise.setForsikring(f);
                    reise.setUtbetaling(Integer.parseInt(tfBeløp.getText()));
                    f.premieTilGodkjenning();
                    kontroll.addSkade(reise);
                    skriveOmråde.setText(reise.melding());
                }

            } catch (NumberFormatException nfe) {
                lbInfo.setVisible(true);
                lbInfo.setText("Ugyldig skadebeløp");
                return;
            }
            skriveOmråde.clear();  
            tfBeløp.clear();
        dato.clear();
            lbInfo.setText("Skademelding er sendt inn");
    
    
    }
}
