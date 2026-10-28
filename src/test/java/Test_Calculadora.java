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

    @Test
    void debeSoportarSaltosDeLinea() {
        Calculadora calc = new Calculadora();
        assertEquals("6", calc.add("1\n2,3"));
    }

    @Test
    void debeDarErrorConFinalInesperado() {
        Calculadora calc = new Calculadora();
        assertEquals("Number expected but EOF found.", calc.add("1,3,"));
        assertEquals("Number expected but EOF found.", calc.add("1,3\n"));
    }

    @Test
    void debeSoportarDelimitadorPersonalizado() {
        Calculadora calc = new Calculadora();
        assertEquals("3", calc.add("//;\n1;2"));
        assertEquals("6", calc.add("//|\n1|2|3"));
        assertEquals("5", calc.add("//sep\n2sep3"));
    }

    @Test
    void debeDarErrorConUnNumeroNegativo() {
        Calculadora calc = new Calculadora();
        assertEquals("Negative not allowed : -1", calc.add("-1,2"));
    }

    @Test
    void debeDarErrorMostrandoTodosLosNegativos() {
        Calculadora calc = new Calculadora();
        assertEquals("Negative not allowed : -4, -5", calc.add("2,-4,-5"));
    }

}
