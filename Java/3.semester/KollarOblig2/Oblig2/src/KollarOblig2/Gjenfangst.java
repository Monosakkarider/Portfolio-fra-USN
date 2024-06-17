package KollarOblig2;

import java.util.ArrayList;

public class Gjenfangst implements Comparable<Gjenfangst>{
    //Felles variabler for dyrenes gjenfangst
    private String ID;
    private Float nyLengde;
    private Float nyVekt;
    private String nyDato;
    private String nyttSted;

    //Konstruktører
    public Gjenfangst(String ID, Float nyLengde, Float nyVekt, String nyDato, String nyttSted) {
        this.ID = ID;
        this.nyLengde = nyLengde;
        this.nyVekt = nyVekt;
        this.nyDato = nyDato;
        this.nyttSted = nyttSted;
    }

    //Gettere og settere
    public String getID() {
        return ID;
    }
/*
    public void setID(String ID) {
        this.ID = ID;
    }

    public Float getNyLengde() {
        return nyLengde;
    }

    public void setNyLengde(Float nyLengde) {
        this.nyLengde = nyLengde;
    }

    public Float getNyVekt() {
        return nyVekt;
    }

    public void setNyVekt(Float nyVekt) {
        this.nyVekt = nyVekt;
    }

    public String getNyDato() {
        return nyDato;
    }

    public void setNyDato(String nyDato) {
        this.nyDato = nyDato;
    }

    public String getNyttSted() {
        return nyttSted;
    }

    public void setNyttSted(String nyttSted) {
        this.nyttSted = nyttSted;
    }*/

    //toString
    @Override
    public String toString() {
        return "ID: "+ ID +
                ", Lengde: "+ nyLengde +" cm"+
                ", Vekt: "+ nyVekt +" kg"+
                ", Dato: "+ nyDato +
                ", Sted: "+ nyttSted;
    }

    //Metode for compareTo og equals
    public int compareTo(Gjenfangst annenGjenfangst) {
        return this.ID.compareTo(annenGjenfangst.getID());
    }

    public boolean equals(Gjenfangst annenGjenfangst) {
        return this.ID.equals(annenGjenfangst.getID());
    }

}
