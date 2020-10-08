public class Koira extends Elain implements Aanteleva {

    public Koira() {
        this("Koira");
    }

    public Koira(String nimi) {
        super(nimi);
    }

    public void hauku() {
        System.out.println(getNimi() + " haukkuu");
    }

    @Override
    public void aantele() {
        hauku();
    }
}
