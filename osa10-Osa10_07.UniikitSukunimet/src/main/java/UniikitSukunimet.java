
import java.util.ArrayList;
import java.util.Scanner;

public class UniikitSukunimet {

    public static void main(String[] args) {
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.print("Syötetäänkö henkilöiden tietoja, \"loppu\" lopettaa: ");
            String jatketaan = lukija.nextLine();

            if (jatketaan.equals("loppu")) {
                break;
            }

            System.out.print("Syötä etunimi: ");
            String etunimi = lukija.nextLine();
            System.out.print("Syötä sukunimi: ");
            String sukunimi = lukija.nextLine();
            System.out.print("Syötä syntymävuosi: ");
            int syntymavuosi = Integer.parseInt(lukija.nextLine());

            henkilot.add(new Henkilo(etunimi, sukunimi, syntymavuosi));
            System.out.println();
        }

        System.out.println("\nUniikit sukunimet aakkosjärjestyksessä:");
        henkilot.stream()
                .map(Henkilo::getSukunimi)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
