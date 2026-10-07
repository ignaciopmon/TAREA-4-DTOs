package com.salesianostriana.dam.tarea4dtos.ejercicio4;

import com.salesianostriana.dam.tarea4dtos.ejercicio4.dto.ReservaDTO;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Cliente;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Habitacion;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Reserva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservaDTOTest {

    private final Cliente cliente = Cliente.builder().nombre("Ana").apellidos("García López").build();
    private final Habitacion habitacion = Habitacion.builder().numero("204").tipo("Doble").precioNoche(85.5).build();

    @Test
    void reservaCompleta() {
        Reserva reserva = Reserva.builder().codigo("RES-001").numeroNoches(3)
                .cliente(cliente).habitacion(habitacion).build();

        ReservaDTO dto = ReservaDTO.of(reserva);

        assertEquals("RES-001", dto.codigo());
        assertEquals("Ana García López", dto.cliente());
        assertEquals("204 - Doble", dto.habitacion());
        assertEquals(3, dto.numeroNoches());
        assertEquals(256.5, dto.precioTotal());
    }

    @Test
    void reservaNull() {
        assertNull(ReservaDTO.of(null));
    }

    @Test
    void reservaSinCliente() {
        Reserva reserva = Reserva.builder().codigo("RES-002").numeroNoches(2).habitacion(habitacion).build();

        ReservaDTO dto = ReservaDTO.of(reserva);

        assertNull(dto.cliente());
        assertEquals(171.0, dto.precioTotal());
    }

    @Test
    void reservaSinHabitacion() {
        Reserva reserva = Reserva.builder().codigo("RES-003").numeroNoches(4).cliente(cliente).build();

        ReservaDTO dto = ReservaDTO.of(reserva);

        assertNull(dto.habitacion());
        assertNull(dto.precioTotal());
        assertEquals(4, dto.numeroNoches());
    }

    @Test
    void reservaSinNumeroNoches() {
        Reserva reserva = Reserva.builder().codigo("RES-004").cliente(cliente).habitacion(habitacion).build();

        ReservaDTO dto = ReservaDTO.of(reserva);

        assertNull(dto.numeroNoches());
        assertNull(dto.precioTotal());
        assertEquals("204 - Doble", dto.habitacion());
    }

    @Test
    void habitacionSinPrecioNoche() {
        Habitacion sinPrecio = Habitacion.builder().numero("501").tipo("Suite").build();
        Reserva reserva = Reserva.builder().codigo("RES-005").numeroNoches(1)
                .cliente(cliente).habitacion(sinPrecio).build();

        ReservaDTO dto = ReservaDTO.of(reserva);

        assertEquals("501 - Suite", dto.habitacion());
        assertNull(dto.precioTotal());
    }

}
