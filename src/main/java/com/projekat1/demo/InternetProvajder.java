package com.projekat1.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class InternetProvajder {
    private String imeProvajdera;
    private ArrayList<Korisnik> korisnici;


    public void generisiRacune(){
        for(Korisnik k :korisnici) {
            if (k instanceof PostpaidKorisnik) {
                System.out.println(((PostpaidKorisnik) k).generisiRacun());
            }
        }
    }
    public void zabeleziSaobracaj(Korisnik korisnik,String url,int mb){
            File f = new File("log.txt");
        try {
            PrintWriter pw = new PrintWriter(f);
            if(korisnik.surfuj(url,mb)==true){
            pw.print(korisnik.getBrojUgovora()+" "+korisnik.surfuj(url,mb)+" "+url+" "+mb+" \n");
            pw.close(); } else
            System.out.println("nema dovoljno megabajta");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }



    public void prikazPrepaidKorisnika(){
        for(Korisnik k : korisnici){
            if(k instanceof PrepaidKorisnik){
                System.out.println(k.getIme());
                System.out.println(k.getPrezime());
                System.out.println(k.getAdresa());
                System.out.println(k.getBrojUgovora());
                System.out.println(k.getInternetProvajder().getImeProvajdera());
                System.out.println(k.getTarifniPaket().toString());
            }
        }
    }
    public void prikazPostpaidKorisnika(){
        for(Korisnik k :korisnici){
            if(k instanceof  PostpaidKorisnik){
                System.out.println(k.getIme());
                System.out.println(k.getPrezime());
                System.out.println(k.getAdresa());
                System.out.println(k.getBrojUgovora());
                System.out.println(k.getInternetProvajder().getImeProvajdera());
                System.out.println(k.getTarifniPaket().toString());

            }
        }


    }
    public void dodajKorisnika(Korisnik korisnik){
        korisnici.add(korisnik);
       /* for (Korisnik k :korisnici){
            if(k.getBrojUgovora().equals(korisnik.getBrojUgovora())){
                System.out.println("vec postoji takav broj ugovora");
            } else
                korisnici.add(korisnik);
        }nece da radi ne znam zasto */


        }
        public InternetProvajder(String imeProvajdera) {
        this.imeProvajdera = imeProvajdera;
        this.korisnici= new ArrayList<>();
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

