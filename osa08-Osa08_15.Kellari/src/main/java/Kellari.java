import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kellari {

    private final Map<String, ArrayList<String>> komerot;

    public Kellari() {
        this.komerot = new HashMap<>();
    }

    /**
     * @param komero
     * @param tavara
     */
    public void lisaa(String komero, String tavara) {
        komerot.putIfAbsent(komero, new ArrayList<>());
        komerot.get(komero).add(tavara);
    }

    /**
     * @param komero
     */
    public ArrayList<String> sisalto(String komero) {
        return komerot.getOrDefault(komero, new ArrayList<>());
    }

    /**
     * @param komero
     * @param tavara
     */
    public void poista(String komero, String tavara) {
        if (!komerot.containsKey(komero)) {
            return;
        }

        komerot.get(komero).remove(tavara);

        if (komerot.get(komero).isEmpty()) {
            komerot.remove(komero);
        }
    }

    /**
     * @return lista
     */
    public ArrayList<String> komerot() {
        ArrayList<String> lista = new ArrayList<>();
        for (String komero : komerot.keySet()) {
            if (komerot.get(komero).isEmpty()) {
                continue;
            }

            lista.add(komero);
        }

        return lista;
    }


}
