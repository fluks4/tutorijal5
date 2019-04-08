package sample;

import java.util.ArrayList;

public class Artikal {
    private String sifra, naziv;
    private double cijena;

    public Artikal () {}

    public Artikal (String s){

        String[] niz = s.split(",");

        if(niz[0].equals("") || niz[1].equals("") || Double.parseDouble(niz[2]) <= 0)
            throw new IllegalArgumentException("Neispravni podaci");
        sifra = niz[0];
        naziv = niz[1];
        cijena = Double.parseDouble(niz[2]);
    }

    public void setSifra(String sifra) {
        if(sifra.equals(""))
            throw new IllegalArgumentException("Neispravni podaci");

        this.sifra = sifra;
    }

    public void setNaziv(String naziv) {
        if(naziv.equals(""))
            throw new IllegalArgumentException("Neispravni podaci");
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        if(cijena <= 0)
            throw new IllegalArgumentException("Neispravni podaci");

        this.cijena = cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    @Override
    public String toString() {
        return  sifra + "," + naziv + "," + cijena;
    }

    public boolean equals(Object o){
        Artikal artikal = (Artikal)o;

        if(!naziv.equals(artikal.getNaziv()) || !sifra.equals(artikal.getSifra()) || Double.compare(cijena, artikal.getCijena())!=0)
            return false;

        return true;

    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli){

        for(int i = 0; i < artikli.size(); i++){

            for(int j = i + 1; j < artikli.size(); j++){

                if(artikli.get(i).equals(artikli.get(j))){
                    artikli.remove(j);
                }
            }
        }
        return artikli;
    }

}