public class MuistavaTuotevarasto extends Tuotevarasto {

    private final Muutoshistoria muutoshistoria;

    public MuistavaTuotevarasto(String nimi, double tilavuus, double alkuSaldo) {
        super(nimi, tilavuus);
        this.muutoshistoria = new Muutoshistoria();

        super.lisaaVarastoon(alkuSaldo);
        this.muutoshistoria.lisaa(alkuSaldo);
    }

    public String historia() {
        return muutoshistoria.toString();
    }

    @Override
    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        muutoshistoria.lisaa(getSaldo());
    }

    @Override
    public double otaVarastosta(double maara) {
        double otettuVarastosta = super.otaVarastosta(maara);
        muutoshistoria.lisaa(getSaldo());

        return otettuVarastosta;
    }

    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + getNimi());
        System.out.println("Historia: " + historia());
        System.out.println("Suurin tuotemäärä: " + muutoshistoria.maxArvo());
        System.out.println("Pienin tuotemäärä: " + muutoshistoria.minArvo());
        System.out.println("Keskiarvo: " + muutoshistoria.keskiarvo());
    }
}
