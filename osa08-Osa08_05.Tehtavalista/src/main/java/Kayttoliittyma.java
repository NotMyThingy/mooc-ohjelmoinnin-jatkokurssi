import java.util.Scanner;

public class Kayttoliittyma {

    private final Scanner lukija;
    private final Tehtavalista tehtavalista;

    public Kayttoliittyma(Tehtavalista tehtavalista, Scanner lukija) {
        this.lukija = lukija;
        this.tehtavalista = tehtavalista;
    }

    public void kaynnista() {
        while (true) {
            System.out.print("Komento: ");
            String luettu = lukija.nextLine().trim();
            if (luettu.equals("lopeta")) {
                break;
            }

            if (luettu.equals("lisaa")) {
                System.out.print("Lisättävä: ");
                String tehtava = lukija.nextLine().trim();
                if (!tehtava.isEmpty()) {
                    this.tehtavalista.lisaa(tehtava);
                }
                continue;
            }

            if (luettu.equals("listaa")) {
                this.tehtavalista.tulosta();
                continue;
            }

            if (luettu.equals("poista")) {
                System.out.println("Mikä poistetaan? ");
                int poistettava = Integer.parseInt(lukija.nextLine());
                this.tehtavalista.poista(poistettava);
            }
        }
    }
}