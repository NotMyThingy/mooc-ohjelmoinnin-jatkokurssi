public class Sivari implements Palvelusvelvollinen {

    private int paivia;

    public Sivari() {
        paivia = 362;
    }

    @Override
    public int paiviaJaljella() {
        return paivia;
    }

    @Override
    public void palvele() {
        paivia -= 1;
        if (paivia < 0) {
            paivia = 0;
        }
    }
}
