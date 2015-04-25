/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kontroller;


import Forsikring.BilForsikring;
import GUI.KundeSide;
import GUI.Login;
import GUI.Registrer;
import Person.Bruker;
import Person.Kunde;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 *
 * @author hakon_000
 */

    public class Kontroller implements EventHandler<ActionEvent>{
        
        public static Map<String, Bruker> brukerRegister = new HashMap<>();
        private Bruker innLoggetBruker = null;
        
        public Kontroller(Stage primaryStage) throws Exception{
                primaryStage.setOnCloseRequest(e -> skrivTilFil());
                primaryStage.getIcons().add(new Image("http://www.tryg.no/media/icon-login_148x120_78-5042.png"));
                lesFil();
                loginVindu(primaryStage);
            }
        //GUI
        public void skrivInn(){
            
            }
        public void loginVindu(Stage primaryStage) {
                innLoggetBruker = null;
                try {
                   Login login = new Login(primaryStage, this );
                }
                catch (java.lang.Exception jle){
                    System.out.println("Klarte ikke å åpne logginn vindu!");
                }
            }
        public void kundeSide(Stage primaryStage){
                KundeSide nyside = new KundeSide(primaryStage, this);
            }

        public void regVindu(){
                Registrer regVindu = new Registrer(new Stage(), this);
            }

        //Forsikring
        public void setForsikring(int bonusIndex, int egenandelIndex, 
            String telefonnummerString, int kjorelengdeIndex, String fornavn, 
            String tfEtternavn, String tfPersonnr, String postNr, String regNr, 
            String arsmodell,  String type, String tfKmstand){
                int telefonnummer = 0;
                int kmStand = 0;
                
                try{
                    telefonnummer = Integer.parseInt(telefonnummerString);
                }catch(NumberFormatException nfe){
                    System.out.println("Skriv inn kun helltall som telefonnummer");
                    return;
                }
                try{
                    kmStand = Integer.parseInt(tfKmstand);
                }catch(NumberFormatException nfe){
                    System.out.println("Skriv inn kun helltall i kilometer stand");
                    return;
                }
                double bonus;
                switch (bonusIndex) {
                    case 0:  bonus = -20.0;
                        break;
                    case 1:  bonus = -10.0;
                        break;
                    case 2:  bonus = 0.0;
                        break;
                    case 3:  bonus = 10.0;
                        break;
                    case 4:  bonus = 20.0;
                        break;
                    case 5:  bonus = 30.0;
                        break;
                    case 6:  bonus = 40.0;
                        break;
                    case 7:  bonus = 50.0;
                        break;
                    case 8:  bonus = 60.0;
                        break;
                    case 9:  bonus = 70.0;
                        break;
                    case 10:  bonus = 75.0;
                        break;              
                    default: System.out.println("Har ikke valgt bonus");
                        return;
                }
                double egenandel;
                switch(egenandelIndex){
                    case 0:  egenandel = 4000.0;
                        break;
                    case 1:  egenandel = 6000.0;
                        break;
                    case 2:  egenandel = 10000.0;
                        break;
                    default: System.out.println("har ikke valgt egenandel");
                        return;
                }
                int kjorelengde;
                switch(kjorelengdeIndex){
                    case 0:  kjorelengde = 100000;
                        break;
                    case 1:  kjorelengde = 150000;
                        break;
                    case 2:  kjorelengde = 200000;
                        break;
                    case 3:  kjorelengde = 300000;
                        break;
                    case 4:  kjorelengde = 350000;
                        break;
                    default: System.out.println("har ikke valgt kjørelengde");
                        return;
                }
                try{
                    Kunde k = (Kunde) innLoggetBruker;
                    k.settInn(new BilForsikring( bonus, egenandel, telefonnummer, 
                            kjorelengde, fornavn, tfEtternavn, tfPersonnr, postNr, 
                            regNr, type, regNr, type, arsmodell, kmStand) );
                }catch(ClassCastException cce) {
                    System.out.println(" Innlogget kunde er ikke av type kunde"); 
                }
                
                
          //  k.addForsikring(new BilForsikring());
            }
        //Bruker
        public void setInnloggetBruker(String nokkel){
                innLoggetBruker = brukerRegister.get(nokkel);
            }
        public Bruker getInnloggetBruker(){
            return innLoggetBruker;
            }
        public Bruker finnBruker(String Bruker){
                return brukerRegister.get(Bruker);
            }
        public boolean sjekkPassord(String bruker, String  passord){
                Bruker sjekkBruker = finnBruker(bruker);
                if(sjekkBruker == null) return false;
                return sjekkBruker.sjekkPassord(passord);
            }
        //Kunde
        public void nyKunde( Kunde b){
                brukerRegister.put(b.getKundeNokkel(), b);
            }
        public void registrerKunde(Kunde b){
                brukerRegister.put(b.getKundeNokkel(), b);
                System.out.println(b.toString());
            }
        public void addforsikring(Kunde kunde, String cbBonus, String cbEgenandel, String cbKjørelengde){
            if(cbBonus.matches("")){}
            }
        //Filskriving
        private void lesFil(){
            try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream( "src/Fil/forsikring.data" ))){
                    brukerRegister = (HashMap) innfil.readObject();
            }catch(ClassNotFoundException cnfe){
                System.out.println("Opprette tomt map");
                brukerRegister = new HashMap<>();
            }catch(FileNotFoundException fne){
                System.out.println("Finner ikke datafil. Oppretter ny fil.\n");
                brukerRegister  = new HashMap<>();
            }catch(IOException ioe){
                System.out.println("Innlesingsfeil. Oppretter ny fil.\n");
                brukerRegister = new HashMap<>();
        }
    }
        public void skrivTilFil() {
            try (ObjectOutputStream utfil = new ObjectOutputStream(
                new FileOutputStream("src/Fil/forsikring.data" ))){
                utfil.writeObject(brukerRegister);
            }catch( NotSerializableException nse ){
                System.out.println("Objektet er ikke serialisert!");
            }catch( IOException ioe ){
                System.out.println("Problem med utskrift til fil.");
            }
        }
        @Override
        public void handle(ActionEvent event) {
        // Vi tar i bruk lambda uttrykk istedenfor istedenfor
        // Metodene blir kjøre direkte med <knapp>.setOnAction( e -> regVindu())
        }
    }
    
