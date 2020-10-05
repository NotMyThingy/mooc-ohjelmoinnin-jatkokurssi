public class Opiskelija extends Henkilo {

    private int opintopisteet;

    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
        this.opintopisteet = 0;
    }

    public void opiskele() {
        opintopisteet += 1;
    }

    public int opintopisteita() {
        return opintopisteet;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  " +
                "opintopisteitä " + opintopisteet;
    }
}
