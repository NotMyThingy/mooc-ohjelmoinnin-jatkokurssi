
public class Main {

    public static void main(String[] args) {
        // testaa täällä luokkiesi toimintaa
        Laatikko laatikko1 = new Laatikko(10);

        laatikko1.lisaa(new Kirja("Fedor Dostojevski", "Rikos ja Rangaistus", 2));
        laatikko1.lisaa(new Kirja("Robert Martin", "Clean Code", 1));
        laatikko1.lisaa(new Kirja("Kent Beck", "Test Driven Development", 0.7));

        laatikko1.lisaa(new CDLevy("Pink Floyd", "Dark Side of the Moon", 1973));
        laatikko1.lisaa(new CDLevy("Wigwam", "Nuclear Nightclub", 1975));
        laatikko1.lisaa(new CDLevy("Rendezvous Park", "Closer to Being Here", 2012));

        Laatikko laatikko2 = new Laatikko(5);
        laatikko2.lisaa(laatikko1);

        System.out.println(laatikko2);

    }

}
