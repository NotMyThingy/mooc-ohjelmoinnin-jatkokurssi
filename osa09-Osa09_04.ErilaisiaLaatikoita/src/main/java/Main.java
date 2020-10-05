

public class Main {

    public static void main(String[] args) {
        // Testaa ohjelmaasi täällä
        MaksimipainollinenLaatikko kahviLaatikko = new MaksimipainollinenLaatikko(10);
        kahviLaatikko.lisaa(new Tavara("Saludo", 5));
        kahviLaatikko.lisaa(new Tavara("Pirkka", 5));
        kahviLaatikko.lisaa(new Tavara("Kopi Luwak", 5));

        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Saludo")));
        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Pirkka")));
        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Kopi Luwak")));

        System.out.println("#############################################################");

        YhdenTavaranLaatikko laatikko = new YhdenTavaranLaatikko();
        laatikko.lisaa(new Tavara("Saludo", 5));
        laatikko.lisaa(new Tavara("Pirkka", 5));

        System.out.println(laatikko.onkoLaatikossa(new Tavara("Saludo")));
        System.out.println(laatikko.onkoLaatikossa(new Tavara("Pirkka")));

        System.out.println("#############################################################");

        HukkaavaLaatikko hukkaavaLaatikko = new HukkaavaLaatikko();
        hukkaavaLaatikko.lisaa(new Tavara("Saludo", 5));
        hukkaavaLaatikko.lisaa(new Tavara("Pirkka", 5));

        System.out.println(hukkaavaLaatikko.onkoLaatikossa(new Tavara("Saludo")));
        System.out.println(hukkaavaLaatikko.onkoLaatikossa(new Tavara("Pirkka")));
    }
}
