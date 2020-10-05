import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public int saldo(String tuote) {
        return this.saldo.getOrDefault(tuote, 0);
    }

    public boolean ota(String tuote) {
        if (saldo(tuote) == 0) {
            return false;
        }

        this.saldo.put(tuote, saldo(tuote) - 1);
        return true;
    }

    public Set<String> tuotteet() {
        return this.saldo.keySet();
    }
}
