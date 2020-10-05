import java.util.HashMap;
import java.util.Map;

public class Varasto {

    private final Map<String, Integer> hinta;
    private final Map<String, Integer> saldo;

    public Varasto() {
        this.hinta = new HashMap<>();
        this.saldo = new HashMap<>();
    }

    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.hinta.put(tuote, hinta);
        this.saldo.put(tuote, saldo);
    }

    public int hinta(String tuote) {
        return this.hinta.getOrDefault(tuote, -99);
    }
}
