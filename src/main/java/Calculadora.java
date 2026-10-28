import java.util.*;

public class Calculadora {
    public String add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        String delimitador = ",|\n";
        String numerosACortar = numbers;

        if (numbers.startsWith("//")) {
            int finCabecera = numbers.indexOf("\n");
            String delimitadorPersonalizado = numbers.substring(2, finCabecera);
            delimitador = java.util.regex.Pattern.quote(delimitadorPersonalizado) + "|\n";
            numerosACortar = numbers.substring(finCabecera + 1);
        }

        if (numerosACortar.endsWith(",") || numerosACortar.endsWith("\n") ||
                (numbers.startsWith("//") && numerosACortar.endsWith(numbers.substring(2, numbers.indexOf("\n"))))) {
            return "Number expected but EOF found.";
        }

        String[] trozos = numerosACortar.split(delimitador);

        int suma = 0;
        List<String> negativos = new ArrayList<>(); // Nueva lista para negativos

        for (int i = 0; i < trozos.length; i++) {
            String trozoLimpio = trozos[i].trim();
            if (!trozoLimpio.isEmpty()) {
                int numero = Integer.parseInt(trozoLimpio);

                if (numero < 0) {
                    negativos.add(String.valueOf(numero));
                }

                suma += numero;
            }
        }

        // Lanzar error si hay negativos
        if (!negativos.isEmpty()) {
            return "Negative not allowed : " + String.join(", ", negativos);
        }

        return String.valueOf(suma);
    }
}