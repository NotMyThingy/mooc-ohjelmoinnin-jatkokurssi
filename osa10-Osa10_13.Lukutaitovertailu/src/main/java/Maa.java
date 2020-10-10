public class Maa implements Comparable<Maa> {

    private final String sukupuoli;
    private final String maa;
    private final int vuosi;
    private final double lukutaitoprosentti;

    public Maa(String sukupuoli, String maa, int vuosi, double lukutaitoprosentti) {
        this.sukupuoli = sukupuoli;
        this.maa = maa;
        this.vuosi = vuosi;
        this.lukutaitoprosentti = lukutaitoprosentti;
    }

    public double getLukutaitoprosentti() {
        return lukutaitoprosentti;
    }

    @Override
    public String toString() {
        return maa + " (" + vuosi + "), " + sukupuoli + ", " + lukutaitoprosentti;
    }

    @Override
    public int compareTo(Maa verrattava) {
        return Double.compare(this.lukutaitoprosentti, verrattava.getLukutaitoprosentti());
    }
}
