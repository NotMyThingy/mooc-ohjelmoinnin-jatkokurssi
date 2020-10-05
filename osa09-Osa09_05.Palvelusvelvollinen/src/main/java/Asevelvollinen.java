public class Asevelvollinen implements Palvelusvelvollinen {

    private int paivia;

    public Asevelvollinen(int paivia) {
        this.paivia = paivia;
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
