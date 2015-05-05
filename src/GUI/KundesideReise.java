package GUI;

import Forsikring.ReiseForsikring;
import Kontroller.Kontroller;
import java.text.DecimalFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideReise {

    String type = "Verden";

    public Pane reiseFane(Kontroller kontroller) {

        BorderPane borderPane = new BorderPane();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(40);
        vb.setPadding(new Insets(40));
        vb.setStyle("-fx-border-color: red;");
        vb.setMaxWidth(400);
        vb.setMaxHeight(300);

        Label lbInfo = new Label();
        lbInfo.setText("Velg reiseforsikringstype:");
        lbInfo.setId("lbInfo");
        lbInfo.setAlignment(Pos.CENTER_LEFT);

        Label lbPrint = new Label();
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

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        Button btnBeregn = new Button();
        btnBeregn.setText("Beregn pris");
        btnBeregn.setMinWidth(100);
        btnBeregn.setId("beregn");
        

        Button btnBestill = new Button();
        btnBestill.setText("Bestill");
        btnBestill.setMinWidth(100);
        btnBestill.setId("bestill");


// lyttere_________________________________________________________________________--
       
        // oppretter objekt og henter ut prisen, objektet blir ikke lagret.
        btnBeregn.setOnAction(e -> {
            String form = "0.00";
            DecimalFormat tall = new DecimalFormat(form);
            ReiseForsikring f = new ReiseForsikring();
            f.setType(type);
            f.setPremieOgForsSum(type);
            
            lbPrint.setText("Prisen er: " + tall.format(f.getPremie()) + " kr");
        });
        btnBestill.setOnAction(e -> {
            ReiseForsikring f = new ReiseForsikring();
            f.setType(type);
            f.setPremieOgForsSum(type);
            kontroller.setReiseForsikring(f);

            lbPrint.setText("Reiseforsikring bestilt!");
        });

        hb.getChildren().addAll(btnBeregn, btnBestill);

        vb.getChildren().addAll(lbInfo, rbtnVerden, rbtnEuropa, rbtnNorden, hb, lbPrint);

        borderPane.setCenter(vb);

        return borderPane;
    }
}
