
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RajatutLuvut {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        List<String> luetut = new ArrayList<>();

        while (true) {
            String luettu = lukija.nextLine();

            if (Integer.parseInt(luettu) < 0) {
                break;
            }

            luetut.add(luettu);
        }

        // Tulostetaan luvut välillä 1-5
        luetut.stream()
                .mapToInt(Integer::parseInt)
                .filter(luku -> luku > 0 && luku < 6)
                .forEach(System.out::println);
    }
}
