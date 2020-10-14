package lentokentta;


import lentokentta.logiikka.Lentohallinta;
import lentokentta.ui.Kayttoliittyma;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        Lentohallinta lentohallinta = new Lentohallinta();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija, lentohallinta);

        kayttoliittyma.kaynnista();
    }
}
