
import java.util.Scanner;

public class PositiivistenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        while (true) {
            int val = Integer.parseInt(lukija.nextLine());
            if (val == 0) {
                break;
            }

            if (val < 0) {
                continue;
            }

            sum += val;
            count++;
        }

        if (count == 0) {
            System.out.println("Keskiarvon laskeminen ei ole mahdollista");
        } else {
            System.out.println(1.0 * sum / count);
        }

    }
}
