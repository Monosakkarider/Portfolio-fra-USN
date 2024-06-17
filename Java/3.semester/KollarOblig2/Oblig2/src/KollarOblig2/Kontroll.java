package KollarOblig2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Kontroll {
    //Oppretter lister for dyrene
    private ArrayList<Gaupe> gauper = new ArrayList<>();
    private ArrayList<Hare> harer = new ArrayList<>();
    private ArrayList<NyGaupe> nyeGauper = new ArrayList<>();
    private ArrayList<NyHare> nyeHarer = new ArrayList<>();

    //Funksjon som autogenererer ID og registrerer fangst av gaupe:
    public void regGaupe(String kjonn, Float lengde, Float vekt, String dato, String sted, Float tuss) {
        String id = "G" +(gauper.size() + 1);
        gauper.add(new Gaupe(id,kjonn,lengde,vekt,dato,sted,tuss));
        //ALT OK
    }

    //Funksjon som autogenererer ID og registrerer fangst av hare:
    public void regHare(String kjonn, Float lengde, Float vekt, String dato, String sted, String type, String pels) {
        String id = "H" +(harer.size() + 1);
        harer.add(new Hare(id,kjonn,lengde,vekt,type,pels,dato,sted));
        //ALT OK
    }
    //Funksjon for registrering av gaupe-gjenfangst
    public void regGjenGaupe(String ID, Float lengde, Float vekt, String dato, String sted, Float tuss) {
        nyeGauper.add(new NyGaupe(ID,lengde,vekt,dato,sted,tuss));

    }

    //Funksjon som registrerer gjenfangst av gaupe:
    /*
    public void regGjenGaupe(String ID, Float lengde, Float vekt, String dato, String sted, Float tuss) {
        for (Gaupe gaupe : gauper) {
            if (gaupe.getID().equals(ID)) {
                gaupe.getGjenGaupe().add(new NyGaupe(ID,lengde,vekt,dato,sted,tuss));
            }
        }
        //ALT OK
    }*/

    //Funksjon som registrerer gjenfangst av hare:
    public void regGjenHare(String ID, Float lengde, Float vekt, String dato, String sted, String pels) {
            nyeHarer.add(new NyHare(ID,lengde,vekt,dato,sted,pels));
        //ALT OK
    }

    //Funksjon som sorterer gaupelista binært:
    public Gaupe finnGaupeBinaert(String ID) {
        Collections.sort(gauper);
        Gaupe dummy = new Gaupe(ID,null,null,null,null,null,null);
        int indeks = Collections.binarySearch(gauper, dummy);
        if (indeks>=0) return gauper.get(indeks);
        else return null;
        //ALT OK
    }

    //Funksjon som sorterer harelista binært:
    public Hare finnHareBinaert(String ID) {
        Collections.sort(harer);
        Hare dummy = new Hare(ID,null,null,null,null,null,null,null);
        int indeks = Collections.binarySearch(harer, dummy);
        if (indeks>=0) return harer.get(indeks);
        else return null;
        //ALT OK
    }

    //Funksjon som sorterer gaupe-gjenfangst-lista linjært
    public String finnGjenGaupeLinjaert(String ID) {
        Boolean funnetGaupe = false;
        String gaupeListe = "";
        for (int i = 0; i< nyeGauper.size(); i++) {
            NyGaupe id = nyeGauper.get(i);
            if (id.getID().equals(ID)) {
                funnetGaupe = true;
                gaupeListe += nyeGauper.get(i);
            }
        }
        if (funnetGaupe.equals(true)) return gaupeListe;
        else return null;
    }

    //Funksjon som sorterer gjenfangstlista til gaupe linjært:
    /*
    public String finnGjenGaupeLinjaert(String ID) {
        Boolean funnet = true;
        String gaupeliste ="";
        for (Gaupe gaupe : gauper) {
            if (gaupe.getID().equals(ID)) {
                ArrayList<NyGaupe> nyeGauper = gaupe.getGjenGaupe();
                for (int i = 0; i<nyeGauper.size(); i++) {
                    NyGaupe id = nyeGauper.get(i);
                    if (id.getID().equals(ID)) {
                        funnet = true;
                        gaupeliste+=nyeGauper.get(i);
                    }
                }
            }
        }
        if (funnet.equals(true)) return gaupeliste;
        else return null;
    }*/

    //IKKE OK, JOBB VIDERE
    /*
    public String finnGjenGaupeLinjaert(String ID) {
        for (Gaupe gaupe : gauper) {
            if (gaupe.getID().equals(ID)) {
                ArrayList<NyGaupe> nyeGauper = gaupe.getGjenGaupe();
            }
            Boolean funnetGaupe = false;
            String gaupeListe = "";
            for (int i = 0; i< gaupe.getGjenGaupe().size(); i++) {
                NyGaupe id = gaupe.getGjenGaupe().get(i);
                if (id.getID().equals(ID)) {
                    funnetGaupe = true;
                    gaupeListe += gaupe.getGjenGaupe().get(i);
                }
            }
            if (funnetGaupe.equals(true)) return gaupeListe;
            else return null;
        }
        return null;
    }*/

    //Funskjon som sorterer gjenfangstlista til hare linjært:
    public String finnGjenHareLinjaert(String ID) {
        Boolean funnetHare = false;
        String hareListe = "";
        for (int i = 0; i< nyeHarer.size(); i++) {
            NyHare id = nyeHarer.get(i);
            if (id.getID().equals(ID)) {
                funnetHare = true;
                hareListe += nyeHarer.get(i);
            }
        }
        if (funnetHare.equals(true)) return hareListe;
        else return null;
    }

    //Gettere for alle lister
    public ArrayList<Gaupe> getGauper() {
        return gauper;
    }
    public ArrayList<Hare> getHarer() {
        return harer;
    }

    public ArrayList<NyGaupe> getNyeGauper() {
        return nyeGauper;
    }

    public ArrayList<NyHare> getNyeHarer() {
        return nyeHarer;
    }
}
