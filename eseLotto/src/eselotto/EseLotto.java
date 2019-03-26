/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc_000
 */
public class EseLotto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            System.out.println("Inserisci su quante ruote vuoi giocare");
            int ruote = input.nextInt();
            System.out.println("Inserisci il primo numero da giocare");
            int primoNum = input.nextInt();
            System.out.println("Inserisci il secondo numero da giocare");
            int secondoNum = input.nextInt();
            DatiCondivisi ptrDati = new DatiCondivisi(ruote, primoNum, secondoNum);
            
            ThEstrazione thEstrazione = new ThEstrazione(ptrDati);
            ThRicercaPrimoNumero thRicercaPrimoNumero = new ThRicercaPrimoNumero(ptrDati);
            ThRicercaSecondoNumero thRicercaSecondoNumero = new ThRicercaSecondoNumero(ptrDati);
            
            thEstrazione.start();
            thRicercaPrimoNumero.start();
            thRicercaSecondoNumero.start();
            
            thEstrazione.join();
            thRicercaPrimoNumero.join();
            thRicercaSecondoNumero.join();
            
            System.out.println("Hai fatto ambo " + ptrDati.getNumRuoteVinte() + "volte");
        } catch (InterruptedException ex) {
            Logger.getLogger(EseLotto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
