public abstract class Elain {

    private final String nimi;

    public Elain(String nimi) {
        this.nimi = nimi;
    }

    public void syo() {
        System.out.println(nimi + " syo");
    }

    public void nuku() {
        System.out.println(nimi + " nukkuu");
    }

    public String getNimi() {
        return nimi;
    }
}
