import java.util.ArrayList;
import java.util.List;

public class Laatikko implements Talletettava {

    private final List<Talletettava> tavarat;
    private final double maksimikapasiteetti;

    public Laatikko(double maksimikapasiteetti) {
        this.tavarat = new ArrayList<>();
        this.maksimikapasiteetti = maksimikapasiteetti;
    }

    public void lisaa(Talletettava tavara) {
        if (paino() + tavara.paino() > maksimikapasiteetti) {
            return;
        }

        tavarat.add(tavara);
    }

    public double paino() {
        if (tavarat.isEmpty()) {
            return 0.0;
        }

        return tavarat.stream().mapToDouble(Talletettava::paino).sum();
    }

    @Override
    public String toString() {
        return "Laatikko: " + tavarat.size() +
                " esinettä, paino yhteensä " +
                paino() + " kiloa";
    }
}
