package KollarOblig2;

public class Dyr implements Comparable<Dyr>{
    //Oppretter felles variabler for dyrene
    private String ID;
    private String kjonn;
    private Float lengde;
    private Float vekt;
    private String dato;
    private String sted;

    //Oppretter konstruktørene
    public Dyr(String ID, String kjonn, Float lengde, Float vekt, String dato, String sted) {
        this.ID = ID;
        this.kjonn = kjonn;
        this.lengde = lengde;
        this.vekt = vekt;
        this.dato = dato;
        this.sted = sted;
    }

    //Gettere og settere
    public String getID() {
        return ID;
    }

    /*public void setID(String ID) {
        this.ID = ID;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public Float getLengde() {
        return lengde;
    }

    public void setLengde(Float lende) {
        this.lengde = lengde;
    }

    public Float getVekt() {
        return vekt;
    }

    public void setVekt(Float vekt) {
        this.vekt = vekt;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }*/

    //Oppretter toString-metode
    @Override
    public String toString() {
        return  "ID: "+ ID +
                ", Kjønn: "+ kjonn +
                ", Lengde: "+ lengde +" cm"+
                ", Vekt: "+ vekt +" kg"+
                ", Dato: "+ dato +
                ", Sted: " + sted;
    }

    //Oppretter compareTo og equals metoder
    public int compareTo(Dyr annetDyr) {
        return this.ID.compareTo(annetDyr.getID());
    }

    public boolean equals(Dyr annetDyr) {
        return this.ID.equals(annetDyr.getID());
    }
}
