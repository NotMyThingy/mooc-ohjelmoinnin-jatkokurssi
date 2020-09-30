public class CDLevy implements Talletettava {

    private final String artisti;
    private final String albumi;
    private final int julkaisuvuosi;
    private final double paino;

    public CDLevy(String artisti, String albumi, int julkaisuvuosi) {
        this.artisti = artisti;
        this.albumi = albumi;
        this.julkaisuvuosi = julkaisuvuosi;
        this.paino = 0.1;
    }

    @Override
    public double paino() {
        return paino;
    }

    @Override
    public String toString() {
        return artisti + ": " + albumi +
                " (" + julkaisuvuosi + ")";
    }
}
