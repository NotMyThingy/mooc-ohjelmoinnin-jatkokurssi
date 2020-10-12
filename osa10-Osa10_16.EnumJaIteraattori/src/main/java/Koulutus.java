public enum Koulutus {

    FT("tohtori"),
    FM("maisteri"),
    LuK("kandidaatti"),
    FilYO("yliopiilas");

    private final String koulutusaste;

    Koulutus(String koulutusaste) {
        this.koulutusaste = koulutusaste;
    }

    public String getKoulutusaste() {
        return koulutusaste;
    }
}
