package com.projekat1.demo;

import java.util.ArrayList;

public abstract class Korisnik implements IzradaListinga{
    private String ime;
    private String prezime;
    private String adresa;
    private String brojUgovora;
    private InternetProvajder internetProvajder;
    private TarifniPaket tarifniPaket;
    private ArrayList<TarifniDodatak> tarifniDodataks;
    private ArrayList<ListingUnos> listingUnos;


    public Korisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brojUgovora = brojUgovora;
        this.internetProvajder = internetProvajder;
        this.tarifniPaket = tarifniPaket;
    }
    @Override
    public String napraviListing(){

    return "listing je + "; }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getBrojUgovora() {
        return brojUgovora;

    }

    public InternetProvajder getInternetProvajder() {
        return internetProvajder;
    }

    public TarifniPaket getTarifniPaket() {
        return tarifniPaket;
    }

    public ArrayList<TarifniDodatak> getTarifniDodataks() {
        return tarifniDodataks;
    }

    public ArrayList<ListingUnos> getListingUnos() {
        return listingUnos;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojUgovora='" + brojUgovora + '\'' +
                ", internetProvajder=" + internetProvajder +
                ", tarifniPaket=" + tarifniPaket +
                '}';
    }
}
