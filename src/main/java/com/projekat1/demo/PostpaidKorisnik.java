package com.projekat1.demo;

import java.util.ArrayList;

public class PostpaidKorisnik extends Korisnik {
    private double prekoracenje;


    public PostpaidKorisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket, double prekoracenje) {
            super(ime, prezime, adresa, brojUgovora, internetProvajder, tarifniPaket);
        this.prekoracenje = prekoracenje;
    }

    public double ukupnoZaNaplatu(){

        return 0;
    }
    public boolean surfuj(){

        return true;
    }
    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak){

    }

    public double getPrekoracenje() {
        return prekoracenje;
    }


}
