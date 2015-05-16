package GUI;

import Forsikring.ReiseForsikring;
import Kontroller.Kontroller;
import java.text.DecimalFormat;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideReise {

    String type = "Verden";

    public Pane reiseFane(Kontroller kontroller) {

        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(30);
        vb.setPadding(new Insets(120, 10, 10, 160));//top/right/bottom/left
        vb.setStyle("-fx-border-color: red;");
        //vb.setMaxWidth(400);
        //vb.setMaxHeight(300);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setPadding(new Insets(210, 10, 10, 160));//top/right/bottom/left

        Label lbInfo = new Label();
        lbInfo.setText("Velg reiseforsikringstype:");
        lbInfo.setId("lbInfo");
        lbInfo.setAlignment(Pos.CENTER);

        FadeTransition ftInfo = new FadeTransition(Duration.millis(100), lbInfo);
        ftInfo.setFromValue(0.0F);
        ftInfo.setToValue(1.0F);
        ftInfo.setCycleCount(1);

        Label lbPrint = new Label();
        lbPrint.setId("print");
        lbPrint.setText("");
        lbPrint.setAlignment(Pos.CENTER_LEFT);

        ToggleGroup reise = new ToggleGroup();

        RadioButton rbtnVerden = new RadioButton("Verden");
        rbtnVerden.setId("verden");
        rbtnVerden.setToggleGroup(reise);
        rbtnVerden.setSelected(false);
        rbtnVerden.setAlignment(Pos.CENTER);
        rbtnVerden.setOnAction(e -> {
            type = "Verden";
        });

        FadeTransition ftVerden = new FadeTransition(Duration.millis(100), rbtnVerden);
        ftVerden.setFromValue(0.0F);
        ftVerden.setToValue(1.0F);
        ftVerden.setCycleCount(1);

        RadioButton rbtnEuropa = new RadioButton("Europa");
        rbtnEuropa.setId("europa");
        rbtnEuropa.setToggleGroup(reise);
        rbtnEuropa.setSelected(false);
        rbtnEuropa.setOnAction(e -> {
            type = "Europa";
        });

        FadeTransition ftEuropa = new FadeTransition(Duration.millis(100), rbtnEuropa);
        ftEuropa.setFromValue(0.0F);
        ftEuropa.setToValue(1.0F);
        ftEuropa.setCycleCount(1);

        RadioButton rbtnNorden = new RadioButton("Norden");
        rbtnNorden.setId("norden");
        rbtnNorden.setToggleGroup(reise);
        rbtnNorden.setSelected(false);
        rbtnNorden.setOnAction(e -> {
            type = "Norden";
        });

        FadeTransition ftNorden = new FadeTransition(Duration.millis(100), rbtnNorden);
        ftNorden.setFromValue(0.0F);
        ftNorden.setToValue(1.0F);
        ftNorden.setCycleCount(1);

        Button btnBeregn = new Button();
        btnBeregn.setText("Beregn pris");
        btnBeregn.setMinWidth(200);
        btnBeregn.setId("beregn");

        FadeTransition ftBeregn = new FadeTransition(Duration.millis(100), btnBeregn);
        ftBeregn.setFromValue(0.0F);
        ftBeregn.setToValue(1.0F);
        ftBeregn.setCycleCount(1);

        Button btnBestill = new Button();
        btnBestill.setText("Bestill");
        btnBestill.setMinWidth(200);
        btnBestill.setId("bestill");

        FadeTransition ftBestill = new FadeTransition(Duration.millis(100), btnBestill);
        ftBestill.setFromValue(0.0F);
        ftBestill.setToValue(1.0F);
        ftBestill.setCycleCount(1);

        SequentialTransition st = new SequentialTransition(ftInfo, ftVerden, ftEuropa, ftNorden, ftBeregn, ftBestill);
        st.play();


// lyttere_________________________________________________________________________--
       
        // oppretter objekt og henter ut prisen, objektet blir ikke lagret.
        btnBeregn.setOnAction(e -> {
           if (reise.getSelectedToggle() != null) {
               String form = "0.00";
               DecimalFormat tall = new DecimalFormat(form);
               ReiseForsikring f = new ReiseForsikring();
               f.setType(type);
               f.setPremieOgForsSum(type);

               lbPrint.setText("Prisen er: " + tall.format(f.getPremie()) + " kr");
           }
            else {
               lbPrint.setText("Du må velge en forsikringstype");
           }
        });

        btnBestill.setOnAction(e -> {
            if (reise.getSelectedToggle() != null) {
                ReiseForsikring f = new ReiseForsikring();
                f.setType(type);
                f.setPremieOgForsSum(type);
                kontroller.setReiseForsikring(f);

                rbtnEuropa.setSelected(false); rbtnNorden.setSelected(false); rbtnVerden.setSelected(false);
                lbPrint.setText("Reiseforsikring "+ type + " bestilt!");
            }
            else {
                lbPrint.setText("Du må velge en forsikringstype");
            }
        });

        grid.add(lbInfo, 0, 0);
        grid.add(rbtnVerden, 0, 1);
        grid.add(rbtnEuropa, 0, 2);
        grid.add(rbtnNorden, 0, 3);
        grid.add(btnBeregn, 0, 4);
        grid.add(btnBestill, 0, 5);
        grid.add(lbPrint, 0, 6);
        grid.setGridLinesVisible(false);

        borderPane.getStylesheets().add("CSS/kundereise.css");
        borderPane.setLeft(grid);

        return borderPane;
    }
}
