package GUI;

import Forsikring.BatForsikring;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import Person.Person;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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
import javafx.util.Duration;

import java.io.SequenceInputStream;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBåt implements ComboBoxConverter {

    private String type;

    public Pane båtFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(200, 260, 10, 10));//top/right/bottom/left

        GridPane gridleft = new GridPane();
        gridleft.setAlignment(Pos.TOP_CENTER);
        gridleft.setHgap(10);
        gridleft.setVgap(10);
        gridleft.setPadding(new Insets(10));
        gridleft.setPrefHeight(50);
        gridleft.setPrefWidth(400);

        GridPane gridright = new GridPane();
        gridright.setAlignment(Pos.TOP_CENTER);
        gridright.setHgap(10);
        gridright.setVgap(10);
        gridright.setPadding(new Insets(10));
        gridright.setPrefHeight(50);
        gridright.setPrefWidth(400);

        GridPane gridcenter = new GridPane();
        gridcenter.setAlignment(Pos.CENTER);
        gridcenter.setHgap(10);
        gridcenter.setVgap(10);
        gridcenter.setPadding(new Insets(10));
        gridcenter.setPrefHeight(50);
        gridcenter.setPrefWidth(200);

        //Båt
        Label lbBåt = new Label();
        lbBåt.setText("Båt innformasjon");
        lbBåt.setAlignment(Pos.CENTER);
        lbBåt.setId("promtfix");

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr eks (ABC123)");
        tfRegnr.setMinWidth(200);
        tfRegnr.setId("promtfix");
        tfRegnr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "^[a-zA-Z]{3}\\d{3}$";
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
        ttRegnr.setFromX(500);
        ttRegnr.setToX(0);
        ttRegnr.setCycleCount(1);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell 4-tall");
        tfÅrsmodell.setMinWidth(200);
        tfÅrsmodell.setId("promtfix");
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
        ttÅrsmodell.setFromX(500);
        ttÅrsmodell.setToX(0);
        ttÅrsmodell.setCycleCount(1);

        TextField tfBåtmodell = new TextField();
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

        TranslateTransition ttBåtmodell = new TranslateTransition(Duration.millis(100), tfBåtmodell);
        ttBåtmodell.setFromX(500);
        ttBåtmodell.setToX(0);
        ttBåtmodell.setCycleCount(1);

        TextField tfAntfot= new TextField();
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

        TranslateTransition ttAntfot = new TranslateTransition(Duration.millis(100), tfAntfot);
        ttAntfot.setFromX(500);
        ttAntfot.setToX(0);
        ttAntfot.setCycleCount(1);

        TextField tfMotormerke = new TextField();
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

        TranslateTransition ttMotormerke = new TranslateTransition(Duration.millis(100), tfMotormerke);
        ttMotormerke.setFromX(500);
        ttMotormerke.setToX(0);
        ttMotormerke.setCycleCount(1);

        TextField tfYtelse = new TextField();
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

        TranslateTransition ttYtelse = new TranslateTransition(Duration.millis(100), tfYtelse);
        ttYtelse.setFromX(500);
        ttYtelse.setToX(0);
        ttYtelse.setCycleCount(1);

        TextField tfVerdi = new TextField();
        tfVerdi.setPromptText("Verdi på båten");
        tfVerdi.setMinWidth(200);
        tfVerdi.setId("promtfix");
        tfVerdi.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[0-9]+";
                String verdi = tfVerdi.getText();

                if (!verdi.matches(regex) || verdi.length() > 13) {
                    tfVerdi.setId("error");
                } else {
                    tfVerdi.setId("valid");
                }
                if (verdi.length() == 0) {
                    tfVerdi.setId("promtfix");
                }
            }
        });

        TranslateTransition ttVerdi = new TranslateTransition(Duration.millis(100), tfVerdi);
        ttVerdi.setFromX(500);
        ttVerdi.setToX(0);
        ttVerdi.setCycleCount(1);

        ToggleGroup båtType = new ToggleGroup();
        RadioButton rbtSeilbåt = new RadioButton("Seilbåt");
        rbtSeilbåt.setToggleGroup(båtType);
        rbtSeilbåt.setSelected(true);
        rbtSeilbåt.setOnAction(e -> {
            type = "Seilbåt";
        });

        TranslateTransition ttSeilbåt = new TranslateTransition(Duration.millis(100), rbtSeilbåt);
        ttSeilbåt.setFromX(500);
        ttSeilbåt.setToX(0);
        ttSeilbåt.setCycleCount(1);

        RadioButton rbtMotorbåt = new RadioButton("Motorbåt");
        rbtMotorbåt.setToggleGroup(båtType);
        rbtMotorbåt.setSelected(true);
        rbtMotorbåt.setOnAction(e -> {
            type = "Motorbåt";
        });

        TranslateTransition ttMotor = new TranslateTransition(Duration.millis(100), rbtMotorbåt);
        ttMotor.setFromX(500);
        ttMotor.setToX(0);
        ttMotor.setCycleCount(1);


        //Registrer knapp & Label
        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> {
            regLabel.setText("Premien er: " + "getPris()");
        });

        FadeTransition ftPris = new FadeTransition(Duration.millis(100), btnSjekkpris);
        ftPris.setFromValue(0.0F);
        ftPris.setToValue(1.0F);
        ftPris.setCycleCount(1);

        Button btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Bestill");
        btnRegBåtforsikring.setId("btnRegBatforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        btnRegBåtforsikring.setOnAction(e -> {
            regLabel.setText("Båtforsikring Registrert!");

            if (tfRegnr.getId().equals("valid")
                    && tfÅrsmodell.getId().equals("valid")
                    && tfBåtmodell.getId().equals("valid")
                    && tfAntfot.getId().equals("valid")
                    && tfMotormerke.getId().equals("valid")
                    && tfYtelse.getId().equals("valid")
                    && tfVerdi.getId().equals("valid")) {
                double verdi = 0;
                int lengdeFot = 0;
                String regNo = tfRegNr;
                try {
                    verdi = Double.parseDouble(tfVerdi.getText());
                    lengdeFot = Integer.parseInt(tfYtelse.getText());
                    BatForsikring båt = new BatForsikring(verdi,lengdeFot,regNo , type,"modell","årsModell",10 , "motormerke");
                    kontroll.setBåtForsikring(båt);
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat");
                }

                
                regLabel.setText("Bilforsikring Registrert!");

            } else {
                regLabel.setText("Fargeblind bro?!");
            }
        });

        FadeTransition ftBestill = new FadeTransition(Duration.millis(100), btnRegBåtforsikring);
        ftBestill.setFromValue(0.0F);
        ftBestill.setToValue(1.0F);
        ftBestill.setCycleCount(1);
SequentialTransition st = new SequentialTransition(ttRegnr, ttÅrsmodell, ttBåtmodell, ttAntfot, ttMotormerke, ttYtelse, ttVerdi, ttSeilbåt, ttMotor, ftPris, ftBestill);
        st.play();
        

       
        grid.add(tfRegnr, 0, 1);
        grid.add(tfÅrsmodell, 0, 2);
        grid.add(tfBåtmodell, 0, 3);
        grid.add(tfAntfot, 0, 4);
        grid.add(tfMotormerke, 0, 5);
        grid.add(tfYtelse, 0, 6);
        grid.add(tfVerdi, 0, 7);
        grid.add(rbtSeilbåt, 0, 8);
        grid.add(rbtMotorbåt, 0, 9);
        grid.add(btnSjekkpris, 0,10 );
        grid.add(btnRegBåtforsikring, 0, 11);
        grid.add(regLabel, 0, 12);

        borderPane.setRight(grid); // CENTER
        borderPane.getStylesheets().add("CSS/kundebat.css");
        return borderPane;
    }
}
