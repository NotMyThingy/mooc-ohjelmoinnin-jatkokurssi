public class YhdenTavaranLaatikko extends Laatikko {

    private Tavara tavara;

    public YhdenTavaranLaatikko() {
        this.tavara = null;
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (this.tavara != null) {
            return;
        }

        this.tavara = tavara;
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        if (this.tavara == null) {
            return false;
        }

        return this.tavara.equals(tavara);
    }
}
