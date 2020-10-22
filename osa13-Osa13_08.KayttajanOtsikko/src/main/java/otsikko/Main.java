package otsikko;


import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Otsikko: ");
        String otsikko = new Scanner(System.in).nextLine();

        Application.launch(KayttajanOtsikko.class, "--otsikko=" + otsikko);
    }

}
