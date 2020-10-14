
import java.util.Arrays;
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int[] luvut = {8, -2, 3, 1, 1};

        System.out.println(summa(luvut, 0, luvut.length, 0, 999));

    }

    public static int summa(int[] taulukko, int mista, int mihin, int pienin, int suurin) {
        if (mista < 0) {
            mista = 0;
        }
        if (mihin > taulukko.length) {
            mihin = taulukko.length;
        }

        int summa = 0;
        for (int i = mista; i < mihin; i++) {
            if (taulukko[i] >= pienin && taulukko[i] <= suurin) {
                summa += taulukko[i];
            }
        }

        return summa;
    }

}
