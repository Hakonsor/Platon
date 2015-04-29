/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;
import Person.Bruker;
import Person.Kunde;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hakon_000
 */
public class SkadeMeldingRegister {
    
    List<SkadeMelding> behandling = new LinkedList<>();
    List<SkadeMelding> register= new ArrayList<>();

    public SkadeMeldingRegister() {

    }

    // legger skademelcingen i registeret
    public void addSkadeMelding(SkadeMelding skademelding) {
        register.add(skademelding);
    }
    

    // Metode som henter en liste over alle skademeldinger knyttet en bestemt bruker(kunde)
    public ArrayList<SkadeMelding> getSkadeMelding(Class forsikring, Bruker b) {
        ArrayList<SkadeMelding> liste = new ArrayList<>();
        register.stream().filter((skade) -> (forsikring.isAssignableFrom(skade.getForsikring().getClass()))).forEach((skade) -> {
            liste.add(skade);
        });
        return liste;
    }

}
