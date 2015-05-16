/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.io.Serializable;

/**
 *
 * @author hakon_000
 */
public class Konsulent extends Bruker implements Serializable {
    private String brukernavn;

    public Konsulent(String brukernavn, String passord, String fornavn, String etternavn ){
        super(passord, fornavn, etternavn);
        this.brukernavn = brukernavn;
    }
    
    @Override
    public String getNøkkel() {
        return brukernavn;
    }

}

