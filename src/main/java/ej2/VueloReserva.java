package ej2;

public class VueloReserva {
    public class ReservaVuelos {
        private TicketChecker check;

        public void setReservaVuelosHelper(TicketChecker check) {
            this.check = check;
        }

        private String convertirMesTexto(int mes){
            String[] meses = {
                    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
            };
            return meses[mes -1];
        }
        public String reservar(String destino, int cantidad, int dia, int mes, int gestion){
            if(check.existenPasajes(destino, cantidad)) {
                String diaSemana = check.getDay(dia, mes, gestion);
                String mesTexto = convertirMesTexto(mes);
                return String.format("el dia %s %d %s %d existen %d pasajes para %s", diaSemana, dia, mesTexto, gestion, cantidad, destino);
            } else {
                return String.format("no existen suficientes pasajes para %s", destino);
            }
        }
    }

}
