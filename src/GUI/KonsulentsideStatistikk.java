package GUI;

import Kontroller.Kakediagram;
import Kontroller.Kontroller;
import Kontroller.Statistikk;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Created by Magnus, Therese, Håkon
 */
public class KonsulentsideStatistikk {

    private Kontroller kontroll;
    private double reiseInn, boligInn, fritidInn, båtInn, bilInn,
            reiseUt, boligUt, fritidUt, båtUt, bilUt, inntekt, utgift;
    private GregorianCalendar gc;
    private int aar = 2015;
    private ComboBox<String> cb;
    private HBox hBox;
    private VBox vbTabell;
    private VBox vbGraf;
    private VBox vbKake;
    private VBox vbMain;
    private VBox btnvBox;
    private BorderPane borderPane;
    private GridPane gridKake;
    private GridPane gridTabell;
    private Button btninnUt;
    private Button btnkake;
    private Button btngraf;
    private Label lbBoligVerdiInn;
    private Label lbFritidsboligInn;
    private Label lbFritidsboligVerdiInn;
    private Label lbBilforsikringInn;
    private Label lbBilforsikringVerdiInn;
    private Label lbReiseforsikringInn;
    private Label lbReiseForsikringVerdiInn;
    private Label lbBåtForsikringInn;
    private Label lbBåtForsikringVerdiInn;
    private Label lbTotalInn;
    private Label lbTotalVerdiInn; 
    private Label lbUtgifter;
    private Label lbBoligUt;
    private Label lbBoligVerdiUt;
    private Label lbFritidsboligUt;
    private Label lbFritidsboligVerdiUt;
    private Label lbBilforsikringUt;
    private Label lbBilforsikringVerdiUt;
    private Label lbReiseforsikringUt;
    private Label lbReiseForsikringVerdiUt;
    private Label lbBåtForsikringUt;
    private Label lbBåtForsikringVerdiUt;
    private Label lbTotalUt;
    private Label lbTotalVerdiUt;
    private Label lbDifferanse;
    private Label lbDifferanseVerdi;
    private Label lbInntekter;
    private Label lbBoligInn;
    private GridPane senen;
    private Kakediagram innkake;
    private Kakediagram utkake;
    private Kakediagram kake;
    private Statistikk graf;
            
    public Pane statFane(Kontroller kontroll) {

        this.kontroll = kontroll;
        //oppdater();
        borderPane = new BorderPane();
        borderPane.setId("borderpane");

        vbMain = new VBox();
        vbMain.setAlignment(Pos.CENTER);
        vbMain.setSpacing(40);
        vbMain.setPadding(new Insets(140, 10, 10, 10));//top/right/bottom/left

        vbKake = new VBox();
        gridKake = new GridPane();
        vbKake.getChildren().addAll(gridKake);

        vbGraf = new VBox();
        graf = new Statistikk(Integer.toString(aar),"Fortjeneste");
        vbGraf.getChildren().add(graf.getGraf());

        vbTabell = new VBox();
        gridTabell = new GridPane();
        vbTabell.getChildren().addAll(gridTabell);

        senen = new GridPane();
        senen.add(vbGraf,0,0);
        senen.add(vbKake,0,0);
        senen.add(vbTabell,0,0);
        senen.setAlignment(Pos.TOP_CENTER);
        tabell();

        btnvBox= new VBox();
        btnvBox.setAlignment(Pos.CENTER);
        btnvBox.setSpacing(30);

        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(40);
        hBox.setPadding(new Insets(0, 20, 10, 20));//top/right/bottom/left

        cb = new ComboBox<>();
        cb.setValue("Velg År:");
        cb.setId("cb");
        cb.setEditable(false);
        cb.setMinWidth(200);
        cb.getItems().addAll(
                "2013",
                "2014",
                "2015"
        );

        btninnUt = new Button();
        btninnUt.setText("Tabell");
        btninnUt.setId("knapp");
        btninnUt.setMinWidth(150);
        btninnUt.setOnAction(e -> {
            if (!vbTabell.isVisible()) {
                tabell();
            }
        });

        btnkake = new Button();
        btnkake.setText("Kakediagram");
        btnkake.setId("knapp");
        btnkake.setMinWidth(150);
        btnkake.setOnAction(e -> {
            if (!vbKake.isVisible() ) {
                kake();
            }
        });

        btngraf = new Button();
        btngraf.setText("Graf");
        btngraf.setId("knapp");
        btngraf.setMinWidth(150);
        btngraf.setOnAction(e -> {
            if (!vbGraf.isVisible()) {
                graf();
            }
        });

        btnvBox.getChildren().addAll(btninnUt, btnkake, btngraf);

        hBox.getChildren().addAll(btnvBox, senen);

        vbMain.getChildren().addAll(cb, hBox);
        oppdaterTabell();

        cb.setOnAction((ActionEvent e) -> {
            velgÅr();
            oppdaterTabell();
            oppdater();
            oppdaterGraf();
            oppdaterKake();
        });

        borderPane.setTop(vbMain);

        borderPane.getStylesheets().add("CSS/konsulentstat.css");
        return borderPane;
    }

