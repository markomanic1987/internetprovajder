package com.projekat1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    private ArrayList<Korisnik> korisnici=new ArrayList<>(Arrays.asList(
            new PostpaidKorisnik("Marko","Manic","MB","112",new InternetProvajder("sbb"),new TarifniPaket(200,100,true,1000,2)),
            new PrepaidKorisnik("Janko","Man","MB1","113",new InternetProvajder("sbb"),new TarifniPaket(250,1000,false,100,5)),
            new PostpaidKorisnik("Petar","Manic","MB2","114",new InternetProvajder("sbb"),new TarifniPaket(300,1200,true,1000,1))

    ));
    public ArrayList<Korisnik> vidiSve(){
        return korisnici;

    }
    public Korisnik vidiKorsnika(String brojUgovora){
        return korisnici.stream().filter(t -> t.getBrojUgovora().equals(brojUgovora)).findFirst().get();

    }
    public void dodajKorisnika(Korisnik korisnik){

        korisnici.add(korisnik);
    }
    public void azurirajKorisnka(String brojUgovora,Korisnik korisnik){
        for(int i =0; i<korisnici.size();i++){
            Korisnik k = korisnici.get(i);
            if(k.getBrojUgovora().equals(brojUgovora)){
                korisnici.set(i,korisnik);
                return;
            }
        }
    }
    public void izbrisiKorisnika(String brojUgovora){
        korisnici.removeIf(t -> t.getBrojUgovora().equals(brojUgovora));
    }
}
