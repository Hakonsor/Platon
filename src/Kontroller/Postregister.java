/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import Forsikring.Forsikringer;
import Person.Kunde;
import SkadeMeldinger.SkadeMelding;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Håkon
 */
public class Postregister {

    private HashMap<String, String> postregister;

    public Postregister() {
        postregister = Mapdata.getRegister();
    }

    public String getPoststed(String postnummer) {
        return postregister.get(postnummer);
    }
}
