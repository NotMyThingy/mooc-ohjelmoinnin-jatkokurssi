import java.util.Objects;

public class Paivays {

    private final int paiva;
    private final int kuukausi;
    private final int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        return this.vuosi == verrattava.vuosi
                && this.kuukausi == verrattava.kuukausi
                && this.paiva < verrattava.paiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paivays paivays = (Paivays) o;
        return paiva == paivays.paiva &&
                kuukausi == paivays.kuukausi &&
                vuosi == paivays.vuosi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paiva, kuukausi, vuosi);
    }
}
