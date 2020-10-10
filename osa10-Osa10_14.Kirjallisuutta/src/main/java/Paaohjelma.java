
import java.util.*;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        List<Kirja> kirjat = new ArrayList<>();

        while (true) {
            System.out.print("Syötä kirjan nimi, tyhjä lopettaa: ");
            String nimi = lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            }

            System.out.print("Syötä kirjan pienin kohdeikä: ");
            int ika = Integer.parseInt(lukija.nextLine());

            Kirja k = new Kirja(nimi, ika);
            if (kirjat.contains(k)) {
                continue;
            }

            kirjat.add(k);
            System.out.println();
        }

        System.out.println();
        System.out.println(kirjat.size() + " kirjaa");
        System.out.println();

        Comparator<Kirja> vertailija = Comparator
                .comparing(Kirja::getMinkohdeika)
                .thenComparing(Kirja::getNimi);

        Collections.sort(kirjat, vertailija);

        System.out.println("Kirjat");
        kirjat.stream()
                .forEach(System.out::println);
    }

}
