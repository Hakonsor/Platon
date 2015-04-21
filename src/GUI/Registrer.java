package GUI;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.TOP_CENTER;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.applet.AppletListener;
import sun.net.www.ApplicationLaunchException;


/**
 * Created by Magnus on 20.04.15.
 */

public class  Registrer {
    
    private static final String LoginBilde = "Bilder/add_user.png";
    static Stage vindu = new Stage();
    
    public static void Display()  {
        
        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(40));

        ImageView loginImg = new ImageView(new Image(LoginBilde));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(100);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        Label nyKunde = new Label();
        nyKunde.setText("Ny Kunde");
        nyKunde.setId("nykunde");
        GridPane.setHalignment(nyKunde, HPos.CENTER);

        TextField fornavn = new TextField();
        fornavn.setPromptText("Fornavn");
        fornavn.setId("fornavn");
        fornavn.setMaxWidth(200);
        GridPane.setHalignment(fornavn, HPos.CENTER);

        TextField etternavn = new TextField();
        etternavn.setPromptText("Etternavn");
        etternavn.setId("etternavn");
        etternavn.setMaxWidth(200);
        GridPane.setHalignment(etternavn, HPos.CENTER);

        TextField personnr = new TextField();
        personnr.setPromptText("Personnr");
        personnr.setId("personnr");
        personnr.setMaxWidth(200);
        GridPane.setHalignment(personnr, HPos.CENTER);

        TextField telefon = new TextField();
        telefon.setPromptText("Telefon");
        telefon.setId("telefon");
        telefon.setMaxWidth(200);
        GridPane.setHalignment(telefon, HPos.CENTER);

        TextField epost = new TextField();
        epost.setPromptText("E-Post");
        epost.setId("epost");
        epost.setMaxWidth(200);
        GridPane.setHalignment(epost, HPos.CENTER);

        TextField adresse = new TextField();
        adresse.setPromptText("Adresse");
        adresse.setId("adresse");
        adresse.setMaxWidth(200);
        GridPane.setHalignment(adresse, HPos.CENTER);

        PasswordField velgpassord = new PasswordField();
        velgpassord.setPromptText("Velg Passord");
        velgpassord.setId("velgpassord");
        velgpassord.setMaxWidth(200);
        GridPane.setHalignment(velgpassord, HPos.CENTER);

        PasswordField gjentapassord = new PasswordField();
        gjentapassord.setPromptText("Gjenta Passord");
        gjentapassord.setId("gjentapassord");
        gjentapassord.setMaxWidth(200);
        GridPane.setHalignment(gjentapassord, HPos.CENTER);


        Button btnRegKunde = new Button("Registrer Kunde");
        btnRegKunde.setId("btNyKunde");
        btnRegKunde.setMaxWidth(200);
        GridPane.setHalignment(btnRegKunde, HPos.CENTER);

        grid.add(loginImg, 0, 0);
        grid.add(nyKunde,0 ,1);
        grid.add(fornavn, 0, 2);
        grid.add(etternavn, 0, 3);
        grid.add(personnr, 0, 4);
        grid.add(telefon, 0, 5);
        grid.add(epost, 0, 6);
        grid.add(adresse, 0, 7);
        grid.add(velgpassord, 0, 8);
        grid.add(gjentapassord, 0, 9);
        grid.add(btnRegKunde, 0, 10);


        Scene scene = new Scene(grid, 300, 550);
        vindu.setTitle("Registrer");
        vindu.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("CSS/registrer.css").toExternalForm());
        vindu.show();
    }



}//End of class
