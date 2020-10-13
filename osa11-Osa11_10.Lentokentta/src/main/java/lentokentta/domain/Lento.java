package lentokentta.domain;

public class Lento {

    private final Lentokone lentokone;
    private final Paikka lahtopaikka;
    private final Paikka kohdepaikka;

    public Lento(Lentokone lentokone, Paikka lahtopaikka, Paikka kohdepaikka) {
        this.lentokone = lentokone;
        this.lahtopaikka = lahtopaikka;
        this.kohdepaikka = kohdepaikka;
    }

    @Override
    public String toString() {
        return lentokone + " (" + lahtopaikka + "-" + kohdepaikka + ")";
    }
}
