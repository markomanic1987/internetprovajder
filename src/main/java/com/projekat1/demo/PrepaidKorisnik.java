package com.projekat1.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrepaidKorisnik extends Korisnik {
   private double kredit;


    public PrepaidKorisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket) {
        super(ime, prezime, adresa, brojUgovora, internetProvajder, tarifniPaket);
    }
    public void doupuniKredit(double kredit){
        this.kredit=this.kredit+kredit;
    }
    @Override
    public boolean surfuj(String url,int megabajti){


            if(getTarifniDodataci().contains(url)){
                getListingUnosi().add(new ListingUnos(url, megabajti));

            } else {
                if(kredit>megabajti*getTarifniPaket().getCenaPoMegabajtu()){
                    kredit=kredit-(getTarifniPaket().getCenaPoMegabajtu());

                    getListingUnosi().add(new ListingUnos(url,megabajti));
                       }
                    else
                        System.out.println("nemate dovoljno kredita za surf");
                        return false;

                }


        return true;
    }
    @Override
    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak){
        if (kredit > tarifniDodatak.getCenaDodatka() && !tarifniDodatak.equals(TipDodatka.FIKSNA_TELEFONIJA) && !tarifniDodatak.equals(TipDodatka.IPTV)) {
            getTarifniDodataci().add(tarifniDodatak);
        } else
            System.out.println("nemate dovoljno kredita za paket ili paket koji ste izabrali je nemoguce dodati");

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



