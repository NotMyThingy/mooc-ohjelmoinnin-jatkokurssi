
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Set<String> luetut = new HashSet<>();

        System.out.println("Kirjoita syötteitä, \"loppu\" lopettaa.");
        while (true) {
            String luettu = lukija.nextLine();

            if (luettu.equals("loppu")) {
                break;
            }

            luetut.add(luettu);
        }

        double ka = luetut.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();

        System.out.println("Lukujen keskiarvo: " + ka);
    }
}
