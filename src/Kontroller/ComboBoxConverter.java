/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

/**
 *
 * @author hakon_000
 */
public interface ComboBoxConverter {
        default double indexEgenandelConverterer(int indexEgenandel){
                double egenandel;
                switch(indexEgenandel){
                    case 0:  egenandel = 4000.0;
                        break;
                    case 1:  egenandel = 6000.0;
                        break;
                    case 2:  egenandel = 10000.0;
                        break;
                    default: System.out.println("har ikke valgt egenandel");
                            egenandel = 0;
                    }
                return egenandel;
        
                }
        default int indexKjoreLengdeConverterer(int kjorelengdeIndex){
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
                        kjorelengde = 0;    
                }
                return kjorelengde;
    
        }
        default double indexBonusConverterer(int bonusIndex){
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
                        bonus = 0;
                }
                return bonus;
        }   
}
