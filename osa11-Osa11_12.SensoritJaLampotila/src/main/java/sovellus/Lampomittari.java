package sovellus;

import java.util.Random;

public class Lampomittari implements Sensori {

    private boolean paalla;

    public Lampomittari() {
        this.paalla = false;
    }

    @Override
    public boolean onPaalla() {
        return paalla;
    }

    @Override
    public void paalle() {
        this.paalla = true;
    }

    @Override
    public void poisPaalta() {
        this.paalla = false;
    }

    @Override
    public int mittaa() {
        if (!this.paalla) {
            throw new IllegalStateException();
        }

        return new Random().nextInt(61) - 30;
    }
}
