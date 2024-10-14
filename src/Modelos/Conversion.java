package Modelos;

public record Conversion(String base_code, String target_code, double conversion_result, double conversion_rate) {
    @Override
    public String toString() {
        return ("%.2f %s => %.2f %s").formatted(conversion_result / conversion_rate, base_code, conversion_result, target_code);
    }
}
