package lentokentta.logiikka;

import lentokentta.domain.Lento;
import lentokentta.domain.Lentokone;
import lentokentta.domain.Paikka;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Lentohallinta {

    private final Map<String, Lentokone> lentokoneet;
    private final Map<String, Paikka> paikat;
    private final Map<String, Lento> lennot;

    public Lentohallinta() {
        this.lentokoneet = new HashMap<>();
        this.paikat = new HashMap<>();
        this.lennot = new HashMap<>();
    }

    public void lisaaLentokone(String tunnus, int kapasiteetti) {
        Lentokone lentokone = new Lentokone(tunnus, kapasiteetti);
        lentokoneet.putIfAbsent(tunnus, lentokone);
    }

    public void lisaaLento(Lentokone lentokone, String lahtotunnus, String kohdetunnus) {
        this.paikat.putIfAbsent(lahtotunnus, new Paikka(lahtotunnus));
        this.paikat.putIfAbsent(kohdetunnus, new Paikka(kohdetunnus));

        Lento lento = new Lento(lentokone, paikat.get(lahtotunnus), paikat.get(kohdetunnus));
        lennot.put(lento.toString(), lento);
    }

    public Collection<Lentokone> getLentokoneet() {
        return lentokoneet.values();
    }

    public Collection<Lento> getLennot() {
        return lennot.values();
    }

    public Lentokone haeLentokone(String tunnus) {
        return lentokoneet.get(tunnus);
    }
}
