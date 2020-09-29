import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Muutoshistoria {

    private final List<Double> historia;

    public Muutoshistoria() {
        this.historia = new ArrayList<>();
    }

    public void lisaa(double tilanne) {
        historia.add(tilanne);
    }

    public void nollaa() {
        historia.clear();
    }

    public double maxArvo() {
        if (historia.isEmpty()) {
            return 0;
        }

        return historia.stream().max(Comparator.comparing(Double::valueOf)).get();
    }

    public double minArvo() {
        if (historia.isEmpty()) {
            return 0;
        }

        return historia.stream().min(Comparator.comparing(Double::valueOf)).get();
    }

    public double keskiarvo() {
        return historia.stream().mapToDouble(i -> i).sum() / historia.size();
    }

    @Override
    public String toString() {
        return historia.toString();
    }
}
