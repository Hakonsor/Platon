/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

/**
 *
 * @author hakon_000
 */
public class Konsulent extends Bruker{
    private String brukernavn;
    Konsulent(String brukernavn, String passord, String fornavn, String etternavn ){
        super(fornavn, etternavn, passord);
        this.brukernavn = brukernavn;
    }
    
    @Override
    public String getNøkkel() {
        return brukernavn;
    }
    
    
    
}
