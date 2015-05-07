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
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private HBox vb;
    
    private Label overskrift;
    private GridPane grid;
    
    private ComboBox<String> forsikringComboBox;
    private Label lbInfo;
    
    private HBox hb;
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
        //Group root = new Group();
        tfBeløp = new TextField();
        borderPane = new BorderPane();
        vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        overskrift = new Label();
        overskrift.setText("Her oppretter du en Skademelding");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb); //TOP

        grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);

        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);

        //Skjema
        forsikringComboBox = new ComboBox<String>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll(
                "Alle",
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {SkrivListe();});

        lbInfo = new Label();
        lbInfo.setText("Info om skaden:");
        lbInfo.setId("lbInfo");

        hb = new HBox();
        hb.setSpacing(20);
        hb.setAlignment(Pos.CENTER);

        skriveOmråde = new TextArea();
        skriveOmråde.setEditable(true);
        skriveOmråde.setPromptText("Skriv innformasjon om skaden");
        skriveOmråde.setPrefSize(400, 400);
        skriveOmråde.setOnMouseEntered(e -> { skriveOmråde.setPromptText("Skriv innformasjon om skaden");});
        skriveOmråde.setStyle("-fx-prompt-text-fill: rgba(0, 0, 0)" );
       
        listView.setPrefSize(300, 400);
        listView.setId("listview");
        listView.setEditable(false);

        data.addAll("   ");

        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(data));
        listView.getSelectionModel().selectedItemProperty().addListener((Observable e) -> { settKnapper();});

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


        radioGrid = new GridPane();
        radioGrid.add(rbtBrann, 0, 0);
        radioGrid.add(rbtRør, 0, 1);
        radioGrid.add(rbtVann,0, 2);
        radioGrid.setVgap(30);

        hb.getChildren().addAll(listView, skriveOmråde, radioGrid);


        lbSkadebeløp = new Label();
        lbSkadebeløp.setText("Samlet skadebeløp:");
        lbSkadebeløp.setId("lbSkadebeløp");

        tfBeløp.setMaxWidth(100);
        tfBeløp.setAlignment(Pos.CENTER_LEFT);
        tfBeløp.setPromptText("Beløp:");

        lbDato = new Label();
        lbDato.setText("Velg dato for hendelsen:");
        lbDato.setId("lbDato");

        dpDato = new DatePicker();
        dpDato.setPromptText("Format eks. 12.02.2015");
        dpDato.setOnAction((ActionEvent e) -> {sjekkDate();});

        fileChooser = new FileChooser();

        btnÅpnefil = new Button("Velg fil");
        btnÅpnefil.setMaxWidth(200);
        btnÅpnefil.setOnAction(e -> {
            fileChooser.showOpenMultipleDialog(new Stage());
        });

        lbSkade = new Label();
        lbSkade.setText("");
        lbSkade.setId("lbskade");

        btnRapSkade = new Button();
        btnRapSkade.setText("Raporter skade");
        btnRapSkade.setId("btnRapSkade");
        btnRapSkade.setMinWidth(200);
        btnRapSkade.setOnAction((ActionEvent e) -> {repSkade();});

        lbFeilFormat = new Label();
        lbFeilFormat.setVisible(false);

        grid.add(forsikringComboBox, 0, 0);
        //grid.add(lbInfo, 0, 1);
        grid.add(hb, 0, 2);
        grid.add(lbSkadebeløp, 0, 3);
        grid.add(tfBeløp, 0, 4);

        grid.add(lbFeilFormat, 1, 4);
        grid.add(lbDato, 0, 5);
        grid.add(dpDato, 0, 6);
        grid.add(btnÅpnefil, 0, 7);
        grid.add(btnRapSkade, 0, 8);
        grid.add(lbSkade, 0, 9);

        borderPane.setCenter(grid); // CENTER
        

        // finner ut hvilken forsikring det er og legger skademeldingen i køen,
        // her beregnes også skadesummen samt nye premier, men premien settes endelig,
        // først når konsulenten har godkjent beløpet/ skademeldingen.

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
                lbSkade.setText("Vennligst velg en forsikring");
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
    private void repSkade(){
    
            String polisNr = listView.getSelectionModel().getSelectedItem();
            if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
                polisNr = polisNr.substring(0, 6);
            }else{
                lbSkade.setText("Vennligst velg en forsikring");
                return;
            }
            if(dato == null || dato.after(Calendar.getInstance())){
                lbSkade.setText("Vennligst sett en gyldig dato");
                return;
            }
            if(skriveOmråde.getText() == null || skriveOmråde.getText().isEmpty()){
                lbSkade.setText("Vennligst beskriv skaden");
                return;
            }
            
            Forsikringer fors = kontroll.getForsikring(Integer.parseInt(polisNr));
            try {
                //skriveOmråde.clear();
                if ( fors instanceof BilForsikring ) {

                    BilForsikring f = (BilForsikring) fors;
                    BilSkadeMelding bil = new BilSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bil.setForsikring(f);
                    bil.setUtbetaling(f.utbetal(200000, Integer.parseInt(tfBeløp.getText())));
                    f.premieTilGodkjenning(f.premieEtterSkade(f.getPremie(), f.getBonus()));
                    f.nyBonusTilGodkjenning(f.bonusEtterSkade(f.getBonus()));
                    kontroll.addSkade(bil);
                    skriveOmråde.setPromptText(bil.melding());

                } else if (fors instanceof BatForsikring) {

                    BatForsikring f = (BatForsikring) fors;
                    BatSkadeMelding bat = new BatSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bat.setForsikring(f);
                    bat.setUtbetaling(Integer.parseInt(tfBeløp.getText()));
                    kontroll.addSkade(bat);
                    skriveOmråde.setPromptText(bat.melding());

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
                    skriveOmråde.setPromptText(fri.melding());
                    
                } else if (fors instanceof ReiseForsikring) {
                    
                    ReiseForsikring f = (ReiseForsikring) fors;
                    ReiseSkadeMelding reise = new ReiseSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    reise.setForsikring(f);
                    reise.setUtbetaling(Integer.parseInt(tfBeløp.getText()));
                    f.premieTilGodkjenning();
                    kontroll.addSkade(reise);
                    skriveOmråde.setPromptText(reise.melding());
                    
                }

            } catch (NumberFormatException nfe) {
                lbFeilFormat.setText("Kun hele tall.");
                lbFeilFormat.setVisible(true);
                lbSkade.setText("Ugyldig skadebeløp");
                return;
            }
            skriveOmråde.clear();  
            tfBeløp.clear();
            dato.clear();
            lbSkade.setText("Skademelding er sendt inn");
    
    
    }
}
