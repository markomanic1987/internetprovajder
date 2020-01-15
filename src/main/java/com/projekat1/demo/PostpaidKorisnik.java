package com.projekat1.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PostpaidKorisnik extends Korisnik {
    private double prekoracenje;


    public PostpaidKorisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket, double prekoracenje) {
            super(ime, prezime, adresa, brojUgovora, internetProvajder, tarifniPaket);
        this.prekoracenje = prekoracenje;
    }

    public double ukupnoZaNaplatu(){
        double suma =0;
        for(TarifniDodatak t : getTarifniDodataci()){
            suma += t.getCenaDodatka();
        }


        double ukupno = getTarifniPaket().getCenaPaketa() + suma + getPrekoracenje();
        return ukupno;
    }
    @Override
    public boolean surfuj(String url,int megabajti){

        if (getTarifniPaket().isNeogranicenSaobracaj()== true){


            getListingUnosi().add(new ListingUnos(url,megabajti));
        }
        else {
            if(getTarifniDodataci().contains(url)){

                getListingUnosi().add(new ListingUnos(url,megabajti));
            }
            else {
                if(megabajti>getTarifniPaket().getMegabajti()){
                prekoracenje=(megabajti-getTarifniPaket().getMegabajti())*getTarifniPaket().getCenaPoMegabajtu();

                    getListingUnosi().add(new ListingUnos(url,megabajti));}
                    else {
                    getTarifniPaket().setMegabajti(getTarifniPaket().getMegabajti()-megabajti);

                    getListingUnosi().add(new ListingUnos(url,megabajti));


                }
            }
        }


        return true;
    }
    @Override
    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak){
        if(getTarifniPaket().isNeogranicenSaobracaj() == false )
            getTarifniDodataci().add(tarifniDodatak);
            else {
            if (tarifniDodatak.equals(TipDodatka.FIKSNA_TELEFONIJA) || tarifniDodatak.equals(TipDodatka.IPTV))
                getTarifniDodataci().add(tarifniDodatak);
            else {
                System.out.println("vec imate neogranicen internet");
            }
        }


    }

    public double getPrekoracenje() {
        return prekoracenje;
    }
        public  String generisiRacun(){
            String racun=getPrekoracenje()+" "+ukupnoZaNaplatu()+" "+getIme()+" "+getPrezime()+" "+getBrojUgovora()+" "+getTarifniPaket().getCenaPaketa()+" "+getTarifniDodataci();
        return racun;
    }

    @Override
    public String toString() {
        return "PostpaidKorisnik{" +
                "prekoracenje=" + prekoracenje +
                '}';
    }
}
