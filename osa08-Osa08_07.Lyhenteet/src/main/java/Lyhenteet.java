import java.util.HashMap;
import java.util.Map;

public class Lyhenteet {

    Map<String, String> lyhenteet;

    public Lyhenteet() {
        this.lyhenteet = new HashMap<>();
    }

    public void lisaaLyhenne(String lyhenne, String selite) {
        lyhenne = siistiLyhenne(lyhenne);

        if (onkoLyhennetta(lyhenne)) {
            return;
        }

        this.lyhenteet.put(lyhenne, selite);
    }

    public boolean onkoLyhennetta(String lyhenne) {
        lyhenne = siistiLyhenne(lyhenne);

        return this.lyhenteet.containsKey(lyhenne);
    }

    public String haeLyhenne(String lyhenne) {
        lyhenne = siistiLyhenne(lyhenne);

        if (!onkoLyhennetta(lyhenne)) {
            return null;
        }
        return this.lyhenteet.get(lyhenne);
    }

    private String siistiLyhenne(String lyhenne) {
        if (lyhenne == null) {
            return "";
        }

        lyhenne = lyhenne.toLowerCase();
        return lyhenne.trim();
    }
}
