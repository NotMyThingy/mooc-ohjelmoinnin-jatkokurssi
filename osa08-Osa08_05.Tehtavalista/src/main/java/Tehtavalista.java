import java.util.ArrayList;
import java.util.List;

public class Tehtavalista {

    private final List<String> tehtavat;

    public Tehtavalista() {
        this.tehtavat = new ArrayList<>();
    }

    public void lisaa(String tehtava) {
        if (this.tehtavat.contains(tehtava)) {
            return;
        }

        this.tehtavat.add(tehtava);
    }

    public void tulosta() {
        int indeksi = 1;
        for (String tehtava : this.tehtavat) {
            System.out.println("" + indeksi + ": " + tehtava);
            indeksi++;
        }
    }

    public void poista(int numero) {
        this.tehtavat.remove(numero - 1);
    }
}
