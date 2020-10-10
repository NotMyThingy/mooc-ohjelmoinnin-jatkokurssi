
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lukutaitovertailu {

    public static void main(String[] args) {
        List<Maa> maat = new ArrayList<>();

        try {
            Files.lines(Paths.get("lukutaito.csv"))
                    .map(rivi -> rivi.split(","))
                    .map(p -> new Maa(p[2].replace("(%)", "").trim(), p[3], Integer.parseInt(p[4]), Double.parseDouble(p[5])))
                    .forEach(maat::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        maat.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
