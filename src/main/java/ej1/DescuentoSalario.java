package ej1;

public class DescuentoSalario {
    public static double calcularDescuento(double salario) {
        if (salario < 0){
            throw new IllegalArgumentException("salario negativo");
        }
        if (salario <= 2000){
            return salario;
        } else if (salario <= 4000){
            return Math.round(salario * 0.95);
        } else {
            return salario * 0.9;
        }
    }
    }