    private void kake() {
        //KAKE ------------------------------------------------------------------>
        vbKake.setAlignment(Pos.CENTER);
        vbKake.setSpacing(40);
        //vbKake.setPadding(new Insets(10, 10, 10, 10));//top/right/bottom/left
        vbGraf.setVisible(false);
        vbKake.setVisible(true);
        vbTabell.setVisible(false);

        vbKake.getChildren().clear();
        gridKake = new GridPane();
        vbKake.getChildren().addAll(gridKake);
        oppdater();

        //oppdater();
        oppdaterKake();


    }

    private void oppdaterKake() {
        gridKake.getChildren().clear();
        oppdater();
        innkake = new Kakediagram("Inntekter");
        innkake.setBil(bilInn);
        innkake.setBolig(boligInn);
        innkake.setBåt(båtInn);
        innkake.setFritids(fritidInn);
        innkake.setReise(reiseInn);

        utkake = new Kakediagram("Utgifter");
        utkake.setBil(bilUt);
        utkake.setBolig(boligUt);
        utkake.setBåt(båtUt);
        utkake.setFritids(fritidUt);
        utkake.setReise(reiseUt);


        kake = new Kakediagram("Differanse");
        kake.setBil(bilInn-bilUt);
        kake.setBolig(boligInn - boligUt);
        kake.setBåt(båtInn - båtUt);
        kake.setFritids(fritidInn - fritidUt);
        kake.setReise(reiseInn - reiseUt);

        gridKake.add(innkake.hentKake(), 0, 0);
        gridKake.add(utkake.hentKake(), 1, 0);
    }

    private void graf(){
        //GRAF ------------------------------------------------------------------>
        vbGraf.setAlignment(Pos.CENTER);
        //vbGraf.setSpacing(20);
        //vbGraf.setPadding(new Insets(10, 10, 10, 10));//top/right/bottom/left
        vbGraf.setVisible(true);
        vbKake.setVisible(false);
        vbTabell.setVisible(false);

        oppdaterGraf();

    }

    private void oppdaterGraf() {
        vbGraf.getChildren().clear();
        System.out.println(aar);
        graf = new Statistikk(Integer.toString(aar),"Fortjeneste");
        vbGraf.getChildren().add(graf.getGraf());
        oppdater();
        gc = new GregorianCalendar();
        gc.set(gc.YEAR, aar);
        graf.måndeData(kontroll.gotGodkjentListe(aar));
        graf.måndeData(kontroll.getInntektList(gc));
        graf.opptatterGraf();
    }

