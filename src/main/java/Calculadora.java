public class Calculadora {
    public String add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        String delimitador = ",|\n";
        String numerosACortar = numbers;

        // Lógica de delimitadores personalizados
        if (numbers.startsWith("//")) {
            int finCabecera = numbers.indexOf("\n");
            String delimitadorPersonalizado = numbers.substring(2, finCabecera);
            delimitador = java.util.regex.Pattern.quote(delimitadorPersonalizado) + "|\n";
            numerosACortar = numbers.substring(finCabecera + 1);
        }

        // Actualizamos la validación EOF con la nueva variable
        if (numerosACortar.endsWith(",") || numerosACortar.endsWith("\n") ||
                (numbers.startsWith("//") && numerosACortar.endsWith(numbers.substring(2, numbers.indexOf("\n"))))) {
            return "Number expected but EOF found.";
        }

        String[] trozos = numerosACortar.split(delimitador);
        int suma = 0;

        for (int i = 0; i < trozos.length; i++) {
            String trozoLimpio = trozos[i].trim();
            if (!trozoLimpio.isEmpty()) {
                suma += Integer.parseInt(trozoLimpio);
            }
        }
        return String.valueOf(suma);
    }
}