package KollarOblig2;

import javax.swing.*;
import java.util.ArrayList;

public class Grensesnitt {

    Kontroll kontroll = new Kontroll();

    // En Array med menyknapper
    private static final String[] HOVEDMENY = {"Registrer gaupe","Registrer hare","Registrer gaupegjenfangst","Registrer haregjenfangst","Finn dyr","List ut dyr","Dyr med fangst","Avslutt"};

    //Funksjonen som skriver ut hovedmenyen og leser menyvalg:
    public int lesValg() {
        int valg = JOptionPane.showOptionDialog(null,"Velg hva som skal gjøres","Registrering av dyr",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,HOVEDMENY,HOVEDMENY[0]);
        return valg;
    }

    //Funksjon som ber brukeren oppgi data som skal settes i gaupe-lista
    public void lesGaupe() {
        String kjonn = JOptionPane.showInputDialog("Oppgi kjønn").toUpperCase();
        Float lengde = Float.parseFloat(JOptionPane.showInputDialog("Oppgi lende"));
        Float vekt = Float.parseFloat(JOptionPane.showInputDialog("Oppgi vekt"));
        Float tuss = Float.parseFloat(JOptionPane.showInputDialog("Oppgi tuss"));
        String dato = JOptionPane.showInputDialog("Oppgi dato");
        String sted = JOptionPane.showInputDialog("Oppgi sted").toUpperCase();
        kontroll.regGaupe(kjonn,lengde,vekt,dato,sted,tuss);
    }

    //Funksjon som ber brukeren oppgi data som skal settes i hare-lista
    public void lesHare() {
        String kjonn = JOptionPane.showInputDialog("Oppgi kjønn").toUpperCase();
        Float lengde = Float.parseFloat(JOptionPane.showInputDialog("Oppgi lende"));
        Float vekt = Float.parseFloat(JOptionPane.showInputDialog("Oppgi vekt"));
        String type = JOptionPane.showInputDialog("Oppgi type").toUpperCase();
        String pels= JOptionPane.showInputDialog("Oppgi pels").toUpperCase();
        String dato = JOptionPane.showInputDialog("Oppgi dato");
        String sted = JOptionPane.showInputDialog("Oppgi sted").toUpperCase();
        kontroll.regHare(kjonn,lengde,vekt,dato,sted,type,pels);
    }

    //Funksjon som ber brukeren oppgi data som skal settes i gaupe-gjenfangst-lista
    //Sjekker også om dyret finnes fra før.
    public void lesGjenfangstGaupe() {
        String id = JOptionPane.showInputDialog("Oppgi id").toUpperCase();
        Gaupe gaupe = kontroll.finnGaupeBinaert(id);
        if (gaupe != null) {
            Float lengde = Float.parseFloat(JOptionPane.showInputDialog("Oppgi lengde"));
            Float vekt = Float.parseFloat(JOptionPane.showInputDialog("Oppgi vekt"));
            Float tuss = Float.parseFloat(JOptionPane.showInputDialog("Oppgi tusselengde"));
            String dato = JOptionPane.showInputDialog("Oppgi dato");
            String sted = JOptionPane.showInputDialog("Oppgi sted").toUpperCase();
            kontroll.regGjenGaupe(id, lengde, vekt, dato, sted, tuss);
        }else JOptionPane.showMessageDialog(null, "Finner ikke gaupen med denne ID'en");
    }

    //Funksjon som ber brukeren oppgi data som skal settes i hare-gjenfangst-lista
    //Sjekker også om dyret finnes fra før.
    public void lesGjenfangstHare() {
        String id = JOptionPane.showInputDialog("Oppgi id").toUpperCase();
        Hare hare = kontroll.finnHareBinaert(id);
        if (hare != null) {
            Float lengde = Float.parseFloat(JOptionPane.showInputDialog("Oppgi lende"));
            Float vekt = Float.parseFloat(JOptionPane.showInputDialog("Oppgi vekt"));
            String pels= JOptionPane.showInputDialog("Oppgi pels").toUpperCase();
            String dato = JOptionPane.showInputDialog("Oppgi dato");
            String sted = JOptionPane.showInputDialog("Oppgi sted").toUpperCase();
            kontroll.regGjenHare(id, lengde, vekt, dato, sted, pels);
        } else JOptionPane.showMessageDialog(null,"Finner ikke haren med denne ID'en");
    }

