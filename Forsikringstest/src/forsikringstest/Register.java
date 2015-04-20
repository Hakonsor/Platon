/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forsikringstest;


import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author hakon_000
 */
public class Register/* implements Comparator<Person>*/ {
    
    private Set<Forsikringer> tabell = new LinkedHashSet<>();
    
    public Register(){
        BoligForsikring b = new BoligForsikring(2000 , 300 , "rekkehus",
                  22, "werty", "qwert", "1991",
                  "metall", "eledig", "mye", "egg");
        
        tabell.add(b);
        tabell.add(b);
        tabell.add(new BoligForsikring(2000 , 300 , "rekkehus",
                  22, "werty", "qwert", "1991",
                  "metall", "eledig", "mye", "egg"));
        tabell.add(new BoligForsikring(2000 , 300 , "rekkehus",
                  22, "werty", "qwert", "1991",
                  "metall", "eledig", "mye", "egg"));
        tabell.add(new LivsForsikring( 2000 , 3000, 41407906 , "Må ha alkohol", "Håkon", "Sørby", "41407906", "grønligåsen", "41", "1413"));
        System.out.println(tabell);
         /*
       if)){}
        Set<Forsikringer> mengde = new LinkedHashSet<>();
        tabell.r
        
// instanceof.clone()
         mengde.add(tabell.c);
         */

}
    /*
        public int compare(Person p1, Person p2)
   {
       String n1 = p1.getEtternavn();
       String n2 = p2.getEtternavn();
       String f1 = p1.getFornavn();
       String f2 = p2.getFornavn();
       int d = kollator.compare(n1, n2);
       if (d != 0)
        return d;
       else
        return kollator.compare(f1, f2);
       }
    */
}
