package com.salesianostriana.dam.tarea4dtos.ejercicio3;

import com.salesianostriana.dam.tarea4dtos.ejercicio3.dto.LibroDTO;
import com.salesianostriana.dam.tarea4dtos.ejercicio3.model.Autor;
import com.salesianostriana.dam.tarea4dtos.ejercicio3.model.Libro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class PruebasEjercicio3 implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\n===== EJERCICIO 3. LIBROS Y AUTORES =====");

        Autor cervantes = Autor.builder()
                .id(1L)
                .nombre("Miguel")
                .apellido1("de Cervantes")
                .apellido2("Saavedra")
                .nacionalidad("Española")
                .build();

        Autor orwell = Autor.builder()
                .id(2L)
                .nombre("George")
                .apellido1("Orwell")
                .nacionalidad("Británica")
                .build();

        Libro quijote = Libro.builder()
                .id(1L)
                .titulo("Don Quijote de la Mancha")
                .isbn("978-84-376-0494-7")
                .anioPublicacion(1605)
                .numeroPaginas(1376)
                .autor(cervantes)
                .build();

        Libro libro1984 = Libro.builder()
                .id(2L)
                .titulo("1984")
                .isbn("978-84-9989-174-6")
                .anioPublicacion(1949)
                .numeroPaginas(352)
                .autor(orwell)
                .build();

        Libro lazarillo = Libro.builder()
                .id(3L)
                .titulo("Lazarillo de Tormes")
                .isbn("978-84-206-6082-4")
                .anioPublicacion(1554)
                .numeroPaginas(176)
                .build();

        List<Libro> libros = Arrays.asList(quijote, libro1984, lazarillo, null);

        libros.forEach(libro -> System.out.println(LibroDTO.of(libro)));
    }
}