    private void tabell() {
        //TABELL ------------------------------------------------------------------>
        vbTabell.setAlignment(Pos.CENTER);
        //vbTabell.setSpacing(40);
        //vbTabell.setPadding(new Insets(10, 10, 10, 10));//top/right/bottom/left
        vbGraf.setVisible(false);
        vbKake.setVisible(false);
        vbTabell.setVisible(true);

        vbTabell.getChildren().clear();
        gridTabell = new GridPane();
        vbTabell.getChildren().addAll(gridTabell);
        oppdater();

        gridTabell.setPadding(new Insets(10));
        gridTabell.setVgap(20);
        gridTabell.setHgap(20);
        gridTabell.setAlignment(Pos.CENTER);
        gridTabell.setId("statgrid");
        gridTabell.setMaxWidth(680);
        gridTabell.setMaxHeight(400);



        //Inntekter ----------------------------------------------->
        lbInntekter = new Label();
        lbInntekter.setText("Inntekter fordelt på forsikringstype");
        lbInntekter.setId("h1");

        lbBoligInn = new Label();
        lbBoligInn.setText("Bolig:");
        lbBoligInn.setId("lbbolig");

        lbBoligVerdiInn = new Label();
        lbBoligVerdiInn.setText("123456" + " Kr");
        lbBoligVerdiInn.setId("lbboligverdi");

        lbFritidsboligInn = new Label();
        lbFritidsboligInn.setText("Fritidsbolig:");
        lbFritidsboligInn.setId("lbFritidsbolig");

        lbFritidsboligVerdiInn = new Label();
        lbFritidsboligVerdiInn.setText("123456" + " Kr");
        lbFritidsboligVerdiInn.setId("lbFritidsboligVerdi");

        lbBilforsikringInn = new Label();
        lbBilforsikringInn.setText("Bilforsikring:");
        lbBilforsikringInn.setId("lbBilforsikring");

        lbBilforsikringVerdiInn = new Label();
        lbBilforsikringVerdiInn.setText("123456" + " Kr");
        lbBoligVerdiInn.setText("123456" + " Kr");
        lbBilforsikringVerdiInn.setId("lbBilforsikringVerdi");

        lbReiseforsikringInn = new Label();
        lbReiseforsikringInn.setText("Reiseforsikring:");
        lbReiseforsikringInn.setId("lbReiseforsikring");

        lbReiseForsikringVerdiInn = new Label();
        lbReiseForsikringVerdiInn.setText("123456" + " Kr");
        lbReiseForsikringVerdiInn.setId("lbReiseForsikringVerdi");

        lbBåtForsikringInn = new Label();
        lbBåtForsikringInn.setText("BåtForsikring:");
        lbBåtForsikringInn.setId("lbBåtForsikring");

        lbBåtForsikringVerdiInn = new Label();
        lbBåtForsikringVerdiInn.setText("123456" + " Kr");
        lbBåtForsikringVerdiInn.setId("lbBåtForsikringVerdi");

        lbTotalInn = new Label();
        lbTotalInn.setText("Totalt:");
        lbTotalInn.setId("lbTotalInn");

        lbTotalVerdiInn = new Label();
        lbTotalVerdiInn.setText("9991919" + " Kr");
        lbTotalVerdiInn.setId("lbTotalVerdiInn");

        //Utgifter------------------------------------------------->
        lbUtgifter = new Label();
        lbUtgifter.setText("Utgifter fordelt på forsikringstype");
        lbUtgifter.setId("h1");

        lbBoligUt = new Label();
        lbBoligUt.setText("Bolig:");
        lbBoligUt.setId("lbbolig");

        lbBoligVerdiUt = new Label();
        lbBoligVerdiUt.setText("123456" + " Kr");
        lbBoligVerdiUt.setId("lbboligverdi");

        lbFritidsboligUt = new Label();
        lbFritidsboligUt.setText("Fritidsbolig:");
        lbFritidsboligUt.setId("lbFritidsbolig");

        lbFritidsboligVerdiUt = new Label();
        lbFritidsboligVerdiUt.setText("123456" + " Kr");
        lbFritidsboligVerdiUt.setId("lbFritidsboligVerdi");

        lbBilforsikringUt = new Label();
        lbBilforsikringUt.setText("Bilforsikring:");
        lbBilforsikringUt.setId("lbBilforsikring");

        lbBilforsikringVerdiUt = new Label();
        lbBilforsikringVerdiUt.setText("123456" + " Kr");
        lbBilforsikringVerdiUt.setId("lbBilforsikringVerdi");

        lbReiseforsikringUt = new Label();
        lbReiseforsikringUt.setText("Reiseforsikring:");
        lbReiseforsikringUt.setId("lbReiseforsikring");

        lbReiseForsikringVerdiUt = new Label();
        lbReiseForsikringVerdiUt.setText("123456" + " Kr");
        lbReiseForsikringVerdiUt.setId("lbReiseForsikringVerdi");

        lbBåtForsikringUt = new Label();
        lbBåtForsikringUt.setText("BåtForsikring:");
        lbBåtForsikringUt.setId("lbBåtForsikring");

        lbBåtForsikringVerdiUt = new Label();
        lbBåtForsikringVerdiUt.setText("123456" + " Kr");
        lbBåtForsikringVerdiUt.setId("lbBåtForsikringVerdi");

        lbTotalUt = new Label();
        lbTotalUt.setText("Totalt:");
        lbTotalUt.setId("lbTotalInn");

        lbTotalVerdiUt = new Label();
        lbTotalVerdiUt.setText("2356543" + "Kr");
        lbBåtForsikringVerdiUt.setText("123456" + " Kr");
        lbTotalVerdiUt.setId("lbTotalVerdiUt");

        //Differanse
        lbDifferanse = new Label();
        lbDifferanse.setText("Differanse:");
        lbDifferanse.setId("h2");

        lbDifferanseVerdi = new Label();
        lbDifferanseVerdi.setText("56565654" + " Kr");
        lbTotalVerdiUt.setText("2356543" + "Kr");
        lbBåtForsikringVerdiUt.setText("123456" + " Kr");
        lbDifferanseVerdi.setId("h2");

        //Rad 0
        //Rad 1
        gridTabell.add(lbInntekter, 0, 1, 2, 1);
        gridTabell.add(lbUtgifter, 2, 1, 2, 1);

        //Rad 2
        gridTabell.add(lbBoligInn, 0, 2);
        gridTabell.add(lbBoligVerdiInn, 1, 2);
        gridTabell.add(lbBoligUt, 2, 2);
        gridTabell.add(lbBoligVerdiUt, 3, 2);

        //Rad 3
        gridTabell.add(lbFritidsboligInn, 0, 3);
        gridTabell.add(lbFritidsboligVerdiInn, 1, 3);
        gridTabell.add(lbFritidsboligUt, 2, 3);
        gridTabell.add(lbFritidsboligVerdiUt, 3, 3);

        //Rad 4
        gridTabell.add(lbBilforsikringInn, 0, 4);
        gridTabell.add(lbBilforsikringVerdiInn, 1, 4);
        gridTabell.add(lbBilforsikringUt, 2, 4);
        gridTabell.add(lbBilforsikringVerdiUt, 3, 4);

        //Rad 5
        gridTabell.add(lbReiseforsikringInn, 0, 5);
        gridTabell.add(lbReiseForsikringVerdiInn, 1, 5);
        gridTabell.add(lbReiseforsikringUt, 2, 5);
        gridTabell.add(lbReiseForsikringVerdiUt, 3, 5);

        //Rad 6
        gridTabell.add(lbBåtForsikringInn, 0, 6);
        gridTabell.add(lbBåtForsikringVerdiInn, 1, 6);
        gridTabell.add(lbBåtForsikringUt, 2, 6);
        gridTabell.add(lbBåtForsikringVerdiUt, 3, 6);

        //Rad 7
        gridTabell.add(lbTotalInn, 0, 7);
        gridTabell.add(lbTotalVerdiInn, 1, 7);
        gridTabell.add(lbTotalUt, 2, 7);
        gridTabell.add(lbTotalVerdiUt, 3, 7);

        //Rad 8
        gridTabell.add(lbDifferanse, 1, 8);
        gridTabell.add(lbDifferanseVerdi, 2, 8);

        gridTabell.setGridLinesVisible(false);


    }
    
