/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 *
 * @author hakon_000
 */
public class Mapdata {

    private static HashMap<String, String> postregister;

    public Mapdata() {
        lesFil();

    }

    public void lesFil() {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream("postregister.data"))) {
            postregister = (HashMap<String, String>) innfil.readObject();

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Opprette nye registere");
            postregister = new HashMap<>();

        } catch (FileNotFoundException fne) {
            System.out.println("Finner ikke datafil. Oppretter ny fil.\n");
            postregister = new HashMap<>();

        } catch (IOException ioe) {
            System.out.println("Innlesingsfeil. Oppretter ny fil.\n");
            postregister = new HashMap<>();

        }
    }

    public static HashMap<String, String> getRegister() {
        return postregister;

    }
}
