import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kasi implements Comparable<Kasi> {

    private final List<Kortti> kortit;

    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public void lisaa(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public void tulosta() {
        this.kortit.forEach(System.out::println);
    }

    public void jarjesta() {
        Collections.sort(kortit);
    }

    public void jarjestaMaittain() {
        Collections.sort(this.kortit, new SamatMaatVierekkainArvojarjestykseen());
    }

    @Override
    public int compareTo(Kasi verrattava) {
        return this.summa() - verrattava.summa();
    }

    private int summa() {
        return this.kortit.stream()
                .mapToInt(Kortti::getArvo).sum();
    }
}
