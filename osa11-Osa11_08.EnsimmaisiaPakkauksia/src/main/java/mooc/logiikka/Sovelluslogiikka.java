package mooc.logiikka;

import mooc.ui.Kayttoliittyma;

public class Sovelluslogiikka {

    private final Kayttoliittyma kayttoliittyma;

    public Sovelluslogiikka(Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }

    public void suorita(int montaKertaa) {
        while (montaKertaa > 0) {
            System.out.println("Sovelluslogiikka toimii");
            kayttoliittyma.paivita();
            montaKertaa--;
        }
    }
}
