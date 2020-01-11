package com.projekat1.demo;

public class PrepaidKorisnik extends Korisnik {
   private double kredit;

    public PrepaidKorisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket) {
        super(ime, prezime, adresa, brojUgovora, internetProvajder, tarifniPaket);
    }
    public void doupuniKredit(double kredit){
        return;
    }
    public boolean surfuj(String url,int megabajti){
        return true;
    }
    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak){

    }

    public double getKredit() {
        return kredit;
    }

    @Override
    public String toString() {
        return "PrepaidKorisnik{" +
                "kredit=" + kredit +
                '}';
    }


}
