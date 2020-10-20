
public class Ohjelma {

    public static void main(String[] args) {
        // Testaa metodiasi täällä
        int[][] matriisi = {
                {3, 2, 7, 6},
                {2, 4, 1, 0},
                {3, 2, 1, 0}
        };

        System.out.println(taulukkoMerkkijonona(matriisi));
    }


    public static String taulukkoMerkkijonona(int[][] taulukko) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] rivi : taulukko) {
            for (int luku : rivi) {
                stringBuilder.append(luku);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
