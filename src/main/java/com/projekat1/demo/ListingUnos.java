package com.projekat1.demo;

public class ListingUnos implements Comparable<ListingUnos> {
    private String url;
    private int megabajti;

    public void dodajMegabajte(int megabajti){
        this.megabajti=this.megabajti+megabajti;
    }



    @Override
    public int compareTo(ListingUnos o) {
        if(o.megabajti==megabajti)
            return 0;
        if (o.megabajti>megabajti)
            return -1;
        return 1;
    }



    public ListingUnos(String url, int megabajti) {
        this.url = url;
        this.megabajti = megabajti;
    }

    public String getUrl() {
        return url;
    }

    public int getMegabajti() {

        return megabajti;
    }

    @Override
    public String toString() {
        return "ListingUnos{" +
                "url='" + url + '\'' +
                ", megabajti=" + megabajti +
                '}';
    }
}
