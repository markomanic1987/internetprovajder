package com.projekat1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) {
       SpringApplication.run(DemoApplication.class, args);
        InternetProvajder ip = new InternetProvajder("sbb");
        PostpaidKorisnik pk=new PostpaidKorisnik("marko","Manic","mb","223",ip,new TarifniPaket(12,200,false,200,50));

        ip.dodajKorisnika(pk);
        PrepaidKorisnik ppkk = new PrepaidKorisnik("ivan","jak","2311","443",ip,new TarifniPaket(5,55,false,100,4));
        ip.dodajKorisnika(ppkk);

        PostpaidKorisnik ppk;
        ppk = new PostpaidKorisnik("marko","manic","221","223",ip,new TarifniPaket(10,1000,false,100,5));
        ip.dodajKorisnika(ppk);
        ip.prikazPostpaidKorisnika();
        ip.prikazPrepaidKorisnika();
        ip.generisiRacune();
        pk.surfuj("instagram",200);
        pk.surfuj("facebook",100);
        pk.surfuj("twiter",300);



        System.out.println(ip.prikaziSveKorisnike());
    }



}
