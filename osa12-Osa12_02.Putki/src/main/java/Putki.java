import java.util.ArrayList;
import java.util.List;

public class Putki<T> {

    private final List<T> arvot;

    public Putki() {
        this.arvot = new ArrayList<>();
    }

    public void lisaaPutkeen(T arvo) {
        arvot.add(arvo);
    }

    public T otaPutkesta() {
        return arvot.remove(0);
    }

    public boolean onkoPutkessa() {
        return !arvot.isEmpty();
    }
}
