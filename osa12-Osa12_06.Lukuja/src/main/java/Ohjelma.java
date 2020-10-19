
import java.util.Random;
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Random arpoja = new Random();

        System.out.println("Montako satunnaislukua tulostetaan?");
        int maara = Integer.parseInt(lukija.nextLine());

        while (maara > 0) {
            System.out.println(arpoja.nextInt(11));
            maara--;
        }
    }

}
