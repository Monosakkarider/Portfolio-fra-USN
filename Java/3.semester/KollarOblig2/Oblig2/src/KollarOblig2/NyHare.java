package KollarOblig2;

public class NyHare extends Gjenfangst{
    //Egen variabel for gjenfangst av hare
    private String nyPels;

    //Konstruktør
    public NyHare(String ID, Float nyLengde, Float nyVekt, String nyDato, String nyttSted, String nyPels) {
        super(ID, nyLengde, nyVekt, nyDato, nyttSted);
        this.nyPels = nyPels;
    }

    //Getter og setter
    public String getNyPels() {
        return nyPels;
    }

    public void setNyPels(String nyPels) {
        this.nyPels = nyPels;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() +", Pels: "+ nyPels +"\n";

    }
}
