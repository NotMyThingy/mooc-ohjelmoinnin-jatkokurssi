
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TiedostonRivit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        lue("testi.txt").stream()
                .forEach(System.out::println);
    }

    public static List<String> lue(String tiedosto) {
        List<String> rivit = new ArrayList<>();

        try {
            Files.lines(Paths.get(tiedosto)).forEach(rivit::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rivit;
    }

}
