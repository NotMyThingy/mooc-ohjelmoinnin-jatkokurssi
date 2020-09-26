
import java.util.HashMap;

public class Ohjelma {

    public static void main(String[] args) {

        HashMap<String, Kirja> taulu = new HashMap<>();
        taulu.put("tunteet", new Kirja("Järki ja tunteet", 1811, "..."));
        taulu.put("luulot", new Kirja("Ylpeys ja ennakkoluulo", 1813, "...."));

        tulostaArvot(taulu);
        System.out.println("---");
        tulostaArvoJosNimessa(taulu, "ennakko");

    }

    /*
     * tulostaa parametrina annetun hajautustaulun arvot niiden toString-metodia käyttäen.
     */
    public static void tulostaArvot(HashMap<String, Kirja> hajautustaulu) {

        for (Kirja kirja : hajautustaulu.values()) {
            System.out.println(kirja);
        }
    }

    /*
     * tulostaa parametrina annetun hajautustaulun arvoista ne, joiden nimessä on parametrina annettu merkkijono.
     */
    public static void tulostaArvoJosNimessa(HashMap<String, Kirja> hajautustaulu, String merkkijono) {
        for (Kirja kirja : hajautustaulu.values()) {
            if (kirja.getNimi().contains(merkkijono)) {
                System.out.println(kirja);
            }
        }
    }

}
