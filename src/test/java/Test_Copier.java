import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Test_Copier {

    @Test
    void debeCopiarTextoDelOrigenAlDestino() {
        Source mockSource = mock(Source.class);
        Destination mockDestination = mock(Destination.class);

        when(mockSource.read()).thenReturn("Hola").thenReturn(null);

        Copier copier = new Copier(mockSource, mockDestination);
        copier.copy();

        verify(mockDestination).write("Hola");
    }

    @Test
    void debeCopiarVariosTextosHastaQueNoHayaMas() {
        Source mockSource = mock(Source.class);
        Destination mockDestination = mock(Destination.class);

        // Simulamos que devuelve "Hola", luego "Mundo", y luego null (fin)
        when(mockSource.read()).thenReturn("Hola", "Mundo", null);

        Copier copier = new Copier(mockSource, mockDestination);
        copier.copy();

        // Verificamos que llamó a write dos veces con los textos correctos
        verify(mockDestination).write("Hola");
        verify(mockDestination).write("Mundo");
        // Verificamos que NUNCA intentó escribir un null
        verify(mockDestination, never()).write(null);
    }
}