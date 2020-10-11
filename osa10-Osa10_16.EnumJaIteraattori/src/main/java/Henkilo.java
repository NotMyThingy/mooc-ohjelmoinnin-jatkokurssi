import java.util.Objects;

public class Henkilo {

    private final String nimi;
    private final Koulutus koulutus;

    public Henkilo(String nimi, Koulutus koulutus) {
        this.nimi = nimi;
        this.koulutus = koulutus;
    }

    public Koulutus getKoulutus() {
        return koulutus;
    }

    @Override
    public String toString() {
        return nimi + ", " + koulutus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Henkilo henkilo = (Henkilo) o;
        return nimi.equals(henkilo.nimi) &&
                koulutus == henkilo.koulutus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nimi, koulutus);
    }
}
