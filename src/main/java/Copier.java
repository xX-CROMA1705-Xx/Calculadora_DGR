public class Copier {
    private final Source source;
    private final Destination destination;

    public Copier(Source source, Destination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {
        String texto = source.read();

        // Mientras el origen nos siga dando texto (no sea null), seguimos copiando
        while (texto != null) {
            destination.write(texto);
            texto = source.read(); // Leemos el siguiente
        }
    }
}