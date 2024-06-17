package KollarOblig2;


public class Gaupe extends Dyr{
    //Egen variabel for dyret gaupe
    private Float tusseLengde;
    //private ArrayList<NyGaupe> gjenGaupe = new ArrayList<>();

    //Konstruktør
    public Gaupe(String ID, String kjonn, Float lende, Float vekt, String dato, String sted, Float tusseLengde) {
        super(ID, kjonn, lende, vekt, dato, sted);
        this.tusseLengde = tusseLengde;
        //this.gjenGaupe = gjenGaupe;
    }

    //Gettere og settere
    public Float getTusseLengde() {
        return tusseLengde;
    }

    public void setTusseLengde(Float tusseLengde) {
        this.tusseLengde = tusseLengde;
    }

    /*public ArrayList<NyGaupe> getGjenGaupe() {
        return gjenGaupe;
    }

    public void setGjenGaupe(ArrayList<NyGaupe> gjenGaupe) {
        this.gjenGaupe = gjenGaupe;
    }*/

    //toString
    @Override
    public String toString() {
        return super.toString() +", Tusselengde: "+ tusseLengde +" cm"; //+ "\n" + "Gjenfangst:"+ "\n" + gjenGaupe;
    }
}
