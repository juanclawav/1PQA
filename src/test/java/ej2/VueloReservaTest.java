package ej2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class VueloReservaTest {

       TicketChecker ticketCheckerMock = Mockito.mock(TicketChecker.class);

        @Test
        public void verifyReservaDeVuelosConPasajesDispo(){
            Mockito.when(ticketCheckerMock.existenPasajes("La Paz", 2)).thenReturn(true);
            Mockito.when(ticketCheckerMock.getDay(29, 5, 2023)).thenReturn("Lunes");

            VueloReserva vr = new VueloReserva();
            vr.setTicketChecker(ticketCheckerMock);

            //output: "el dia Lunes 29 Mayo 2023 existen
            String actualResult = vr.reservar("La Paz", 2, 29, 5, 2023);
            String expectedResult = "el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            //Verificar que los metodos mockeados se invocaron correctamente
            Mockito.verify(reservaVuelosHelperMock).existenPasajes("La Paz", 2);
            Mockito.verify(reservaVuelosHelperMock).getDay(29, 5, 2023);
        }

        @Test
        public void verifyReservaDeVuelosSinPasajesDispo(){
            //Mockear metodos
            //ejemplos:
            //input: La Paz, 10 , 10 , 7 , 2023
            Mockito.when(reservaVuelosHelperMock.existenPasajes("La Paz", 10)).thenReturn(false);
            Mockito.when(reservaVuelosHelperMock.getDay(7, 8, 2023)).thenReturn("Lunes");

            ReservaVuelos reservaVuelos = new ReservaVuelos();
            reservaVuelos.setReservaVuelosHelper(reservaVuelosHelperMock);

            //output: "no existen suficientes pasajes para La Paz"
            String actualResult = reservaVuelos.reservaVuelo("La Paz", 10, 10, 7, 2023);
            String expectedResult = "no existen suficientes pasajes para La Paz";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            //Verificar que los metodos mockeados se invocaron correctamente
            Mockito.verify(reservaVuelosHelperMock).existenPasajes("La Paz", 10);
        }

        @Test
        public void verifyReservaDeVuelosConDiferenteDestino(){
            //Mockear metodos
            Mockito.when(reservaVuelosHelperMock.existenPasajes("Santa Cruz", 2)).thenReturn(true);
            Mockito.when(reservaVuelosHelperMock.getDay(17, 3, 2023)).thenReturn("Viernes");

            ReservaVuelos reservaVuelos = new ReservaVuelos();
            reservaVuelos.setReservaVuelosHelper(reservaVuelosHelperMock);

            String actualResult = reservaVuelos.reservaVuelo("Santa Cruz", 2, 17, 3, 2023);
            String expectedResult = "el dia Viernes 17 Marzo 2023 existen 2 pasajes para Santa Cruz";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            //Verificar que los metodos mockeados se invocaron correctamente
            Mockito.verify(reservaVuelosHelperMock).existenPasajes("Santa Cruz", 2);
            Mockito.verify(reservaVuelosHelperMock).getDay(17, 3, 2023);
        }

        @Test
        public void verifyReservaDeVuelosConMesCorrecto(){
            //Mockear metodos
            Mockito.when(reservaVuelosHelperMock.existenPasajes("Cochabamba", 3)).thenReturn(true);
            Mockito.when(reservaVuelosHelperMock.getDay(3, 10, 2023)).thenReturn("Jueves");

            ReservaVuelos reservaVuelos = new ReservaVuelos();
            reservaVuelos.setReservaVuelosHelper(reservaVuelosHelperMock);

            String actualResult = reservaVuelos.reservaVuelo("Cochabamba", 3, 3, 10, 2023);
            String expectedResult = "el dia Jueves 3 Octubre 2023 existen 3 pasajes para Cochabamba";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            //Verificar que los metodos mockeados se invocaron correctamente
            Mockito.verify(reservaVuelosHelperMock).existenPasajes("Cochabamba", 3);
            Mockito.verify(reservaVuelosHelperMock).getDay(3, 10, 2023);
        }
    }
}
