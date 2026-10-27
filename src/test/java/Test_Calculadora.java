import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test_Calculadora {
    @Test
    void debeDevolverCeroSiEstaVacio() {
        Calculadora calc = new Calculadora();
        assertEquals("0", calc.add(""));
    }

    @Test
    void debeSumarNumerosConComas() {
        Calculadora calc = new Calculadora();
        assertEquals("1", calc.add("1"));
        assertEquals("3", calc.add("1,2"));
        assertEquals("15", calc.add("1,2,3,4,5"));
    }

}
