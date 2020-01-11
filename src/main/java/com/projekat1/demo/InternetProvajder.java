package com.projekat1.demo;

public class InternetProvajder {
    private String imeProvajdera;

    public void generisiRacune(){

    }
    public void zabeleziSaobracaj(Korisnik korisnik){

    }
    public void prikazPrepaidKorisnika(){

    }
    public void prikazPostpaidKorisnika(){

    }
    public void dodajKorisnika(Korisnik korisnik){

    }



    public InternetProvajder(String imeProvajdera) {
        this.imeProvajdera = imeProvajdera;
    }

    public String getImeProvajdera() {
        return imeProvajdera;
    }

    @Override
    public String toString() {
        return "InternetProvajder{" +
                "imeProvajdera='" + imeProvajdera + '\'' +
                '}';
    }
}

