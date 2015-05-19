package GUI;

import Forsikring.Forsikringer;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import java.util.ArrayList;

import Person.Bruker;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideInfo implements ComboBoxConverter {

    private ObservableList<String> navn = FXCollections.observableArrayList();
    private ObservableList<String> data = FXCollections.observableArrayList();
    
    private Kontroller kontroller;
    private ComboBox<String> forsikringComboBox;
    private VBox vb;
    private GridPane grid;
    
    private Label lbhei;
    private Label lbnavn;
    private Label lbkundenr;
    private Label lbepost;

    private Button btnSlett;
    private Button btnUtbetalinger;
    private Button btnStatus;
    
    private HBox hbKnapper;
    private HBox hbFelter;
    
    private ListView<String> listView;
    private TextArea textArea;

    public Pane infoFane(Kontroller kontroller) {
        this.kontroller = kontroller;
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");

        vb = new VBox();
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 40, 10));//top/right/bottom/left
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(false);

        lbhei = new Label();
        lbhei.setId("hei");
        lbhei.setText("Hei");
        lbhei.setAlignment(Pos.CENTER_RIGHT);

        lbnavn = new Label();
        lbnavn.setId("navn");
        lbnavn.setText(getKundeNavn());
        lbnavn.setAlignment(Pos.CENTER_LEFT);

        lbkundenr = new Label();
        lbkundenr.setId("kundenr");

        lbkundenr.setText("kundenr: " + getKundenr());
        lbkundenr.setAlignment(Pos.CENTER);

        lbepost = new Label();
        lbepost.setId("epost");
        //lbepost.setText("fornavn.etternavn@mail.com");
        lbepost.setText(getEpost());
        lbepost.setAlignment(Pos.CENTER);

        grid.add(lbhei, 0, 0);
        grid.add(lbnavn, 1, 0);
        grid.add(lbepost, 1, 1);
        grid.add(lbkundenr, 1, 2);

        hbKnapper = new HBox();
        hbKnapper.setSpacing(50);
        hbKnapper.setAlignment(Pos.CENTER);

        forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.setId("velg");
        forsikringComboBox.getItems().addAll("Alle", "Båtforsikring", "Reiseforsikring", "Bilforsikring", "Boligforsikring", "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {
            settListe();
            oppdaterArea();
        });

        FadeTransition ftcombo = new FadeTransition(Duration.millis(150), forsikringComboBox);
        ftcombo.setFromValue(0.0F);
        ftcombo.setToValue(1.0F);
        ftcombo.setCycleCount(1);
        
        btnSlett = new Button();
        btnSlett.setText("Slett");
        btnSlett.setId("slett");
        btnSlett.setMaxWidth(200);
        btnSlett.setOnAction(e -> { slettForsikring(); });
        
        FadeTransition ftslett = new FadeTransition(Duration.millis(150), btnSlett);
        ftslett.setFromValue(0.0F);
        ftslett.setToValue(1.0F);
        ftslett.setCycleCount(1);

        btnUtbetalinger = new Button();
        btnUtbetalinger.setText("Utbetalinger");
        btnUtbetalinger.setId("utbetalinger");
        btnUtbetalinger.setMaxWidth(200);
        btnUtbetalinger.setOnAction(e -> {
            textArea.setText("Denne knappen er laget for å vise\nutbetalte skademeldinger");
        });

        FadeTransition ftutbetal = new FadeTransition(Duration.millis(150), btnUtbetalinger);
        ftutbetal.setFromValue(0.0F);
        ftutbetal.setToValue(1.0F);
        ftutbetal.setCycleCount(1);

        btnStatus = new Button();
        btnStatus.setText("Status");
        btnStatus.setId("status");
        btnStatus.setMaxWidth(200);
        btnStatus.setOnAction(e -> {
            textArea.setText("Denne knappen er laget for å skrive ut\nstatus på kunden (eks totaltkunde)");
        });

        FadeTransition ftstatus = new FadeTransition(Duration.millis(150), btnStatus);
        ftstatus.setFromValue(0.0F);
        ftstatus.setToValue(1.0F);
        ftstatus.setCycleCount(1);

        SequentialTransition st = new SequentialTransition(ftcombo, ftslett, ftutbetal, ftstatus);
        st.play();

        hbKnapper.getChildren().addAll(forsikringComboBox, btnSlett, btnUtbetalinger, btnStatus);

        hbFelter = new HBox();
        hbFelter.setSpacing(30);
        hbFelter.setAlignment(Pos.CENTER);

        listView = new ListView<>(data);
        listView.setPrefSize(300, 300);
        listView.setId("listview");
        listView.setEditable(false);

        navn.clear();
        navn.addAll("Velg en forsikring fra listen over.");

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));
        listView.getSelectionModel().selectedItemProperty().addListener(e -> {
            skrivTilArea();
        });
        
        textArea = new TextArea();
        textArea.setPrefSize(300, 300);
        textArea.setId("textarea");
        textArea.setEditable(false);

        hbFelter.getChildren().addAll(listView, textArea);
        vb.getChildren().addAll(grid, hbKnapper, hbFelter);
        vb.setMaxWidth(600);

        borderPane.setCenter(vb);

        borderPane.getStylesheets().add("CSS/kundeInfo.css");
        
        return borderPane;
    }
    
    
    public void skrivTilArea(){
            String polisnr = listView.getSelectionModel().getSelectedItem();
            if (polisnr != null) {
                polisnr = polisnr.substring(0,6);
                Forsikringer s = kontroller.getForsikring(Integer.parseInt(polisnr.replaceAll("[^0-9]","0")));
                if (s != null) {
                    textArea.setText(s.toString());
                }
            }
    }

    public void settListe() {
        ArrayList<String> forsikringliste = kontroller.
                getInfoForsikringListe(forsikringComboBox.getItems().
                        indexOf(forsikringComboBox.getValue()));
        System.out.println(forsikringliste);
        if (forsikringliste == null) {
            navn.clear();
            navn.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
        } else {
            navn.setAll(forsikringliste);
        }
    }

    public void slettForsikring() {
        String polisNr = listView.getSelectionModel().getSelectedItem();
        if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
            polisNr = polisNr.substring(0, 6);
        } else {
            return;
        }
        kontroller.slettForsikring(Integer.parseInt(polisNr));
        settListe();
        oppdaterArea();
    }

    private String getKundeNavn(){
        Bruker b = kontroller.getInnloggetBruker();
        return b.getFornavn() + " " + b.getEtternavn();
    }

    private String getEpost(){
        Bruker b = kontroller.getInnloggetBruker();
        return b.getEpost();
    }

    private String getKundenr(){
        Bruker b = kontroller.getInnloggetBruker();
        return b.getNøkkel();
    }

    public void oppdaterArea() {
        textArea.setText("");

    }
}
