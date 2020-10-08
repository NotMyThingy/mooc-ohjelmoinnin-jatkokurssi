public abstract class Elain {

    private String nimi;

    public Elain(String nimi) {
        this.nimi = nimi;
    }

    public void syo() {
        System.out.printf(nimi + " syo");
    }

    public void nuku() {
        System.out.println(nimi + " nukkuu");
    }

    public String getNimi() {
        return nimi;
    }
}
