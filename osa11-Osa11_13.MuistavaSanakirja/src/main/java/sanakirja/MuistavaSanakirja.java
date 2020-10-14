package sanakirja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MuistavaSanakirja {

    private final Map<String, String> kaannokset;
    private String tiedosto;

    public MuistavaSanakirja() {
        kaannokset = new HashMap<>();
    }


    public MuistavaSanakirja(String tiedosto) {
        this();
        this.tiedosto = tiedosto;
    }

    public void lisaa(String sana, String kaannos) {
        kaannokset.putIfAbsent(sana, kaannos);
        kaannokset.putIfAbsent(kaannos, sana);
    }

    public String kaanna(String sana) {
        return kaannokset.get(sana);
    }

    public void poista(String sana) {
        String kaannos = kaanna(sana);

        kaannokset.remove(sana);
        kaannokset.remove(kaannos);
    }

    public boolean lataa() {
        try {
            Files.lines(Paths.get(tiedosto))
                    .map(l -> l.split(":"))
                    .forEach(osat -> {
                        kaannokset.putIfAbsent(osat[0], osat[1]);
                        kaannokset.putIfAbsent(osat[1], osat[0]);
                    });
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean tallenna() {
        List<String> tiedostossa = new ArrayList<>();
        try {
            PrintWriter printWriter = new PrintWriter(new File(tiedosto));
            kaannokset.keySet().forEach(sana -> {
                if (tiedostossa.contains(sana)) {
                    return;
                }
                String kaannos = sana + ":" + kaanna(sana);
                printWriter.println(kaannos);

                tiedostossa.add(sana);
                tiedostossa.add(kaanna(sana));
            });
            printWriter.close();
        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }
}
