

public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("maito", 3, 10);
        varasto.lisaaTuote("kahvi", 5, 7);

        System.out.println("hinnat:");
        System.out.println("maito: " + varasto.hinta("maito"));
        System.out.println("kahvi: " + varasto.hinta("kahvi"));
        System.out.println("sokeri: " + varasto.hinta("sokeri"));
    }
}
