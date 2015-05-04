package GUI;

import Kontroller.Kontroller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;

import java.awt.*;

import static javafx.geometry.Pos.BOTTOM_CENTER;
import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideReise {

    String type;

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
        btnBeregn.setOnAction(e -> {
            lbPrint.setText("Prisen er: getPris()");
        });

        Button btnBestill = new Button();
        btnBestill.setText("Bestill");
        btnBestill.setMinWidth(100);
        btnBestill.setId("bestill");
        btnBestill.setOnAction(e -> {
            lbPrint.setText("Reiseforsikring bestilt!");
        });

        hb.getChildren().addAll(btnBeregn,btnBestill);

        vb.getChildren().addAll(lbInfo, rbtnVerden, rbtnEuropa, rbtnNorden, hb, lbPrint);

        borderPane.setCenter(vb);

        return borderPane;
    }
}