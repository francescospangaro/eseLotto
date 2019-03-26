/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

/**
 *
 * @author franc_000
 */
public class ThRicercaSecondoNumero extends Thread{
    DatiCondivisi ptrDati;
    int numDaCercare;
    int[]estratti = new int [5];

    public ThRicercaSecondoNumero(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.numDaCercare = ptrDati.getPrimoNum();
        this.estratti = ptrDati.getEstratti();
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public int getNumDaCercare() {
        return numDaCercare;
    }

    public void setNumDaCercare(int numDaCercare) {
        this.numDaCercare = numDaCercare;
    }
    
    public void run(){
        for(int i = 0; i < 5; i++){
            ptrDati.waitSyncEstSec();
            if(numDaCercare == estratti[i]){
                ptrDati.setVittoriaSecondoNumero(true);
                if(ptrDati.isVittoriaPrimoNumero()){
                    ptrDati.incVittorie();
                    ptrDati.setVittoriaSecondoNumero(false);
                }
                ptrDati.setVittoriaSecondoNumero(false);
            }
            if(!(i == 4))
            ptrDati.signalSyncSecEst(); 
       }
        System.out.println("Fine ThRicercaSecondoNumero");
    }
}