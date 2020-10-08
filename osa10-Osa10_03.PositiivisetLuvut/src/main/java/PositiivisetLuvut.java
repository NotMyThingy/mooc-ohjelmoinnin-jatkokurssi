
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiivisetLuvut {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(7);
        lista.add(-4);
        lista.add(2);
        lista.add(6);

        System.out.println(positiiviset(lista));
    }

    public static List<Integer> positiiviset(List<Integer> luvut) {
        return luvut.stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
    }

}
