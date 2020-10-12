
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KirjatTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // testaa metodia täällä
        lueKirjat("teksti.txt").stream()
                .forEach(System.out::println);

    }

    public static List<Kirja> lueKirjat(String tiedosto) {
        List<Kirja> kirjat = new ArrayList<>();

        try {
            Files.lines(Paths.get(tiedosto))
                    .map(rivi -> rivi.split(","))
                    .filter(palat -> palat.length >= 2)
                    .map(palat -> new Kirja(palat[0], Integer.parseInt(palat[1]), Integer.parseInt(palat[2]), palat[3]))
                    .forEach(kirjat::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return kirjat;
    }

}
