package lentokentta.domain;

public class Lentokone {

    private final String tunnus;
    private final int kapasiteetti;

    public Lentokone(String tunnus, int kapasiteetti) {
        this.tunnus = tunnus;
        this.kapasiteetti = kapasiteetti;
    }

    @Override
    public String toString() {
        return tunnus + " (" + kapasiteetti + " henkilöä)";
    }
}
