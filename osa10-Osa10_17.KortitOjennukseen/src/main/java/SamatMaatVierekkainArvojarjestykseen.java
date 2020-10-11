import java.util.Comparator;

public class SamatMaatVierekkainArvojarjestykseen implements Comparator<Kortti> {


    @Override
    public int compare(Kortti k1, Kortti k2) {
        if (k1.getMaa().ordinal() == k2.getMaa().ordinal()) {
            return k1.getArvo() - k2.getArvo();
        }

        return k1.getMaa().ordinal() - k2.getMaa().ordinal();
    }

}
