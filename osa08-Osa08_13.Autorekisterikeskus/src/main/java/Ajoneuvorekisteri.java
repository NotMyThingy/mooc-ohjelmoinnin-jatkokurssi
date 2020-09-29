import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ajoneuvorekisteri {

    private final Map<Rekisterinumero, String> omistajat;

    public Ajoneuvorekisteri() {
        omistajat = new HashMap<>();
    }

    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        if (omistajat.containsKey(rekkari)) {
            return false;
        }

        omistajat.put(rekkari, omistaja);
        return true;
    }

    public String hae(Rekisterinumero rekkari) {
        return omistajat.getOrDefault(rekkari, null);
    }

    public boolean poista(Rekisterinumero rekkari) {
        if (!omistajat.containsKey(rekkari)) {
            return false;
        }

        omistajat.remove(rekkari);
        return true;
    }

    public void tulostaRekisterinumerot() {
        for (Rekisterinumero rekisterinumero : omistajat.keySet()) {
            System.out.println(rekisterinumero);
        }
    }

    public void tulostaOmistajat() {
        List<String> tulostetut = new ArrayList<>();
        for (String omistaja : omistajat.values()) {
            if (tulostetut.contains(omistaja)) continue;

            System.out.println(omistaja);
            tulostetut.add(omistaja);
        }
    }
}
