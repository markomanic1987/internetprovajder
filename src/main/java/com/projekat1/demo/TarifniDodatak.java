package com.projekat1.demo;

import javax.persistence.Entity;


public class TarifniDodatak {
    private double cenaDodatka;
    private TipDodatka tipDodatka;

    public TarifniDodatak(double cenaDodatka, TipDodatka tipDodatka) {
        this.cenaDodatka = cenaDodatka;
        this.tipDodatka = tipDodatka;
    }

    public double getCenaDodatka() {
        return cenaDodatka;
    }

    public TipDodatka getTipDodatka() {
        return tipDodatka;
    }

    public void setCenaDodatka(double cenaDodatka) {
        this.cenaDodatka = cenaDodatka;
    }

    public void setTipDodatka(TipDodatka tipDodatka) {
        this.tipDodatka = tipDodatka;
    }

    @Override
    public String toString() {
        return "TarifniDodatak{" +
                "cenaDodatka=" + cenaDodatka +
                ", tipDodatka=" + tipDodatka +
                '}';
    }
}
