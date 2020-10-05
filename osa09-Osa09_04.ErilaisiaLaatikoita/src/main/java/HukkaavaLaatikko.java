import java.util.ArrayList;
import java.util.List;

public class HukkaavaLaatikko extends Laatikko {

    private final List<Tavara> tavarat;

    public HukkaavaLaatikko() {
        this.tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        tavarat.add(tavara);
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return false;
    }
}
