/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import java.util.ArrayList;

/**
 *
 * @author ashanmadushanka
 */
public class Section_Details {
    private int id;
    private int duration;
    private int  Opw;
    private int Oal;
    private int Ows;
    private int Oqc;
    private int Otesting;
    private int OFinal;
    private int Opacking;
    private int  Mpw;
    private int Mal;
    private int Mws;
    private int Mqc;
    private int Mtesting;
    private int MFinal;
    private int Mpacking;

    /**
     * @return the Opw
     */
    public int getOpw() {
        return Opw;
    }

    /**
     * @param Opw the Opw to set
     */
    public void setOpw(int Opw) {
        this.Opw = Opw;
    }

    /**
     * @return the Oal
     */
    public int getOal() {
        return Oal;
    }

    /**
     * @param Oal the Oal to set
     */
    public void setOal(int Oal) {
        this.Oal = Oal;
    }

    /**
     * @return the Ows
     */
    public int getOws() {
        return Ows;
    }

    /**
     * @param Ows the Ows to set
     */
    public void setOws(int Ows) {
        this.Ows = Ows;
    }

    /**
     * @return the Oqc
     */
    public int getOqc() {
        return Oqc;
    }

    /**
     * @param Oqc the Oqc to set
     */
    public void setOqc(int Oqc) {
        this.Oqc = Oqc;
    }

    /**
     * @return the Otesting
     */
    public int getOtesting() {
        return Otesting;
    }

    /**
     * @param Otesting the Otesting to set
     */
    public void setOtesting(int Otesting) {
        this.Otesting = Otesting;
    }

    /**
     * @return the OFinal
     */
    public int getOFinal() {
        return OFinal;
    }

    /**
     * @param OFinal the OFinal to set
     */
    public void setOFinal(int OFinal) {
        this.OFinal = OFinal;
    }

    /**
     * @return the Mpw
     */
    public int getMpw() {
        return Mpw;
    }

    /**
     * @param Mpw the Mpw to set
     */
    public void setMpw(int Mpw) {
        this.Mpw = Mpw;
    }

    /**
     * @return the Mal
     */
    public int getMal() {
        return Mal;
    }

    /**
     * @param Mal the Mal to set
     */
    public void setMal(int Mal) {
        this.Mal = Mal;
    }

    /**
     * @return the Mws
     */
    public int getMws() {
        return Mws;
    }

    /**
     * @param Mws the Mws to set
     */
    public void setMws(int Mws) {
        this.Mws = Mws;
    }

    /**
     * @return the Mqc
     */
    public int getMqc() {
        return Mqc;
    }

    /**
     * @param Mqc the Mqc to set
     */
    public void setMqc(int Mqc) {
        this.Mqc = Mqc;
    }

    /**
     * @return the Mtesting
     */
    public int getMtesting() {
        return Mtesting;
    }

    /**
     * @param Mtesting the Mtesting to set
     */
    public void setMtesting(int Mtesting) {
        this.Mtesting = Mtesting;
    }

    /**
     * @return the MFinal
     */
    public int getMFinal() {
        return MFinal;
    }

    /**
     * @param MFinal the MFinal to set
     */
    public void setMFinal(int MFinal) {
        this.MFinal = MFinal;
    }

    /**
     * @return the Opacking
     */
    public int getOpacking() {
        return Opacking;
    }

    /**
     * @param Opacking the Opacking to set
     */
    public void setOpacking(int Opacking) {
        this.Opacking = Opacking;
    }

    /**
     * @return the Mpacking
     */
    public int getMpacking() {
        return Mpacking;
    }

    /**
     * @param Mpacking the Mpacking to set
     */
    public void setMpacking(int Mpacking) {
        this.Mpacking = Mpacking;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        String[] list = new String[10];
        list= duration.split(" ");
        System.out.println("list[0]-"+list[0]);
        int days= Integer.parseInt(list[0]);
        int minutes = days*60*9;
        
        this.duration=minutes;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
