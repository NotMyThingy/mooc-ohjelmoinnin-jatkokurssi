
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiettyjenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        List<Integer> luvut = new ArrayList<>();

        System.out.println("Kirjoita syötteitä, \"loppu\" lopettaa.");
        while (true) {
            String luettu = lukija.nextLine();

            if (luettu.equals("loppu")) {
                break;
            }

            try {
                int luku = Integer.parseInt(luettu);
                luvut.add(luku);
            } catch (NumberFormatException ex) {
                System.out.println("Epäkelpo syöte.");
            }
        }

        System.out.println("Tulostetaanko negatiivisten vai positiivisten lukujen keskiarvo? (n/p)");
        String luettu = lukija.nextLine();

        if (luettu.equals("n")) {
            System.out.println("Negatiivisten lukujen keskiarvo:" + luvut.stream()
                    .mapToInt(i -> i)
                    .filter(i -> i < 0)
                    .average()
                    .getAsDouble());
        }

        if (luettu.equals("p")) {
            System.out.println("Positiivisten lukujen keskiarvo: " + luvut.stream()
                    .mapToInt(i -> i)
                    .filter(i -> i > 0)
                    .average()
                    .getAsDouble());
        }
    }
}
