
public class Kirja {

    private final String nimi;
    private final int julkaisuvuosi;
    private final int sivuja;
    private final String kirjoittaja;

    public Kirja(String nimi, int julkaisuvuosi, int sivuja, String kirjoittaja) {
        this.nimi = nimi;
        this.julkaisuvuosi = julkaisuvuosi;
        this.sivuja = sivuja;
        this.kirjoittaja = kirjoittaja;
    }

    public String getNimi() {
        return nimi;
    }

    public int getJulkaisuvuosi() {
        return julkaisuvuosi;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public int getSivuja() {
        return sivuja;
    }

    @Override
    public String toString() {
        return "Kirja{" +
                "nimi='" + nimi + '\'' +
                ", julkaisuvuosi=" + julkaisuvuosi +
                ", sivuja=" + sivuja +
                ", kirjoittaja='" + kirjoittaja + '\'' +
                '}';
    }
}
