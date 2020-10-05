

public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("maito", 3, 10);
        varasto.lisaaTuote("kahvi", 5, 6);
        varasto.lisaaTuote("piima", 2, 20);
        varasto.lisaaTuote("jugurtti", 2, 20);

        System.out.println("tuotteet:");

        for (String tuote : varasto.tuotteet()) {
            System.out.println(tuote);
        }
    }
}
