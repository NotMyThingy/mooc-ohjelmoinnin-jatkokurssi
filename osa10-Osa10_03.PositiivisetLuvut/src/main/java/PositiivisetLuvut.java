
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiivisetLuvut {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        List<Integer> luvut = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            luvut.add(i);
        }

        long lukuja = luvut.stream()
                .filter(i -> i < 4)
                .map(i -> i * 2)
                .filter(i -> i > 10)
                .count();

        System.out.println("Lukuja oli: " + lukuja);
    }
}
