package GUI;


import Kontroller.Kontroller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Created by Magnus on 18.04.15.
 */
public class Login {
    private String LoginBilde = "Bilder/user.png";

    private Stage primaryStage;
    private Kontroller kontroll;

    private Button btnNyKunde;
    private Button btnKonsulentLogginn;
    private Button btnKundeLogginn;
    private Button btnNyKonsulent;
    
    TextField tfKundeBrukernavn;
    PasswordField pfKundePassord; 
    TextField tfKonsulentBrukernavn;
    PasswordField pfKonsulentPassord; 

    public Login(Stage primaryStage, Kontroller k) throws Exception {

        this.primaryStage = primaryStage;

        kontroll = k;
        TabPane tabs = new TabPane();

        Tab tabKunde = new Tab();
        tabKunde.setText("Kunde");
        tabKunde.setClosable(false);
        tabKunde.setContent(kundeFane());

        Tab tabKonsulent = new Tab();
        tabKonsulent.setText("Konsulent");
        tabKonsulent.setClosable(false);
        tabKonsulent.setContent(konsulentFane());
        tabs.getTabs().addAll(tabKunde, tabKonsulent);

        Scene scene = new Scene(tabs, 800, 640);
        primaryStage.setTitle("Logg inn");
        primaryStage.setScene(scene);

        scene.getStylesheets().add("CSS/login.css");
        primaryStage.show();
    }

    private void closeLogin(){
        primaryStage.hide();
    }

   
    private Pane kundeFane(){

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100));
        

        ImageView loginImg = new ImageView(new Image(LoginBilde));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(128);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        Label velkommen = new Label();
        velkommen.setText("Kunde Logginn");
        velkommen.setId("kunde_velkommen_tekst");
        GridPane.setHalignment(velkommen, HPos.CENTER);

        Label info = new Label();
        info.setText("Logg inn for å fortsette");
        info.setId("logginn_info");
        GridPane.setHalignment(info, HPos.CENTER);

        tfKundeBrukernavn = new TextField();
        tfKundeBrukernavn.setPromptText("kundenr");
        tfKundeBrukernavn.setId("tfkundenr");
        tfKundeBrukernavn.setMaxWidth(200);
        GridPane.setHalignment(tfKundeBrukernavn, HPos.CENTER);

        pfKundePassord = new PasswordField();
        pfKundePassord.setPromptText("passord");
        pfKundePassord.setId("pfKundePassord");
        pfKundePassord.setMaxWidth(200);
        GridPane.setHalignment(pfKundePassord, HPos.CENTER);

        Label logginnInfo = new Label();
        logginnInfo.setText("feil passord!");
        logginnInfo.setId("logginnInfo");
        GridPane.setHalignment(logginnInfo, HPos.CENTER);

        btnKundeLogginn = new Button("Logg inn");
        btnKundeLogginn.setId("btnlogginn");
        btnKundeLogginn.setMaxWidth(200);
        //btnKundeLogginn.setOnAction(kontroll);
        GridPane.setHalignment(btnKundeLogginn, HPos.CENTER);
        
        try {
            btnKundeLogginn.setOnAction(e -> {
                if(kontroll.sjekkPassord(tfKundeBrukernavn.getText(), pfKundePassord.getText())){
                kontroll.kundeSide(primaryStage);
                kontroll.setInnloggetBruker(tfKundeBrukernavn.getText() );
                
                
                }else{
                    System.out.println("TODO, pop opp box med som sier at passordened er ulike");
                }
            });
        }catch (Exception ex) {
            Logger.getLogger(KundeSide.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        btnNyKunde = new Button("Ny Kunde");
        btnNyKunde.setId("btNyKunde");
        btnNyKunde.setMaxWidth(200);
        GridPane.setHalignment(btnNyKunde, HPos.CENTER);
        try { 
            btnNyKunde.setOnAction(e -> kontroll.regVindu());
        }catch (Exception ex) {
          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        grid.add(loginImg, 0, 0);
        grid.add(velkommen, 0, 1);
        grid.add(info, 0, 2);
        grid.add(tfKundeBrukernavn, 0, 5);
        grid.add(pfKundePassord, 0, 6);
        grid.add(logginnInfo, 0, 7);
        grid.add(btnKundeLogginn, 0, 8);
        grid.add(btnNyKunde, 0, 9);

        return grid;
    }

    private Pane konsulentFane() {
        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        ImageView loginImg = new ImageView(new Image(LoginBilde));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(128);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        Label velkommen = new Label();
        velkommen.setText("Konsulent Logginn");
        velkommen.setId("konsulent_velkommen_tekst");
        GridPane.setHalignment(velkommen, HPos.CENTER);

        Label info = new Label();
        info.setText("Logg inn for å fortsette");
        info.setId("logginn_info");
        GridPane.setHalignment(info, HPos.CENTER);

        tfKonsulentBrukernavn = new TextField();
        tfKonsulentBrukernavn.setPromptText("brukernavn");
        tfKonsulentBrukernavn.setId("tfbrukernavn");
        tfKonsulentBrukernavn.setMaxWidth(200);
        GridPane.setHalignment(tfKonsulentBrukernavn, HPos.CENTER);

        pfKonsulentPassord = new PasswordField();
        pfKonsulentPassord.setPromptText("passord");
        pfKonsulentPassord.setId("pfbrukernavn");
        pfKonsulentPassord.setMaxWidth(200);
        GridPane.setHalignment(pfKonsulentPassord, HPos.CENTER);

        btnKonsulentLogginn = new Button("Logg inn");
        btnKonsulentLogginn.setId("btnlogginn");
        btnKonsulentLogginn.setMaxWidth(200);
        GridPane.setHalignment(btnKonsulentLogginn, HPos.CENTER);

        btnNyKonsulent = new Button("Ny Konsulent");
        btnNyKonsulent.setId("btNyKonsulent");
        btnNyKonsulent.setMaxWidth(200);
        GridPane.setHalignment(btnNyKonsulent, HPos.CENTER);

        grid.add(loginImg, 0, 0);
        grid.add(velkommen, 0, 1);
        grid.add(info, 0, 2);
        grid.add(tfKonsulentBrukernavn, 0, 5);
        grid.add(pfKonsulentPassord, 0, 6);
      //  grid.add(logginnInfo, 0, 7);
        grid.add(btnKonsulentLogginn, 0, 8);
        grid.add(btnNyKonsulent, 0, 9);

        return grid;
    }
    
    public Button getKnappKonsulentLogginn(){
        return btnKonsulentLogginn;
    }
    public Button getKnappKundeLogginn(){
        return btnKundeLogginn;  
    }
    public Button getKnappNyKonsulent(){
        return btnNyKonsulent;
    }    
    public String getKunde(){
        return tfKundeBrukernavn.getText();
    }
    public String getPassordKunde(){
        return pfKundePassord.getText();
    } 
    public String getKunsulent(){
        return tfKonsulentBrukernavn.getText();
    }
    public String getKunsulentPassord(){
        return pfKonsulentPassord.getText();
    } 
    
    



}//End of class
