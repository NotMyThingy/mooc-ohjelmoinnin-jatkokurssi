import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UseanKaannoksenSanakirja {

    private Map<String, ArrayList<String>> sanakirja;

    public UseanKaannoksenSanakirja() {
        this.sanakirja = new HashMap<>();
    }

    public void lisaa(String sana, String kaannos) {
        sanakirja.putIfAbsent(sana, new ArrayList<>());
        sanakirja.get(sana).add(kaannos);
    }

    public ArrayList<String> kaanna(String sana) {
        return sanakirja.getOrDefault(sana, new ArrayList<>());
    }

    public void poista(String sana) {
        sanakirja.remove(sana);
    }

}
