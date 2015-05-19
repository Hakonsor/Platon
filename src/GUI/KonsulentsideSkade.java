package GUI;

import Forsikring.BilForsikring;
import Kontroller.Kontroller;
import SkadeMeldinger.*;
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
        borderPane.setId("borderpane");
        borderPane.setPadding(new Insets(120, 10, 10, 10));//top/right/bottom/left

        SkadeMeldingRegister skadeMeldingRegister = new SkadeMeldingRegister();

        //Elementer
        Label lbNummer = new Label();
        lbNummer.setText("Nummer:");
        lbNummer.setId("nummer");
        lbNummer.setAlignment(Pos.CENTER);

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

        TextField tfNummer = new TextField();
        tfNummer.setText(Integer.toString(kontroll.visSkadeIndex()));
        tfNummer.setMaxWidth(50);
        tfNummer.setEditable(false);
        tfNummer.setAlignment(Pos.CENTER);

        TextArea taLes = new TextArea();
        taLes.setEditable(false);
        taLes.setPromptText("");
        taLes.setMaxWidth(800);
        taLes.setMinWidth(800);
        taLes.setMaxHeight(300);
        taLes.setMinHeight(300);

        // angir den første skademeldingen som vises.
        if (skade != null) {
            // viser den spesifikke skademeldingen
            if (skade instanceof BilSkadeMelding) {
                BilSkadeMelding s = (BilSkadeMelding) skade;
                taLes.setText(s.melding());
            } else if (skade instanceof BatSkadeMelding) {
                BatSkadeMelding s = (BatSkadeMelding) skade;
                taLes.setText(s.melding());
            } else if (skade instanceof BoligSkadeMelding) {
                BoligSkadeMelding s = (BoligSkadeMelding) skade;
                taLes.setText(s.melding());
            } else if (skade instanceof FritidsBoligMelding) {
                FritidsBoligMelding s = (FritidsBoligMelding) skade;
                taLes.setText(s.melding());
            } else if (skade instanceof ReiseSkadeMelding) {
                ReiseSkadeMelding s = (ReiseSkadeMelding) skade;
                taLes.setText(s.melding());
            }
        } else {
            taLes.setText("Ingen registrerte skademeldinger.");
        }

        Label lbantall = new Label();
        lbantall.setText("Antall:");
        lbantall.setId("antall");

        TextField tfAntall = new TextField();
        tfAntall.setAlignment(Pos.CENTER);
        tfAntall.setId("tfantall");
        tfAntall.setMaxWidth(50);
        tfAntall.setEditable(false);
        tfAntall.setText("" + kontroll.visAntalliKø());

        Button btnGodta = new Button("Godta");
        btnGodta.setMinWidth(200);
        btnGodta.setId("godta");
        btnGodta.setAlignment(Pos.CENTER);

        Button btnAvvis = new Button("Avvis");
        btnAvvis.setId("avvis");
        btnAvvis.setMinWidth(200);
        btnAvvis.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.setPadding(new Insets(10));
        vb.setSpacing(10);
        vb.setAlignment(Pos.TOP_CENTER);

        HBox hbControll = new HBox();
        hbControll.setSpacing(10);
        hbControll.setAlignment(Pos.CENTER);
        hbControll.getChildren().addAll(lbForrige, btnVenstre, tfNummer, btnHøyre, lbNeste);

        HBox hbKnapper = new HBox();
        hbKnapper.setSpacing(10);
        hbKnapper.setAlignment(Pos.CENTER);
        hbKnapper.getChildren().addAll(lbantall, tfAntall, btnGodta, btnAvvis);

        vb.getChildren().addAll(lbNummer, hbControll, taLes, hbKnapper);
        borderPane.setCenter(vb); // CENTER

        // går tilbake i køen over skademeldinger.
        btnVenstre.setOnMouseClicked((MouseEvent event) -> {
            if (skade != null) {

                skade = kontroll.visForrigeIKø();
                if (skade instanceof BilSkadeMelding) {
                    BilSkadeMelding s = (BilSkadeMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof BatSkadeMelding) {
                    BatSkadeMelding s = (BatSkadeMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof BoligSkadeMelding) {
                    BoligSkadeMelding s = (BoligSkadeMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof FritidsBoligMelding) {
                    FritidsBoligMelding s = (FritidsBoligMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof ReiseSkadeMelding) {
                    ReiseSkadeMelding s = (ReiseSkadeMelding) skade;
                    taLes.setText(s.melding());
                }
                tfNummer.setText(Integer.toString(kontroll.visSkadeIndex()));
                tfAntall.setText("" + kontroll.visAntalliKø());
            } else {
                taLes.setText("Det er ikke registrert noen flere skademeldinger.");
            }
        });

        btnHøyre.setOnMouseClicked((MouseEvent event) -> {
            if (skade != null) {

                skade = kontroll.visNesteIKø();
                if (skade instanceof BilSkadeMelding) {
                    BilSkadeMelding s = (BilSkadeMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof BatSkadeMelding) {
                    BatSkadeMelding s = (BatSkadeMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof BoligSkadeMelding) {
                    BoligSkadeMelding s = (BoligSkadeMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof FritidsBoligMelding) {
                    FritidsBoligMelding s = (FritidsBoligMelding) skade;
                    taLes.setText(s.melding());
                } else if (skade instanceof ReiseSkadeMelding) {
                    ReiseSkadeMelding s = (ReiseSkadeMelding) skade;
                    taLes.setText(s.melding());
                }
                tfNummer.setText(Integer.toString(kontroll.visSkadeIndex()));
                tfAntall.setText("" + kontroll.visAntalliKø());
            } else {
                taLes.setText("Det er ikke registrert noen nye skademeldinger.");
            }
        });

        // godkjenner beløpet og setter skademeldingen i registeret, samt oppdaterer premien.
        // godkjenner beløpet og setter skademeldingen i registeret
        btnGodta.setOnAction((ActionEvent e) -> {

            if (skade != null) {
                tfNummer.setText(Integer.toString(kontroll.visSkadeIndex()));
                tfAntall.setText("" + kontroll.visAntalliKø());
                kontroll.ferdigBehandlet(skade);
                if (skade.getUtbetaling() != 0) {
                    skade.okUtbetal();
                    skade.getForsikring().nyPremieOk();
                }
                if (skade instanceof BilSkadeMelding && skade.getUtbetaling() != 0) {
                    BilForsikring bil = (BilForsikring) skade.getForsikring();
                    bil.bonusGodkjent();
                }

                if (skade != null) {
                    skade = kontroll.visNesteIKø();
                    if (skade instanceof BilSkadeMelding) {
                        BilSkadeMelding s = (BilSkadeMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof BatSkadeMelding) {
                        BatSkadeMelding s = (BatSkadeMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof BoligSkadeMelding) {
                        BoligSkadeMelding s = (BoligSkadeMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof FritidsBoligMelding) {
                        FritidsBoligMelding s = (FritidsBoligMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof ReiseSkadeMelding) {
                        ReiseSkadeMelding s = (ReiseSkadeMelding) skade;
                        taLes.setText(s.melding());
                    }

                }
                tfNummer.setText(Integer.toString(kontroll.visSkadeIndex()));
                tfAntall.setText("" + kontroll.visAntalliKø());
            } else {
                taLes.setText("Det er ingen skademeldinger registert.");
                tfNummer.setText(Integer.toString(0));
            }

        });
        //legger skademeldingen i registeret, og sletter beløpet som er lagt tli betaling.
        btnAvvis.setOnAction((ActionEvent e) -> {

            if (skade != null) {
                kontroll.ferdigBehandlet(skade);
                skade.avvis();
                skade = kontroll.visNesteIKø();
                
                if (skade != null) {
                    
                    if (skade instanceof BilSkadeMelding) {
                        BilSkadeMelding s = (BilSkadeMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof BatSkadeMelding) {
                        BatSkadeMelding s = (BatSkadeMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof BoligSkadeMelding) {
                        BoligSkadeMelding s = (BoligSkadeMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof FritidsBoligMelding) {
                        FritidsBoligMelding s = (FritidsBoligMelding) skade;
                        taLes.setText(s.melding());
                    } else if (skade instanceof ReiseSkadeMelding) {
                        ReiseSkadeMelding s = (ReiseSkadeMelding) skade;
                        taLes.setText(s.melding());
                    }

                }
                tfAntall.setText("" + kontroll.visAntalliKø());
                tfNummer.setText(Integer.toString(kontroll.visSkadeIndex()));
            } else {
                taLes.setText("Det er ingen skademeldinger registert.");
                tfNummer.setText(Integer.toString(0));
            }

        });
        borderPane.getStylesheets().add("CSS/konsulentskade.css");
        return borderPane;
    }

}
