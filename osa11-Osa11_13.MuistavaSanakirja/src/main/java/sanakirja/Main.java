package sanakirja;

public class Main {
    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
        MuistavaSanakirja s = new MuistavaSanakirja("sanat.txt");
        s.lataa();
        s.poista("below");
        s.lisaa("tieokone", "computer");
        s.tallenna();

    }
}
