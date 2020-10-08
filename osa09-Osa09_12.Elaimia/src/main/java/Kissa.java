public class Kissa extends Elain implements Aanteleva {

    public Kissa() {
        this("Kissa");
    }

    public Kissa(String nimi) {
        super(nimi);
    }

    public void mourua() {
        System.out.println(getNimi() + " mouruaa");
    }

    @Override
    public void aantele() {
        mourua();
    }
}
