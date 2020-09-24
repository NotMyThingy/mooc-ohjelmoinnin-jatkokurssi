
import java.util.Scanner;

public class Nestesailiot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int ensimmainen = 0;
        int toinen = 0;

        while (true) {
            System.out.println("Ensimmäinen: " + ensimmainen + "/100");
            System.out.println("Toinen: " + toinen + "/100");
            System.out.print("> ");

            String luettu = lukija.nextLine();
            if (luettu.equals("lopeta")) {
                break;
            }

            String[] osat = luettu.split(" ");
            String komento = osat[0];
            int maara = Integer.parseInt(osat[1]);

            if (komento.equals("lisaa") && maara > 0) {
                ensimmainen += maara;
                if (ensimmainen > 100) {
                    ensimmainen = 100;
                }
            }

            if (komento.equals("siirra") && maara > 0) {
                if (maara > ensimmainen) {
                    maara = ensimmainen;
                }

                toinen += maara;
                ensimmainen -= maara;

                if (toinen > 100) {
                    toinen = 100;
                }
            }

            if (komento.equals("poista") && maara > 0) {
                toinen -= maara;
                if (toinen < 0) {
                    toinen = 0;
                }
            }

            System.out.println();

        }
    }

}
