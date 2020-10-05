import java.util.Objects;

public class Tavara {

    private String nimi;
    private int paino;

    public Tavara(String nimi, int paino) {
        this.nimi = nimi;
        this.paino = paino;
    }

    public Tavara(String nimi) {
        this(nimi, 0);
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tavara tavara = (Tavara) o;
        return nimi.equals(tavara.nimi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nimi);
    }
}
