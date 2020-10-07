import java.util.HashMap;
import java.util.Map;

public class Ostoskori {

    private final Map<String, Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new HashMap<>();
    }

    public void lisaa(String tuote, int hinta) {
        Ostos o = ostokset
                .getOrDefault(tuote, new Ostos(tuote, 0, hinta));
        o.kasvataMaaraa();
        ostokset.putIfAbsent(tuote, o);
    }

    public int hinta() {
        return ostokset
                .values()
                .stream()
                .mapToInt(Ostos::hinta)
                .sum();
    }

    public void tulosta() {
        for (Ostos o : ostokset.values()) {
            System.out.println(o);
        }
    }
}
