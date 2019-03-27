/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Random;

/**
 *
 * @author franc_000
 */
public class ThEstrazione extends Thread{
    DatiCondivisi ptrDati;
    int[] estratti = new int [5];
    int num;

    public ThEstrazione(DatiCondivisi ptrDati){
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNumRuote();
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public int[] getEstratti() {
        return estratti;
    }

    public void setEstratti(int[] estratti) {
        this.estratti = estratti;
    }
    
    public void run(){
        Random rand = new Random();
        int estratto = 0;
        for(int i = 0; i < num; i++){
            ptrDati.waitSyncPriEst();
            ptrDati.waitSyncSecEst();
            for(int cont = 0; cont < 5; cont ++){
                estratto = rand.nextInt(90)+1;
                estratti[cont]=estratto;
            }
            ptrDati.signalSyncEstPri();
            ptrDati.signalSyncEstSec();
            System.out.println("Fine estrazione " + i);
        }
        System.out.println("Fine ThEstrazione");
    }
    
}
