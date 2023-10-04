package ej2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class VueloReservaTest {
       TicketChecker ticketCheckerMock = Mockito.mock(TicketChecker.class);
        @Test
        public void verifyReservaDeVuelosConPasajesDispo(){
            Mockito.when(ticketCheckerMock.existenPasajes("Sucre", 2)).thenReturn(true);
            Mockito.when(ticketCheckerMock.getDay(29, 5, 2023)).thenReturn("Domingo");

            VueloReserva vr = new VueloReserva();
            vr.setTicketChecker(ticketCheckerMock);

            String actualResult = vr.reservar("Sucre", 3, 28, 4, 2024);
            String expectedResult = "el dia Domingo 28 Abril 2024 existen 2 pasajes para Sucre";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            Mockito.verify(ticketCheckerMock).existenPasajes("Sucre", 3);
            Mockito.verify(ticketCheckerMock).getDay(28, 4, 2024);
        }

        @Test
        public void verifyReservaDeVuelosSinPasajesDispo(){
            Mockito.when(ticketCheckerMock.existenPasajes("Cochabamba", 1)).thenReturn(false);
            Mockito.when(ticketCheckerMock.getDay(4, 10, 2023)).thenReturn("Lunes");

            VueloReserva reservaVuelos = new VueloReserva();
            reservaVuelos.setTicketChecker(ticketCheckerMock);

            String actualResult = reservaVuelos.reservar("Cochabamba", 5, 21, 9, 2023);
            String expectedResult = "no existen suficientes pasajes para Cochabamba";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            Mockito.verify(ticketCheckerMock).existenPasajes("La Paz", 5);
        }

        @Test
        public void verifyReservaDeVuelosConDiferenteDestino(){
            //Mockear metodos
            Mockito.when(ticketCheckerMock.existenPasajes("Santa Cruz", 2)).thenReturn(true);
            Mockito.when(ticketCheckerMock.getDay(30, 5, 2023)).thenReturn("Jueves");

            VueloReserva vr = new VueloReserva();
            vr.setTicketChecker(ticketCheckerMock);

            String actualResult = vr.reservar("Santa Cruz", 2, 30, 5, 2023);
            String expectedResult = "el dia Jueves 30 Mayo 2023 existen 2 pasajes para Santa Cruz";

            Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva de vuelo es incorrecta.");

            Mockito.verify(ticketCheckerMock).existenPasajes("Santa Cruz", 2);
            Mockito.verify(ticketCheckerMock).getDay(30, 5, 2023);
        }

    }

