package ej1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DescuentoSalarioTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "-12345",
                    "-1234.5",
                    "-0.5",
            }
    )
    public void testSalarioNoValido(double salario){
        DescuentoSalario dsc = new DescuentoSalario();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dsc.calcularDescuento(salario);
        });
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "0,0",
                    "5,5",
                    "2000,2000",
                    "2023,1967.66",
                    "4555.71,3469.1",
                    "4000,3666",
            }
    )
    public void testCalcularDescuento(double salario, double descuentoEsperado){
        DescuentoSalario dsc = new DescuentoSalario();
        double descuentoActual = dsc.calcularDescuento(salario);

        Assertions.assertEquals(descuentoEsperado, descuentoActual);
    }
}