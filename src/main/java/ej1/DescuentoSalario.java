package ej1;

public class DescuentoSalario {
    public static double calcularDescuento(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salario no válido");
        } else if (salario <= 2000) {
            return 0.0;
        } else if (salario <= 4000) {
            return 0.05;
        } else {
            return 0.15;
        }
    }
}
