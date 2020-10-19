
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lottorivi {

    private ArrayList<Integer> numerot;

    public Lottorivi() {
        // Arvo numerot heti LottoRivin luomisen yhteydessä
        this.arvoNumerot();
    }

    public ArrayList<Integer> numerot() {
        Collections.sort(this.numerot);
        return this.numerot;
    }

    public void arvoNumerot() {
        // Alustetaan lista numeroille
        this.numerot = new ArrayList<>();
        while (this.numerot.size() < 7) {
            int arvottuLuku = new Random().nextInt(40) + 1;
            if (sisaltaaNumeron(arvottuLuku)) {
                continue;
            }

            this.numerot.add(arvottuLuku);
        }
    }

    public boolean sisaltaaNumeron(int numero) {
        // Testaa tässä onko numero jo arvottujen numeroiden joukossa
        return this.numerot.contains(numero);
    }
}