    private void velgÅr(){
    String år = cb.getSelectionModel().getSelectedItem();
            switch (år) {
                case "2013":
                    aar = 2013;
                    break;
                case "2014":
                    aar = 2014;
                    break;
                case "2015":
                    aar = 2015;
                    break;
                default:
                    aar = 2015;
                   
            }
        oppdater();
    }
    
    private void oppdaterTabell(){
                String form = "0.00";
            DecimalFormat tall = new DecimalFormat(form);
// Inntekter  ________________________________________________
            lbBåtForsikringVerdiInn.setText(tall.format(båtInn) + " Kr");
            lbReiseForsikringVerdiInn.setText(tall.format(reiseInn) + " Kr");
            lbBilforsikringVerdiInn.setText(tall.format(bilInn) + " Kr");
            lbBoligVerdiInn.setText(tall.format(boligInn) + " Kr");
            lbFritidsboligVerdiInn.setText(tall.format(fritidInn) + " Kr");
            lbTotalVerdiInn.setText(tall.format(inntekt) + "Kr");
// Utgifter ________________________________________________
            lbBåtForsikringVerdiUt.setText(tall.format(båtUt) + " Kr");
            lbReiseForsikringVerdiUt.setText(tall.format(reiseUt) + " Kr");
            lbBilforsikringVerdiUt.setText(tall.format(bilUt) + " Kr");
            lbFritidsboligVerdiUt.setText(tall.format(fritidUt) + " Kr");
            lbBoligVerdiUt.setText(tall.format(boligUt) + " Kr");

            lbTotalVerdiUt.setText(tall.format(utgift) + "Kr");
//differanse____________________________________________________________________

            lbDifferanseVerdi.setText(tall.format(inntekt - utgift) + " Kr");
    
    }
    
    private void oppdater() {
        
            reiseInn = kontroll.finnInntekterReiseFors(aar);
            boligInn = kontroll.finnInntekterBoligForsikring(aar);
            fritidInn = kontroll.finnInntekterFritidsBolig(aar);
            båtInn = kontroll.finnInntekterBåt(aar);
            bilInn = kontroll.finnInntekterBil(aar);
            inntekt = kontroll.finnInntekterAlleForsikringer(aar);

            reiseUt = kontroll.finnUtgiftReise(aar);
            boligUt = kontroll.finnUtgiftBolig(aar);
            fritidUt = kontroll.finnUtgiftFritid(aar);
            båtUt = kontroll.finnUtgiftBåt(aar);
            bilUt = kontroll.finnUtgiftBil(aar);
            utgift = kontroll.finnUtgiftTotal(aar);
    }

}//End of class
