package com.salesianostriana.dam.tarea4dtos.ejercicio4.dto;

import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Cliente;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Habitacion;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Reserva;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {

    public static ReservaDTO of(Reserva reserva) {
        if (reserva == null) {
            return null;
        }

        Cliente cliente = reserva.getCliente();
        Habitacion habitacion = reserva.getHabitacion();
        Integer noches = reserva.getNumeroNoches();

        return new ReservaDTO(
                reserva.getCodigo(),
                cliente == null ? null : cliente.getNombre() + " " + cliente.getApellidos(),
                habitacion == null ? null : habitacion.getNumero() + " - " + habitacion.getTipo(),
                noches,
                noches == null || habitacion == null || habitacion.getPrecioNoche() == null
                        ? null
                        : noches * habitacion.getPrecioNoche()
        );
    }
}
