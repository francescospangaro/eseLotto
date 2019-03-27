/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc_000
 */
public class DatiCondivisi {
    int numRuote;
    int primoNum;
    int secondoNum;
    int numRuoteVinte;
    int[] estratti = new int [5];
    boolean vittoriaPrimoNumero;
    boolean vittoriaSecondoNumero;
    Semaphore syncEstPri;
    Semaphore syncEstSec;
    Semaphore syncSecEst;
    Semaphore syncPriEst;

    public DatiCondivisi(int numRuote, int primoNum, int secondoNum, int[] estratti, boolean vittoriaPrimoNumero, boolean vittoriaSecondoNumero) {
        this.numRuote = numRuote;
        this.primoNum = primoNum;
        this.secondoNum = secondoNum;
        this.estratti = estratti;
        this.vittoriaPrimoNumero = vittoriaPrimoNumero;
        this.vittoriaSecondoNumero = vittoriaSecondoNumero;
        syncEstPri = new Semaphore(0);
        syncEstSec = new Semaphore(0);
        syncSecEst = new Semaphore(1);
        syncPriEst = new Semaphore(1);
    }

    public DatiCondivisi() {
    }

    public DatiCondivisi(int numRuote, int primoNum, int secondoNum) {
        this.numRuote = numRuote;
        this.primoNum = primoNum;
        this.secondoNum = secondoNum;
        syncEstPri = new Semaphore(0);
        syncEstSec = new Semaphore(0);
        syncSecEst = new Semaphore(1);
        syncPriEst = new Semaphore(1);
    }

    public int getNumRuote() {
        return numRuote;
    }

    public void setNumRuote(int numRuote) {
        this.numRuote = numRuote;
    }

    public int getPrimoNum() {
        return primoNum;
    }

    public void setPrimoNum(int primoNum) {
        this.primoNum = primoNum;
    }

    public int getSecondoNum() {
        return secondoNum;
    }

    public void setSecondoNum(int secondoNum) {
        this.secondoNum = secondoNum;
    }

    public int[] getEstratti() {
        return estratti;
    }

    public void setEstratti(int[] estratti) {
        this.estratti = estratti;
    }

    public boolean isVittoriaPrimoNumero() {
        return vittoriaPrimoNumero;
    }

    public void setVittoriaPrimoNumero(boolean vittoriaPrimoNumero) {
        this.vittoriaPrimoNumero = vittoriaPrimoNumero;
    }

    public boolean isVittoriaSecondoNumero() {
        return vittoriaSecondoNumero;
    }

    public void setVittoriaSecondoNumero(boolean vittoriaSecondoNumero) {
        this.vittoriaSecondoNumero = vittoriaSecondoNumero;
    }

    public int getNumRuoteVinte() {
        return numRuoteVinte;
    }

    public void setNumRuoteVinte(int numRuoteVinte) {
        this.numRuoteVinte = numRuoteVinte;
    }
    
    public synchronized void incVittorie(){
        numRuoteVinte++;
    }
    
    public void waitSyncEstPri() {
        try {
            syncEstPri.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitSyncEstSec() {
        try {
            syncEstSec.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitSyncSecEst() {
        try {
            syncSecEst.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitSyncPriEst() {
        try {
            syncPriEst.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void signalSyncEstPri(){
        syncEstPri.release();
    }
    
    public void signalSyncEstSec(){
        syncEstSec.release();
    }
    
    public void signalSyncSecEst(){
        syncSecEst.release();
    }
    
    public void signalSyncPriEst(){
        syncPriEst.release();
    }
}
