package GUI;

import Kontroller.Kontroller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Created by Magnus on 27.04.15.
 */
public class KonsulentsideSkade {

    public static Pane skadeFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(50));

        //Elementer

        Label lbAntall = new Label();
        lbAntall.setText("Nummer:");
        lbAntall.setId("antall");

        Label lbForrige = new Label();
        lbForrige.setText("Forrige");
        lbForrige.setId("forrige");

        Label lbNeste = new Label();
        lbNeste.setText("Neste");
        lbNeste.setId("neste");

        Button btnVenstre = new Button("<-----");
        btnVenstre.setId("bntVenstre");
        btnVenstre.setOnAction(e -> {
            System.out.println("Du trykket på forrige!");
        });

        Button btnHøyre = new Button("----->");
        btnHøyre.setId("btnHøyre");
        btnHøyre.setOnAction(e -> {
            System.out.println("Du trykket på Neste!");
            
        });


        TextField tfAntall = new TextField();
        tfAntall.setText("13");
        tfAntall.setAlignment(Pos.CENTER);
        tfAntall.setId("tfantall");
        tfAntall.setMaxWidth(50);
        tfAntall.setEditable(false);

        TextArea taLes = new TextArea();
        taLes.setEditable(true);
        taLes.setPromptText("");
        taLes.setPrefSize(700, 400);

        Label lbPris = new Label();
        lbPris.setText("Pris:");
        lbPris.setId("lbPris");

        TextField tfBeløp = new TextField();
        tfBeløp.setMaxWidth(200);
        tfBeløp.setEditable(false);
        tfBeløp.setAlignment(Pos.CENTER_RIGHT);
        tfBeløp.setText("65 000,-");

        Button btnGodta = new Button("Godta");
        btnGodta.setMinWidth(200);
        btnGodta.setAlignment(Pos.CENTER);

        Button btnAvvis = new Button("Avvis");
        btnAvvis.setMinWidth(200);
        btnAvvis.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.setPadding(new Insets(10));
        vb.setSpacing(10);
        vb.setAlignment(Pos.TOP_CENTER);

        HBox hbControll = new HBox();
        hbControll.setSpacing(10);
        hbControll.setAlignment(Pos.CENTER);
        hbControll.getChildren().addAll(lbForrige, btnVenstre, tfAntall, btnHøyre, lbNeste);

        HBox hbKnapper = new HBox();
        hbKnapper.setSpacing(10);
        hbKnapper.setAlignment(Pos.CENTER);
        hbKnapper.getChildren().addAll(lbPris, tfBeløp, btnGodta, btnAvvis);


        vb.getChildren().addAll(lbAntall,hbControll, taLes, hbKnapper);
        borderPane.setCenter(vb); // CENTER

        return borderPane;
    }

}
