package GUI;

import Kontroller.Kontroller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Magnus on 27.04.15.
 */
public class KonsulentSide {

    private Kontroller kontroll;

    public KonsulentSide(Stage primaryStage, Kontroller k){
        this.kontroll = k;

        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Fil");

        MenuItem left = new MenuItem("Logg ut");
        menu.getItems().addAll(left);
        left.setOnAction(e -> {
            primaryStage.close();
            kontroll.loginVindu(primaryStage);
        });


        menuBar.getMenus().add(menu);

        BorderPane borderPane = new BorderPane();

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setTop(menuBar);

        TabPane tabPane = new TabPane();

        //Kunde
        Tab tabKunde = new Tab();
        tabKunde.setText("Kunde");
        tabKunde.setClosable(false);
        KonsulentsideKunde konsulentsideKunde = new KonsulentsideKunde();
        tabKunde.setContent(konsulentsideKunde.kundeFane(kontroll));


        //Statistikk
        Tab tabStat = new Tab();
        tabStat.setText("Statistikk");
        tabStat.setClosable(false);
        KonsulentsideStatistikk konsulentsideStatistikk = new KonsulentsideStatistikk();
        tabStat.setContent(konsulentsideStatistikk.statFane(kontroll));

        //Skademelding system
        Tab tabSkade = new Tab();
        tabSkade.setText("Skade");
        tabSkade.setClosable(false);
        KonsulentsideSkade konsulentsideSkade = new KonsulentsideSkade();
        tabSkade.setContent(konsulentsideSkade.skadeFane(kontroll));



        tabPane.getTabs().addAll(tabKunde, tabStat, tabSkade);

        borderPane.setCenter(tabPane);

        root.getChildren().add(borderPane);

        primaryStage.setTitle("Konsulentside");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("CSS/konsulentside.css");
        primaryStage.show();


    }








}
