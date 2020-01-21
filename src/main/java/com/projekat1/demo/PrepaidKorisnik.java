package com.projekat1.demo;

import javax.persistence.Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
@Entity
public class PrepaidKorisnik extends Korisnik {
   private double kredit;

    public void setKredit(double kredit) {
        this.kredit = kredit;
    }

    public PrepaidKorisnik(String ime, String prezime, String adresa, String brojUgovora, InternetProvajder internetProvajder, TarifniPaket tarifniPaket) {
        super(ime, prezime, adresa, brojUgovora, internetProvajder, tarifniPaket);
    }
    public PrepaidKorisnik(){

    }
    public void doupuniKredit(double kredit){
        this.kredit=this.kredit+kredit;
    }
    @Override
    public boolean surfuj(String url,int megabajti){
            boolean check = false;

            if(getTarifniDodataci().contains(url)){
                getListingUnosi().add(new ListingUnos(url, megabajti));
                    check=true;
            } else {
                if(kredit>megabajti*getTarifniPaket().getCenaPoMegabajtu()){
                    kredit=kredit-(getTarifniPaket().getCenaPoMegabajtu());

                    getListingUnosi().add(new ListingUnos(url,megabajti));
                    check= true;
                       }
                    else
                        System.out.println("nemate dovoljno kredita za surf");
                        check= false;

                }


        return check;
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
        return getIme()+ " "+getBrojUgovora()+" "+kredit;
    }
}



