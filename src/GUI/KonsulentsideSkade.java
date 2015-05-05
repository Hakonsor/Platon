package GUI;

import Forsikring.BilForsikring;
import Forsikring.BoligForsikring;
import Kontroller.Kontroller;
import SkadeMeldinger.BatSkadeMelding;
import SkadeMeldinger.BilSkadeMelding;
import SkadeMeldinger.BoligSkadeMelding;
import SkadeMeldinger.FritidsBoligMelding;
import SkadeMeldinger.ReiseSkadeMelding;
import SkadeMeldinger.SkadeMelding;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Magnus on 27.04.15. author@ Therese
 */
public class KonsulentsideSkade {

    private final String left = "Bilder/left.png";
    private final String right = "Bilder/right.png";

    private SkadeMelding skade;

    public Pane skadeFane(Kontroller kontroll) {

        skade = kontroll.getFørste();
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

        ImageView btnVenstre = new ImageView(new Image(left));
        btnVenstre.setId("btnVenstre");
        btnVenstre.setPreserveRatio(true);
        btnVenstre.setFitWidth(32);

        ImageView btnHøyre = new ImageView(new Image(right));
        btnHøyre.setId("btnHoyre");
        btnHøyre.setPreserveRatio(true);
        btnHøyre.setFitWidth(32);

        TextField tfAntall = new TextField();
        tfAntall.setText(Integer.toString(kontroll.visSkadeIndex()));
        tfAntall.setAlignment(Pos.CENTER);
        tfAntall.setId("tfantall");
        tfAntall.setMaxWidth(50);
        tfAntall.setEditable(false);

        TextArea taLes = new TextArea();
        taLes.setEditable(true);
        taLes.setPromptText("");
        taLes.setPrefSize(700, 400);
        if (skade != null) {
            taLes.setText(skade.toString());
        }
        Label lbPris = new Label();
        lbPris.setText("Skadebeløp:");
        lbPris.setId("lbPris");

        TextField tfBeløp = new TextField();
        tfBeløp.setMaxWidth(100);
        tfBeløp.setEditable(false);
        tfBeløp.setAlignment(Pos.CENTER_RIGHT);

        String beløp = "";

        if (skade != null) {
            beløp = String.valueOf(skade.getUtbetaling());
        }
        tfBeløp.setText(beløp);

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

        vb.getChildren().addAll(lbAntall, hbControll, taLes, hbKnapper);
        borderPane.setCenter(vb); // CENTER

        // går tilbake i køen over skademeldinger.
        btnVenstre.setOnMouseClicked((MouseEvent event) -> {
            if (skade != null) {
                
                skade = kontroll.visForrigeIKø();
                if(skade instanceof BilSkadeMelding){
                   BilSkadeMelding s = (BilSkadeMelding) skade;
                   taLes.setText(s.melding());
                }
                else if(skade instanceof BatSkadeMelding){
                    BatSkadeMelding s = (BatSkadeMelding)skade;
                    taLes.setText(s.melding());
                }
                else if(skade instanceof BoligSkadeMelding){
                    BoligSkadeMelding s = (BoligSkadeMelding)skade;
                    taLes.setText(s.melding());
                }
                else if(skade instanceof FritidsBoligMelding){
                    FritidsBoligMelding s = (FritidsBoligMelding)skade;
                    taLes.setText(s.melding());
                }
                else if(skade instanceof ReiseSkadeMelding){
                    ReiseSkadeMelding s = (ReiseSkadeMelding)skade;
                    taLes.setText(s.melding());
                }
                tfAntall.setText(Integer.toString(kontroll.visSkadeIndex()));
                
            } else {
                taLes.setText("Det er ikke registrert noen flere skademeldinger.");
            }
        });

        btnHøyre.setOnMouseClicked((MouseEvent event) -> {
            if (skade != null) {

                skade = kontroll.visNesteIKø();
                if(skade instanceof BilSkadeMelding){
                   BilSkadeMelding s = (BilSkadeMelding) skade;
                   taLes.setText(s.melding());
                }
                else if(skade instanceof BatSkadeMelding){
                    BatSkadeMelding s = (BatSkadeMelding)skade;
                    taLes.setText(s.melding());
                }
                else if(skade instanceof BoligSkadeMelding){
                    BoligSkadeMelding s = (BoligSkadeMelding)skade;
                    taLes.setText(s.melding());
                }
                else if(skade instanceof FritidsBoligMelding){
                    FritidsBoligMelding s = (FritidsBoligMelding)skade;
                    taLes.setText(s.melding());
                }
                else if(skade instanceof ReiseSkadeMelding){
                    ReiseSkadeMelding s = (ReiseSkadeMelding)skade;
                    taLes.setText(s.melding());
                }
                tfAntall.setText(Integer.toString(kontroll.visSkadeIndex()));
                taLes.setText(skade.toString());
            } else {
                taLes.setText("Det er ikke registrert noen nye skademeldinger.");
            }
        });
        
        // godkjenner beløpet og setter skademeldingen i registeret, samt oppdaterer premien.


        // godkjenner beløpet og setter skademeldingen i registeret
        btnGodta.setOnAction((ActionEvent e) -> {

            if (skade != null) {
                kontroll.ferdigBehandlet(skade);
                skade.okUtbetal();
                skade.getForsikring().nyPremieOk();
                if(skade instanceof BilSkadeMelding){
                    BilForsikring bil = (BilForsikring)skade.getForsikring();
                       System.out.println("Gammel bonus: " + bil.getBonus());
                    bil.bonusGodkjent();
                        System.out.println("Ny bonus: " + bil.getBonus());
                }
            } else {
                taLes.setText("Det er ingen skademeldinger registert.");
            }

        });
        //legger skademeldingen i registeret, og sletter beløpet som er lagt tli betaling.
        btnAvvis.setOnAction((ActionEvent e) -> {
            if (skade != null) {
                kontroll.ferdigBehandlet(skade);
                skade.avvis();
                taLes.setText("Skaden er avvist.");
            } else {
                taLes.setText("Det er ingen skademeldinger registert.");
            }

        });
        borderPane.getStylesheets().add("CSS/konsulentskade.css");
        return borderPane;
    }

}
