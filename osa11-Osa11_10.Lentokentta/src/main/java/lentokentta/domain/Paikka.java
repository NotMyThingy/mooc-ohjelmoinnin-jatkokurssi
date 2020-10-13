package lentokentta.domain;

public class Paikka {

    private final String tunnus;

    public Paikka(String tunnus) {
        this.tunnus = tunnus;
    }

    @Override
    public String toString() {
        return tunnus;
    }
}
