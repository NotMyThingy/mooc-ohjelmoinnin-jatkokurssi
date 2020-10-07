public class Ostos {

    private final String tuote;
    private int kpl;
    private final int yksikkohinta;

    public Ostos(String tuote, int kpl, int yksikkohinta) {
        this.tuote = tuote;
        this.kpl = kpl;
        this.yksikkohinta = yksikkohinta;
    }

    public int hinta() {
        return yksikkohinta * kpl;
    }

    public void kasvataMaaraa() {
        kpl += 1;
    }

    public String toString() {
        return tuote + ": " + kpl;
    }
}
