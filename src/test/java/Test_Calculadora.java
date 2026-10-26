import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test_Calculadora {
    @Test
    void debeDevolverCeroSiEstaVacio() {
        Calculadora calc = new Calculadora();
        assertEquals("0", calc.add(""));
    }
}
