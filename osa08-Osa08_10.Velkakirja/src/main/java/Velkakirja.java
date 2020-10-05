import java.util.HashMap;
import java.util.Map;

public class Velkakirja {

    private final Map<String, Double> velkakirja;

    public Velkakirja() {
        this.velkakirja = new HashMap<>();
    }

    public void asetaLaina(String kenelle, double maara) {
        this.velkakirja.put(kenelle, maara);
    }

    public double paljonkoVelkaa(String kuka) {
        return this.velkakirja.getOrDefault(kuka, 0.0);
    }
}
