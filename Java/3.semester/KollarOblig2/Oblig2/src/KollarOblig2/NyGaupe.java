package KollarOblig2;

public class NyGaupe extends Gjenfangst{
    //Egen variabel for gjenfangst av gaupe
    private Float nyTusselengde;

    //Konstruktør
    public NyGaupe(String ID, Float nyLengde, Float nyVekt, String nyDato, String nyttSted, Float nyTusselengde) {
        super(ID, nyLengde, nyVekt, nyDato, nyttSted);
        this.nyTusselengde = nyTusselengde;
    }

    //Getter og setter
    public Float getNyTusselengde() {
        return nyTusselengde;
    }

    public void setNyTusselengde(Float nyTusselengde) {
        this.nyTusselengde = nyTusselengde;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() +", Tusselengde: "+ nyTusselengde +" cm"+ "\n";
    }

}
