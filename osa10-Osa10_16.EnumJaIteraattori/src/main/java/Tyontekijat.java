import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tyontekijat {

    private final List<Henkilo> henkilot;

    public Tyontekijat() {
        this.henkilot = new ArrayList<>();
    }

    public void lisaa(Henkilo henkilo) {
        this.henkilot.add(henkilo);
    }

    public void lisaa(List<Henkilo> henkilot) {
        this.henkilot.addAll(henkilot);
    }

    public void tulosta() {
        this.henkilot.forEach(System.out::println);
    }

    public void tulosta(Koulutus koulutus) {
        /*this.henkilot.stream()
                .map(henkilo -> henkilo.getKoulutus() == koulutus)
                .forEach(System.out::println);*/

        Iterator<Henkilo> iteraattori = henkilot.iterator();
        while (iteraattori.hasNext()) {
            if (iteraattori.next().getKoulutus() == koulutus) {
                System.out.println(iteraattori.next());
            }
        }
    }

    public void irtisano(Koulutus koulutus) {
        henkilot.removeIf(henkilo -> henkilo.getKoulutus() == koulutus);
    }

}
