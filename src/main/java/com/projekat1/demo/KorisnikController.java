package com.projekat1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikServiceservice;

    @RequestMapping("/korisnici")
    private ArrayList<Korisnik> vidiKorisnike(){
        return korisnikServiceservice.vidiSve();
    }
        @RequestMapping("/korisnici/{brojUgovora}")
        public Korisnik getKorisnike(@PathVariable String brojUgovora){
        return korisnikServiceservice.vidiKorsnika(brojUgovora);
        }
        @RequestMapping(method = RequestMethod.POST,value="/korisnici")
        public void dodajKorisnika(@RequestBody Korisnik korisnik){

        korisnikServiceservice.dodajKorisnika(korisnik);
        }
        @RequestMapping(method = RequestMethod.PUT,value = "/korisnici/{brojUgovora}")
        public void updateKorisnik(@RequestBody Korisnik korisnik,@PathVariable String brojUgovora){
        korisnikServiceservice.azurirajKorisnka(brojUgovora,korisnik);
        }
        @RequestMapping(method = RequestMethod.DELETE,value = "/korisnici/{brojUgovora}")
        public void izbrisiKorisnika(@PathVariable String brojUgovora){
        korisnikServiceservice.izbrisiKorisnika(brojUgovora);
        }



    @RequestMapping("/hello")
    public String hi(){
        return "hi";
    }
}
