import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Muutoshistoria {

    private final List<Double> tilanteet;

    public Muutoshistoria() {
        this.tilanteet = new ArrayList<>();
    }

    public void lisaa(double tilanne) {
        tilanteet.add(tilanne);
    }

    public void nollaa() {
        tilanteet.clear();
    }

    public double maxArvo() {
        if (tilanteet.isEmpty()) {
            return 0;
        }

        return tilanteet.stream().max(Comparator.comparing(Double::valueOf)).get();
    }

    public double minArvo() {
        if (tilanteet.isEmpty()) {
            return 0;
        }

        return tilanteet.stream().min(Comparator.comparing(Double::valueOf)).get();
    }

    public double keskiarvo() {
        if (tilanteet.isEmpty()) {
            return 0;
        }

        return tilanteet.stream().mapToDouble(i -> i).sum() / tilanteet.size();
    }

    @Override
    public String toString() {
        return tilanteet.toString();
    }
}
