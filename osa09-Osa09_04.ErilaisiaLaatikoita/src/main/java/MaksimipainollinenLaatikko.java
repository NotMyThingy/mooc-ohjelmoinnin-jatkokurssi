import java.util.ArrayList;
import java.util.List;

public class MaksimipainollinenLaatikko extends Laatikko {

    private final List<Tavara> tavarat;
    private final int maksimipaino;

    public MaksimipainollinenLaatikko(int maksimipaino) {
        this.tavarat = new ArrayList<>();
        this.maksimipaino = maksimipaino;
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (tavara.getPaino() + tavaroidenPainoYhteensa() > maksimipaino) {
            return;
        }

        tavarat.add(tavara);
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return tavarat.contains(tavara);
    }

    private int tavaroidenPainoYhteensa() {
        int paino = 0;
        for (Tavara tavara : tavarat) {
            paino += tavara.getPaino();
        }

        return paino;
    }

}
