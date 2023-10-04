package ej1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

    public class DescuentoSalarioTest {

        @ParameterizedTest
        @CsvSource({ "1000, 0.0", "2000, 0.0", "2500, 0.05", "4500, 0.15" })
        public void testCalcularDescuento(double salario, double expectedDescuento) {
            assertEquals(expectedDescuento, DescuentoSalario.calcularDescuento(salario));
        }

        @Test
        public void testCalcularDescuentoSalarioInvalido() {
            assertThrows(IllegalArgumentException.class, () -> {
                DescuentoSalario.calcularDescuento(-100); // Salario negativo, se espera una excepción
            });
        }
    }