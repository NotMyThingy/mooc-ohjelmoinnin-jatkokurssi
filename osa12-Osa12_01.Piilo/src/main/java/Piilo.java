public class Piilo<T> {

    private T piilotettava;

    public Piilo() {
        piilotettava = null;
    }

    public void laitaPiiloon(T piilotettava) {
        this.piilotettava = piilotettava;
    }

    public T otaPiilosta() {
        T t = piilotettava;
        piilotettava = null;
        return t;
    }

    public boolean onkoPiilossa() {
        return piilotettava != null;
    }
}
