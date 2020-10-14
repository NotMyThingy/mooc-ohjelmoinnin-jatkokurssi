package lentokentta.ui;

import lentokentta.domain.Lentokone;
import lentokentta.logiikka.Lentohallinta;

import java.util.Scanner;

public class Kayttoliittyma {

    private final Scanner lukija;
    private final Lentohallinta lentohallinta;

    public Kayttoliittyma(Scanner lukija, Lentohallinta lentohallinta) {
        this.lukija = lukija;
        this.lentohallinta = lentohallinta;
    }

    public void kaynnista() {
        kaynnistaLentokentanHallintapalvelu();
        System.out.println();
        kaynnistaLentopalvelu();
        System.out.println();
    }

    private void kaynnistaLentokentanHallintapalvelu() {
        System.out.println("Lentokentän hallinta");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("[1] Lisää lentokone");
            System.out.println("[2] Lisää lento");
            System.out.println("[x] Poistu hallintamoodista");

            System.out.print("> ");
            String luettu = lukija.nextLine().trim();

            if (luettu.equals("1")) {
                lisaaLentokone();
            }

            if (luettu.equals("2")) {
                lisaaLento();
            }

            if (luettu.equals("x")) {
                break;
            }

        }
    }

    private void lisaaLentokone() {
        System.out.print("Anna lentokoneen tunnus: ");
        String tunnus = lukija.nextLine();

        if (tunnus.trim().isEmpty()) {
            return;
        }

        try {
            System.out.print("Anna lentokoneen kapasiteetti: ");
            int kapasiteetti = Integer.parseInt(lukija.nextLine());
            lentohallinta.lisaaLentokone(tunnus, kapasiteetti);
        } catch (NumberFormatException e) {
            System.out.println("Luku ei kelpaa.");
        }

    }

    private void lisaaLento() {
        System.out.print("Anna lentokoneen tunnus: ");
        Lentokone lentokone = kysyLentokone();
        System.out.print("Anna lähtöpaikan tunnus: ");
        String lahtotunnus = lukija.nextLine();
        System.out.print("Anna kohdepaikan tunnus: ");
        String kohdetunnus = lukija.nextLine();

        if (lahtotunnus.trim().isEmpty() || kohdetunnus.trim().isEmpty()) {
            System.out.println("Tunnus puuttuu");
            return;
        }

        lentohallinta.lisaaLento(lentokone, lahtotunnus, kohdetunnus);

    }

    private void kaynnistaLentopalvelu() {
        System.out.println("Lentopalvelu");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Valitse toiminto: ");
            System.out.println("[1] Tulosta lentokoneet");
            System.out.println("[2] Tulosta lennot");
            System.out.println("[3] Tulosta lentokoneen tiedot");
            System.out.println("[x] Lopeta");

            System.out.print("> ");
            String luettu = lukija.nextLine().trim();

            if (luettu.equals("1")) {
                tulostaLentokoneet();
            }

            if (luettu.equals("2")) {
                tulostaLennot();
            }

            if (luettu.equals("3")) {
                tulostaLentokoneenTiedot();
            }

            if (luettu.equals("x")) {
                break;
            }
        }
    }

    private void tulostaLentokoneet() {
        lentohallinta.getLentokoneet()
                .forEach(System.out::println);
    }

    private void tulostaLennot() {
        lentohallinta.getLennot()
                .forEach(System.out::println);
    }

    private void tulostaLentokoneenTiedot() {
        System.out.print("Mikä kone: ");
        Lentokone lentokone = kysyLentokone();
        System.out.println(lentokone);
        System.out.println();
    }

    private Lentokone kysyLentokone() {
        Lentokone lentokone = null;
        while (lentokone == null) {
            String tunnus = lukija.nextLine();
            lentokone = lentohallinta.haeLentokone(tunnus);

            if (lentokone == null) {
                System.out.println("Tunnuksella " + tunnus + " ei ole lentokonetta.");
            }
        }

        return lentokone;
    }
}
