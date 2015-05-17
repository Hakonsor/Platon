package GUI;

import Forsikring.BatForsikring;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import java.text.DecimalFormat;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBåt implements ComboBoxConverter {
    private Kontroller kontroll;
    private String båtType;
    private BorderPane borderPane;
    private HBox vb;
    private GridPane grid;
    private GridPane gridleft;
    private GridPane gridright;
    private GridPane gridcenter;
    private Label lbBåt;
    private TextField tfRegnr;
    private TranslateTransition ttRegnr;
    private TextField tfÅrsmodell;
    private TranslateTransition ttÅrsmodell;
    private TextField tfBåtmodell;
    private TranslateTransition ttBåtmodell;
    private TranslateTransition ttAntfot;
    private TranslateTransition ttYtelse;
    private TranslateTransition ttVerdi;
    private ToggleGroup batType;
    private TranslateTransition ttSeilbåt;
    private RadioButton rbtMotorbåt;
    private TranslateTransition ttMotor;
    private Label regLabel;
    private Button btnSjekkpris;
    private FadeTransition ftPris;
    private Button btnRegBåtforsikring;
    private FadeTransition ftBestill;
    private SequentialTransition st;
    private TextField tfAntfot;
    private TextField tfMotormerke;
    private TextField tfVerdi;
    private TranslateTransition ttMotormerke;
    private TextField tfYtelse;
    private RadioButton rbtSeilbåt;
   

    public Pane båtFane(Kontroller kontroll) {
        this.kontroll = kontroll;
        //Group root = new Group();
        borderPane = new BorderPane();
        borderPane.setId("borderpane");
        vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(200, 260, 10, 10));//top/right/bottom/left

        gridleft = new GridPane();
        gridleft.setAlignment(Pos.TOP_CENTER);
        gridleft.setHgap(10);
        gridleft.setVgap(10);
        gridleft.setPadding(new Insets(10));
        gridleft.setPrefHeight(50);
        gridleft.setPrefWidth(400);

        gridright = new GridPane();
        gridright.setAlignment(Pos.TOP_CENTER);
        gridright.setHgap(10);
        gridright.setVgap(10);
        gridright.setPadding(new Insets(10));
        gridright.setPrefHeight(50);
        gridright.setPrefWidth(400);

        gridcenter = new GridPane();
        gridcenter.setAlignment(Pos.CENTER);
        gridcenter.setHgap(10);
        gridcenter.setVgap(10);
        gridcenter.setPadding(new Insets(10));
        gridcenter.setPrefHeight(50);
        gridcenter.setPrefWidth(200);

        //Båt
        lbBåt = new Label();
        lbBåt.setText("Båt innformasjon");
        lbBåt.setAlignment(Pos.CENTER);
        lbBåt.setId("promtfix");

        tfRegnr = new TextField();
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

        ttRegnr = new TranslateTransition(Duration.millis(100), tfRegnr);
        ttRegnr.setFromX(500);
        ttRegnr.setToX(0);
        ttRegnr.setCycleCount(1);

        tfÅrsmodell = new TextField();
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

        ttÅrsmodell = new TranslateTransition(Duration.millis(100), tfÅrsmodell);
        ttÅrsmodell.setFromX(500);
        ttÅrsmodell.setToX(0);
        ttÅrsmodell.setCycleCount(1);

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

        ttBåtmodell = new TranslateTransition(Duration.millis(100), tfBåtmodell);
        ttBåtmodell.setFromX(500);
        ttBåtmodell.setToX(0);
        ttBåtmodell.setCycleCount(1);

        tfAntfot = new TextField();
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

        ttAntfot = new TranslateTransition(Duration.millis(100), tfAntfot);
        ttAntfot.setFromX(500);
        ttAntfot.setToX(0);
        ttAntfot.setCycleCount(1);

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

        ttMotormerke = new TranslateTransition(Duration.millis(100), tfMotormerke);
        ttMotormerke.setFromX(500);
        ttMotormerke.setToX(0);
        ttMotormerke.setCycleCount(1);

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

        ttYtelse = new TranslateTransition(Duration.millis(100), tfYtelse);
        ttYtelse.setFromX(500);
        ttYtelse.setToX(0);
        ttYtelse.setCycleCount(1);

        tfVerdi = new TextField();
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

        ttVerdi = new TranslateTransition(Duration.millis(100), tfVerdi);
        ttVerdi.setFromX(500);
        ttVerdi.setToX(0);
        ttVerdi.setCycleCount(1);

        batType = new ToggleGroup();
        rbtSeilbåt = new RadioButton("Seilbåt");
        rbtSeilbåt.setToggleGroup(batType);
        rbtSeilbåt.setSelected(false);
        rbtSeilbåt.setOnAction(e -> {
            båtType = "Seilbåt";
        });

        ttSeilbåt = new TranslateTransition(Duration.millis(100), rbtSeilbåt);
        ttSeilbåt.setFromX(500);
        ttSeilbåt.setToX(0);
        ttSeilbåt.setCycleCount(1);

        rbtMotorbåt = new RadioButton("Motorbåt");
        rbtMotorbåt.setToggleGroup(batType);
        rbtMotorbåt.setSelected(false);
        rbtMotorbåt.setOnAction(e -> {
            båtType = "Motorbåt";
        });

        ttMotor = new TranslateTransition(Duration.millis(100), rbtMotorbåt);
        ttMotor.setFromX(500);
        ttMotor.setToX(0);
        ttMotor.setCycleCount(1);

        //Registrer knapp & Label
        regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> { sjekkPris();
        });

        ftPris = new FadeTransition(Duration.millis(100), btnSjekkpris);
        ftPris.setFromValue(0.0F);
        ftPris.setToValue(1.0F);
        ftPris.setCycleCount(1);

        btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Bestill");
        btnRegBåtforsikring.setId("btnRegBatforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        btnRegBåtforsikring.setOnAction(e -> { regBåy();
        });

        ftBestill = new FadeTransition(Duration.millis(100), btnRegBåtforsikring);
        ftBestill.setFromValue(0.0F);
        ftBestill.setToValue(1.0F);
        ftBestill.setCycleCount(1);

        st = new SequentialTransition(ttRegnr, ttÅrsmodell, ttBåtmodell, ttAntfot, ttMotormerke, ttYtelse, ttVerdi, ttSeilbåt, ttMotor, ftPris, ftBestill);
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
        grid.add(btnSjekkpris, 0, 10);
        grid.add(btnRegBåtforsikring, 0, 11);
        grid.add(regLabel, 0, 12);

        borderPane.setRight(grid); // CENTER
        borderPane.getStylesheets().add("CSS/kundebat.css");
        return borderPane;
    }
    private void sjekkPris(){
    
            if (tfRegnr.getId().equals("valid")
                    && tfÅrsmodell.getId().equals("valid")
                    && tfBåtmodell.getId().equals("valid")
                    && tfAntfot.getId().equals("valid")
                    && tfMotormerke.getId().equals("valid")
                    && tfYtelse.getId().equals("valid")
                    && tfVerdi.getId().equals("valid")
                    && batType.getSelectedToggle() != null) {
                double verdi;
                int lengdeFot;
                String regNo = tfRegnr.getText();
                try {
                    verdi = Double.parseDouble(tfVerdi.getText());
                    lengdeFot = Integer.parseInt(tfYtelse.getText());
                    BatForsikring båt = new BatForsikring(verdi, lengdeFot, regNo, båtType, "modell", "årsModell", 10, "motormerke");
                    båt.beregnOgSetEgenAndel();
                    båt.beregnOgSetPremie();
                    String form = "0.00";
                    DecimalFormat tall = new DecimalFormat(form);
                    regLabel.setText("Årlig premie: " + tall.format(båt.getPremie()) + " kr");
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat");
                }

            } else {
                regLabel.setText("Feil i feltene ovenfor");
            }
    
    
    }
    private void regBåy() {
        
            regLabel.setText("Båtforsikring Registrert!");

            if (tfRegnr.getId().equals("valid")
                    && tfÅrsmodell.getId().equals("valid")
                    && tfBåtmodell.getId().equals("valid")
                    && tfAntfot.getId().equals("valid")
                    && tfMotormerke.getId().equals("valid")
                    && tfYtelse.getId().equals("valid")
                    && tfVerdi.getId().equals("valid")
                    && batType.getSelectedToggle() != null) {
                double verdi;
                int lengdeFot;
                String regNo = tfRegnr.getText();
                try {
                    verdi = Double.parseDouble(tfVerdi.getText());
                    lengdeFot = Integer.parseInt(tfYtelse.getText());
                    BatForsikring båt = new BatForsikring(verdi, lengdeFot, regNo, båtType, "modell", "årsModell", 10, "motormerke");
                    båt.beregnOgSetEgenAndel();
                    båt.beregnOgSetPremie();
                    kontroll.setBåtForsikring(båt);
                } catch (NumberFormatException nfe) {
                    System.out.println("Feil tallformat");
                }

                tfRegnr.clear();
                tfÅrsmodell.clear();
                tfBåtmodell.clear();
                tfAntfot.clear();
                tfMotormerke.clear();
                tfYtelse.clear();
                tfVerdi.clear();
                rbtMotorbåt.setSelected(false);
                rbtSeilbåt.setSelected(false);
                regLabel.setText("Bilforsikring Registrert!");

            } else {
                regLabel.setText("Feil i feltene ovenfor");
            }
    }
}
