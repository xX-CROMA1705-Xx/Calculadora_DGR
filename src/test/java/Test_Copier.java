import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Test_Copier {

    @Test
    void debeCopiarTextoDelOrigenAlDestino() {
        // Arrange (Preparación)
        Source mockSource = mock(Source.class);
        Destination mockDestination = mock(Destination.class);

        // Simulamos que el Source devuelve "Hola" cuando le piden leer
        when(mockSource.read()).thenReturn("Hola");

        Copier copier = new Copier(mockSource, mockDestination);

        // Act (Ejecución)
        copier.copy();

        // Assert (Verificación)
        // Comprobamos que Copier realmente le mandó "Hola" al Destination
        verify(mockDestination).write("Hola");
    }
}