package com.projekat1.demo;

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

    @Override
    public String toString() {
        return "TarifniDodatak{" +
                "cenaDodatka=" + cenaDodatka +
                ", tipDodatka=" + tipDodatka +
                '}';
    }
}
