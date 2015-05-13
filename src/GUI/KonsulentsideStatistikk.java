package GUI;

import Kontroller.Kakediagram;
import Kontroller.Kontroller;
import Kontroller.Statistikk;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Magnus, Therese, Håkon
 */
public class KonsulentsideStatistikk {

    private Kontroller kontroll;
    private double reiseInn, boligInn, fritidInn, båtInn, bilInn,
            reiseUt, boligUt, fritidUt, båtUt, bilUt, inntekt, utgift;
    private int aar = 2015;
    private ComboBox<String> cb;
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
            
    public Pane statFane(Kontroller kontroll) {

        this.kontroll = kontroll;
        oppdater();
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");

        TabPane tabPane = new TabPane();

        //Inntekter
        Tab tabInnUt = new Tab();
        tabInnUt.setText("Inntekter & Utgifter");
        tabInnUt.setClosable(false);
        tabInnUt.setOnSelectionChanged(e -> {
            tabInnUt.setContent(innUt()); 
        });
        
        Tab kakeDiagram = new Tab();
        kakeDiagram.setText("Kakediagram");
        kakeDiagram.setClosable(false);
        kakeDiagram.setOnSelectionChanged(e -> {
            kakeDiagram.setContent(kakeDiagram());
        });
        
        Tab graf = new Tab();
        graf.setText("Kakediagram");
        graf.setClosable(false);
        graf.setOnSelectionChanged(e -> {
            graf.setContent(graf());
        });

        tabPane.getTabs().addAll(tabInnUt, kakeDiagram, graf);
        borderPane.setTop(tabPane);

        borderPane.getStylesheets().add("CSS/konsulentstat.css");
        return borderPane;
    }
    private Pane graf(){
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        vb.setPadding(new Insets(100));
        
        oppdater();
        
        Statistikk graf = new Statistikk();
        graf.måndeData(kontroll.gotGodkjentListe(aar));
        
         vb.getChildren().add(graf.getGraf());
         return vb;
    
    }

    private Pane kakeDiagram() {
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        vb.setPadding(new Insets(100));
        
        oppdater();
        Kakediagram innkake = new Kakediagram("Inntekter");
        innkake.setBil(bilInn);
        innkake.setBolig(boligInn);
        innkake.setBåt(båtInn);
        innkake.setFritids(fritidInn);
        innkake.setReise(reiseInn);
        
        Kakediagram utkake = new Kakediagram("Utgifter");
        utkake.setBil(bilUt);
        utkake.setBolig(boligUt);
        utkake.setBåt(båtUt);
        utkake.setFritids(fritidUt);
        utkake.setReise(reiseUt);
        
        
        Kakediagram kake = new Kakediagram("Differanse");
        kake.setBil(bilInn-bilUt);
        kake.setBolig(boligInn-boligUt);
        kake.setBåt(båtInn-båtUt);
        kake.setFritids(fritidInn-fritidUt);
        kake.setReise(reiseInn-reiseUt);
        
        GridPane grid = new GridPane();
        grid.add(innkake.hentKake(), 0, 0);
        grid.add(utkake.hentKake(), 1, 0);
        
        vb.getChildren().addAll(grid);
        
        
        
        
        
        
        
        
        
        return vb;
    }

    private Pane innUt() {
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        vb.setPadding(new Insets(100));

        cb = new ComboBox<>();
        cb.setValue("Velg År:");
        cb.setEditable(false);
        cb.setMinWidth(200);
        cb.getItems().addAll(
                "2013",
                "2014",
                "2015"
        );

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);
        grid.setId("statgrid");
        grid.setMaxWidth(680);
        grid.setMaxHeight(400);

        //Inntekter ----------------------------------------------->
        Label lbInntekter = new Label();
        lbInntekter.setText("Inntekter fordelt på forsikringstype");
        lbInntekter.setId("h1");

        Label lbBoligInn = new Label();
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
        grid.add(lbInntekter, 0, 1, 2, 1);
        grid.add(lbUtgifter, 2, 1, 2, 1);

        //Rad 2
        grid.add(lbBoligInn, 0, 2);
        grid.add(lbBoligVerdiInn, 1, 2);
        grid.add(lbBoligUt, 2, 2);
        grid.add(lbBoligVerdiUt, 3, 2);

        //Rad 3
        grid.add(lbFritidsboligInn, 0, 3);
        grid.add(lbFritidsboligVerdiInn, 1, 3);
        grid.add(lbFritidsboligUt, 2, 3);
        grid.add(lbFritidsboligVerdiUt, 3, 3);

        //Rad 4
        grid.add(lbBilforsikringInn, 0, 4);
        grid.add(lbBilforsikringVerdiInn, 1, 4);
        grid.add(lbBilforsikringUt, 2, 4);
        grid.add(lbBilforsikringVerdiUt, 3, 4);

        //Rad 5
        grid.add(lbReiseforsikringInn, 0, 5);
        grid.add(lbReiseForsikringVerdiInn, 1, 5);
        grid.add(lbReiseforsikringUt, 2, 5);
        grid.add(lbReiseForsikringVerdiUt, 3, 5);

        //Rad 6
        grid.add(lbBåtForsikringInn, 0, 6);
        grid.add(lbBåtForsikringVerdiInn, 1, 6);
        grid.add(lbBåtForsikringUt, 2, 6);
        grid.add(lbBåtForsikringVerdiUt, 3, 6);

        //Rad 7
        grid.add(lbTotalInn, 0, 7);
        grid.add(lbTotalVerdiInn, 1, 7);
        grid.add(lbTotalUt, 2, 7);
        grid.add(lbTotalVerdiUt, 3, 7);

        //Rad 8
        grid.add(lbDifferanse, 1, 8);
        grid.add(lbDifferanseVerdi, 2, 8);

        grid.setGridLinesVisible(false);

        vb.getChildren().addAll(cb, grid);
        oppdaterTabell();

        cb.setOnAction((ActionEvent e) -> {
            velgÅr();
            oppdaterTabell();
        });

        return vb;
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
