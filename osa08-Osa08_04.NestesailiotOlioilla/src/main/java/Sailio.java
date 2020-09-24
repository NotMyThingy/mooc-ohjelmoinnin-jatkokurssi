public class Sailio {

    private int maara;

    public Sailio() {
        this.maara = 0;
    }

    public int sisalto() {
        return this.maara;
    }

    public void lisaa(int maara) {
        if (maara < 0) {
            return;
        }

        this.maara += maara;

        if (this.maara > 100) {
            this.maara = 100;
        }
    }

    public void poista(int maara) {
        if (maara < 0) {
            return;
        }

        this.maara -= maara;

        if (this.maara < 0) {
            this.maara = 0;
        }
    }

    @Override
    public String toString() {
        return "" + this.maara + "/100";
    }
}
