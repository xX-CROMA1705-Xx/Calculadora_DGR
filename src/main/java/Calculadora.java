public class Calculadora {
    public String add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        // Refactor: cambiamos el split para aceptar comas o saltos de linea
        String[] trozos = numbers.split(",|\n");
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