    //Funksjon der man oppgir dyrets ID, og programmes skriver ut dyrets data og gjenfangst-data
    public void lesFinnDyr() {
        String id = JOptionPane.showInputDialog("Oppgi ID").toUpperCase();
        Gaupe gaupe= kontroll.finnGaupeBinaert(id);
        String gaupe1 = kontroll.finnGjenGaupeLinjaert(id);
        Hare hare = kontroll.finnHareBinaert(id);
        String hare1 = kontroll.finnGjenHareLinjaert(id);

        if (gaupe !=null) System.out.println("Første registrering av gaupe:"+"\n"+gaupe.toString());

        if (gaupe1 !=null) System.out.println("Gjenfangst data for gaupe:"+"\n"+gaupe1.toString());

        if (hare !=null) System.out.println("Første registrering av hare:"+"\n"+hare.toString());

        if (hare1 !=null) System.out.println("Gjenfangst data for hare:"+"\n"+hare1.toString());
    }

    //ALTERNATIV 2:
    /*
    public void lesListDyr(String ID) {
        Boolean funnet = false;
        Boolean gjenfangst = false;
        ArrayList<Hare> harer = kontroll.getHarer();
        ArrayList<NyHare> gjenHarer = kontroll.getNyeHarer();
        String tekst = "";
        String tekst1 = "";
        for (Hare h : harer) {
            if (h.getID().equals(ID)) {
                tekst+= h.toString();
                funnet = true;
                for (NyHare nh : gjenHarer) {
                    if (nh.getID().equals(ID)) {
                        tekst1+= nh.toString() + "\n";
                        gjenfangst = true;
                    }
                }
            }
        }
        if (funnet.equals(true) && gjenfangst.equals(true)) {
            System.out.println(tekst + "\n" + tekst1);
        }else System.out.println("nei");

    }*/

    //IKKE OK, JOBB VIDERE
    //ALTERNATIV 1:
    /*
    public void lesListDyr() {
        ArrayList<Hare> harer = kontroll.getHarer();
        ArrayList<NyHare> nyeHarer = kontroll.getNyeHarer();
        String tekst ="";
        String tekst1 ="";
        for (Hare h : harer) {
            tekst+= h.toString() + "\n";
            for (NyHare nh: nyeHarer) {
                tekst1+= nh.toString();
            }
        }
        System.out.println("Første reg:" + "\n" + tekst + "Gjenfangst:" + "\n" + tekst1);
    }*/

    //Funskjon som skriver ut informasjon om alle dyr med gjenfangst-data
    public void lesListDyr() {
        ArrayList<Gaupe> gauper = kontroll.getGauper();
        ArrayList<NyGaupe> nyeGauper = kontroll.getNyeGauper();
        ArrayList<Hare> harer = kontroll.getHarer();
        ArrayList<NyHare> nyeHarer = kontroll.getNyeHarer();
        String gaupe = "";
        String gaupe1 = "";
        String hare = "";
        String hare1 = "";
        for (Gaupe g : gauper) {
            gaupe+= g.toString() + "\n";
        }
        for (NyGaupe ng : nyeGauper) {
            gaupe1+= ng.toString();
        }
        for (Hare h : harer) {
            hare+= h.toString() + "\n";
        }
        for (NyHare nh : nyeHarer) {
            hare1+= nh.toString();
        }
        System.out.println("Første registrering av gaupe:" + "\n" + gaupe + "Gjenfangst:" + "\n" + gaupe1 + "\n" +
                "Første registrering av hare:" + "\n" + hare + "Gjenfangst:" + "\n" + hare1);
    }


    //Funksjon som skriver ut alle gjenfangster til forskjellige dyr
    public void lesDyrMedFangst() {
       ArrayList<NyGaupe> gaupeGjenfangst = kontroll.getNyeGauper();
       ArrayList<NyHare> hareGjenfangst = kontroll.getNyeHarer();
       String utGjenGaupe = "";
       String utGjenHare = "";
       for (NyGaupe nyGaupe : gaupeGjenfangst) {
           utGjenGaupe+=nyGaupe.toString();
       }
       for (NyHare nyHare : hareGjenfangst) {
           utGjenHare+=nyHare.toString();
       }
       if (utGjenGaupe.isEmpty()) System.out.println("Ingen gjenfangstdata registrert for Gaupe");
        else System.out.println("Gjenfangstdata for Gaupe:"+"\n"+utGjenGaupe);
        if (utGjenHare.isEmpty()) System.out.println("Ingen gjenfangstdata for Hare");
        else System.out.println("Gjenfangstdata for Hare:"+"\n"+utGjenHare);
    }

    //Funksjon som kjører menyen så lenge bruker ønsker
    public void start() {

        boolean fortsett = true;

        while (fortsett) {
            int valg = lesValg();

            switch (valg) {
                case 0 :
                    lesGaupe();
                    break;
                case 1 :
                    lesHare();
                    break;
                case 2 :
                    lesGjenfangstGaupe();
                    break;
                case 3 :
                    lesGjenfangstHare();
                    break;
                case 4 :
                    lesFinnDyr();
                    break;
                case 5 :
                    lesListDyr();
                    break;
                case 6 :
                    lesDyrMedFangst();
                    break;
                default: fortsett = false;
            }
        }
    }
}
