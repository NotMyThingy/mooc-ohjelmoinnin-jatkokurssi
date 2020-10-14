package sovellus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Keskiarvosensori implements Sensori {

    private final Set<Sensori> sensorit;
    private final List<Integer> mittaukset;

    public Keskiarvosensori() {
        sensorit = new HashSet<>();
        mittaukset = new ArrayList<>();
    }

    public void lisaaSensori(Sensori lisattava) {
        sensorit.add(lisattava);
    }

    public List<Integer> mittaukset() {
        return mittaukset;
    }

    @Override
    public boolean onPaalla() {
        return sensorit.stream().allMatch(Sensori::onPaalla);

    }

    @Override
    public void paalle() {
        sensorit.forEach(Sensori::paalle);
    }

    @Override
    public void poisPaalta() {
        sensorit.forEach(Sensori::poisPaalta);
    }

    @Override
    public int mittaa() {
        if (!onPaalla() || sensorit.isEmpty()) {
            throw new IllegalStateException("Mittaaminen ei onnistunut");
        }

        int avg = (int) sensorit.stream()
                .mapToInt(Sensori::mittaa)
                .average()
                .getAsDouble();
        mittaukset.add(avg);

        return avg;
    }
}
