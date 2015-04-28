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
import java.util.List;

/**
 *
 * @author hakon_000
 */
public class SkadeMeldingRegister {

    List<SkadeMelding> skademeldingliste = new ArrayList<>();

    public SkadeMeldingRegister() {

    }

    public void addSkadeMedling(SkadeMelding skademelding) {
        skademeldingliste.add(skademelding);
    }

    public ArrayList<SkadeMelding> getSkadeMelding(Class forsikring, Bruker b) {
        ArrayList<SkadeMelding> liste = new ArrayList<>();
        for (SkadeMelding skade : skademeldingliste) {
            if (forsikring.isAssignableFrom(skade.getForsikring().getClass())) {
                liste.add(skade);
            }
        }
        return liste;
    }

}
