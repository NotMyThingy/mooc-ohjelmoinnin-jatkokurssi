import java.util.Objects;

public class Kirja {

    private final String nimi;
    private final int minkohdeika;

    public Kirja(String nimi, int minkohdeika) {
        this.nimi = nimi;
        this.minkohdeika = minkohdeika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getMinkohdeika() {
        return minkohdeika;
    }

    @Override
    public String toString() {
        return nimi + " (" + minkohdeika + " vuotiaille ja vanhemmille)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kirja kirja = (Kirja) o;
        return minkohdeika == kirja.minkohdeika &&
                nimi.equals(kirja.nimi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nimi, minkohdeika);
    }
}
