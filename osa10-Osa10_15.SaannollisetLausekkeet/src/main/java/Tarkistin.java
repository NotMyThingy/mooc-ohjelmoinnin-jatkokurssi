

public class Tarkistin {

    public boolean onViikonpaiva(String merkkijono) {
        String regex = "ma|ti|ke|to|pe|la|su";
        return merkkijono.matches(regex);
    }

    public boolean kaikkiVokaaleja(String merkkijono) {
        String regex = "[aeiouäö]*";
        return merkkijono.matches(regex);
    }

    public boolean kellonaika(String merkkijono){
        String regex = "([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        return merkkijono.matches(regex);
    }
}
