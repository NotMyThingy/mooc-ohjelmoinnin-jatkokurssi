
public class Taikaneliotehdas {

    private Taikanelio nelio;
    private int x;
    private int y;

    public Taikanelio luoTaikanelio(int koko) {

        this.nelio = new Taikanelio(koko);
        this.x = nelio.getLeveys() / 2;
        this.y = 0;

        int i = 1;
        while (i <= koko * koko) {
            nelio.asetaArvo(x, y, i);
            asetaSeuraavaTyhjaRuutu();
            i++;
        }

        return nelio;
    }

    private void asetaSeuraavaTyhjaRuutu() {
        // meneekö nurkasta yli
        if (x + 1 >= nelio.getLeveys() && y - 1 < 0) {
            if (nelio.annaArvo(0, nelio.getKorkeus() - 1) == 0) {
                x = 0;
                y = nelio.getKorkeus() - 1;
            } else {
                y += 1;
            }
            // meneekö oikealta yli
        } else if (x + 1 >= nelio.getLeveys()) {
            if (nelio.annaArvo(0, y - 1) == 0) {
                x = 0;
                y -= 1;
            } else {
                y += 1;
            }
            // meneekö ylhäältä yli
        } else if (y - 1 < 0) {
            if (nelio.annaArvo(x + 1, nelio.getKorkeus() - 1) == 0) {
                x += 1;
                y = nelio.getKorkeus() - 1;
            } else {
                y += 1;
            }
            // ei mene yli mistään
        } else if (nelio.annaArvo(x + 1, y - 1) == 0) {
            x += 1;
            y -= 1;
        } else {
            y += 1;
        }
    }

}
