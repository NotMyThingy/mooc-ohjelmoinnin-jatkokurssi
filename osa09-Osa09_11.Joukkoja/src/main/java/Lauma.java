import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lauma implements Siirrettava {

    private final Set<Siirrettava> siirrettavat;

    public Lauma() {
        this.siirrettavat = new HashSet<>();
    }

    public void lisaaLaumaan(Siirrettava siirrettava) {
        this.siirrettavat.add(siirrettava);
    }

    @Override
    public void siirra(int dx, int dy) {
        siirrettavat.forEach(siirrettava -> siirrettava.siirra(dx, dy));
    }

    @Override
    public String toString() {

        return siirrettavat.stream()
                .map(Siirrettava::toString)
                .collect(Collectors.joining("\n"));
    }
}
