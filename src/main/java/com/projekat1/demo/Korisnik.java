package com.projekat1.demo;


import javax.persistence.*;
import java.util.*;
@MappedSuperclass
@Entity
public abstract class Korisnik implements IzradaListinga{
    private String ime;
    private String prezime;
    private String adresa;
    @Id
    private String brojUgovora;
    @ManyToOne
    private InternetProvajder internetProvajder;
    @ManyToOne
    private TarifniPaket tarifniPaket;
    @ElementCollection(targetClass = TarifniDodatak.class) //Collection koji treba je lista ili mapa, arraylist ne moze da se anotira
    private ArrayList<TarifniDodatak> tarifniDodaci;
    @ElementCollection(targetClass = ListingUnos.class)
    private ArrayList<ListingUnos> listingUnosi;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return getIme().equals(korisnik.getIme()) &&
                getPrezime().equals(korisnik.getPrezime()) &&
                getAdresa().equals(korisnik.getAdresa()) &&
                getBrojUgovora().equals(korisnik.getBrojUgovora()) &&
                getInternetProvajder().equals(korisnik.getInternetProvajder()) &&
                getTarifniPaket().equals(korisnik.getTarifniPaket()) &&
                tarifniDodaci.equals(korisnik.tarifniDodaci) &&
                getListingUnosi().equals(korisnik.getListingUnosi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIme(), getPrezime(), getAdresa(), getBrojUgovora(), getInternetProvajder(), getTarifniPaket(), tarifniDodaci, getListingUnosi());
    }
    public Korisnik(){

    }

    public Korisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brojUgovora = brojUgovora;
        this.internetProvajder = internetProvajder;
        this.tarifniPaket = tarifniPaket;
        this.tarifniDodaci= new ArrayList<>();
        this.listingUnosi= new ArrayList<>();
    }

    public abstract boolean surfuj(String url,int megabajti);
    public abstract void dodajTarifniDodatak(TarifniDodatak tarifniDodatak);
    @Override
    public String napraviListing(){
        String listing = "" ;
        listingUnosi.sort(Comparator.comparing(ListingUnos::getMegabajti).reversed());
       for(ListingUnos l : listingUnosi){

           listing =listing+" "+ l+ "\n"; }

    return listing; }

    public void dodajListingUnos(ListingUnos listingUnos){
       for (ListingUnos u : listingUnosi){
           if(u.getUrl().equals(listingUnos.getUrl())){
               u.dodajMegabajte(listingUnos.getMegabajti());
           } else
               listingUnosi.add(listingUnos);


       }
    }

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

    public ArrayList<TarifniDodatak> getTarifniDodataci() {
        return tarifniDodaci;
    }

    public ArrayList<ListingUnos> getListingUnosi() {
        return listingUnosi;
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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setBrojUgovora(String brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public void setInternetProvajder(InternetProvajder internetProvajder) {
        this.internetProvajder = internetProvajder;
    }

    public void setTarifniPaket(TarifniPaket tarifniPaket) {
        this.tarifniPaket = tarifniPaket;
    }

    public void setTarifniDodaci(ArrayList<TarifniDodatak> tarifniDodaci) {
        this.tarifniDodaci = tarifniDodaci;
    }

    public void setListingUnosi(ArrayList<ListingUnos> listingUnosi) {
        this.listingUnosi = listingUnosi;
    }
}

