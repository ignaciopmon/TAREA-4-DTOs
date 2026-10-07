package com.salesianostriana.dam.tarea4dtos.ejercicio4;

import com.salesianostriana.dam.tarea4dtos.ejercicio4.dto.ReservaDTO;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Cliente;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Habitacion;
import com.salesianostriana.dam.tarea4dtos.ejercicio4.model.Reserva;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Order(2)
public class PruebasEjercicio4 implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\n===== EJERCICIO 4. RESERVAS DE HOTEL =====");

        Cliente ana = Cliente.builder()
                .id(1L)
                .nombre("Ana")
                .apellidos("García López")
                .email("ana.garcia@email.com")
                .telefono("600111222")
                .build();

        Habitacion doble = Habitacion.builder()
                .id(1L)
                .numero("204")
                .tipo("Doble")
                .precioNoche(85.5)
                .planta(2)
                .build();

        Habitacion suiteSinPrecio = Habitacion.builder()
                .id(2L)
                .numero("501")
                .tipo("Suite")
                .planta(5)
                .build();

        Reserva completa = Reserva.builder()
                .id(1L)
                .codigo("RES-001")
                .numeroNoches(3)
                .cliente(ana)
                .habitacion(doble)
                .build();

        Reserva sinCliente = Reserva.builder()
                .id(2L)
                .codigo("RES-002")
                .numeroNoches(2)
                .habitacion(doble)
                .build();

        Reserva sinHabitacion = Reserva.builder()
                .id(3L)
                .codigo("RES-003")
                .numeroNoches(4)
                .cliente(ana)
                .build();

        Reserva sinNoches = Reserva.builder()
                .id(4L)
                .codigo("RES-004")
                .cliente(ana)
                .habitacion(doble)
                .build();

        Reserva sinPrecioNoche = Reserva.builder()
                .id(5L)
                .codigo("RES-005")
                .numeroNoches(1)
                .cliente(ana)
                .habitacion(suiteSinPrecio)
                .build();

        List<Reserva> reservas = Arrays.asList(
                completa, sinCliente, sinHabitacion, sinNoches, sinPrecioNoche, null);

        reservas.forEach(reserva -> System.out.println(ReservaDTO.of(reserva)));
    }
}
