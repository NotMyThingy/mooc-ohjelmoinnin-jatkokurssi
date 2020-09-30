
public class Main {

    public static void main(String[] args) {
        // Testaa koodiasi täällä!

        Palvelusvelvollinen sivari = new Sivari();
        System.out.println("Sivari");
        System.out.println(sivari.paiviaJaljella());
        sivari.palvele();
        sivari.palvele();
        sivari.palvele();
        System.out.println(sivari.paiviaJaljella());

        System.out.println();

        System.out.println("Taistelija");
        Palvelusvelvollinen sotilas = new Asevelvollinen(180);
        System.out.println(sotilas.paiviaJaljella());
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        sotilas.palvele();
        System.out.println(sotilas.paiviaJaljella());

    }
}
