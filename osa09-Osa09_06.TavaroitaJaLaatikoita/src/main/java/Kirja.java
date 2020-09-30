public class Kirja implements Talletettava {

    private final String kirjoittaja;
    private final String nimi;
    private final double paino;

    public Kirja(String kirjoittaja, String nimi, double paino) {
        this.nimi = nimi;
        this.kirjoittaja = kirjoittaja;
        this.paino = paino;
    }

    @Override
    public double paino() {
        return paino;
    }

    @Override
    public String toString() {
        return kirjoittaja + ": " + nimi;
    }
}
