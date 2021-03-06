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
public class ThRicercaPrimoNumero extends Thread {

    DatiCondivisi ptrDati;
    int numDaCercare;


    public ThRicercaPrimoNumero(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.numDaCercare = ptrDati.getPrimoNum();
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

    public void run() {
        for (int j = 0; j < ptrDati.numRuote; j++) {
            ptrDati.waitSyncEstPri();
            for (int i = 0; i < 5; i++) {
                if (numDaCercare == ptrDati.getEstratti()[i]) {
                    ptrDati.setVittoriaPrimoNumero(true);
                    if (ptrDati.isVittoriaSecondoNumero()) {
                        ptrDati.incVittorie();
                        ptrDati.setVittoriaPrimoNumero(false);
                    }
                }
                ptrDati.setVittoriaPrimoNumero(false);
            }
            System.out.println("Fine ricerca primo numero " + j);
            ptrDati.signalSyncPriEst();
        }
        System.out.println("Fine ThRicercaPrimoNumero");
    }

}
