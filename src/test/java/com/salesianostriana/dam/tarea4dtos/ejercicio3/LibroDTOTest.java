package com.salesianostriana.dam.tarea4dtos.ejercicio3;

import com.salesianostriana.dam.tarea4dtos.ejercicio3.dto.LibroDTO;
import com.salesianostriana.dam.tarea4dtos.ejercicio3.model.Autor;
import com.salesianostriana.dam.tarea4dtos.ejercicio3.model.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroDTOTest {

    @Test
    void libroCompleto() {
        Autor autor = Autor.builder().nombre("Miguel").apellido1("de Cervantes").apellido2("Saavedra").build();
        Libro libro = Libro.builder().titulo("Don Quijote").isbn("123").anioPublicacion(1605).autor(autor).build();

        LibroDTO dto = LibroDTO.of(libro);

        assertEquals("Don Quijote", dto.titulo());
        assertEquals("123", dto.isbn());
        assertEquals("Miguel de Cervantes Saavedra", dto.autor());
        assertEquals(1605, dto.anioPublicacion());
    }

    @Test
    void libroNull() {
        assertNull(LibroDTO.of(null));
    }

    @Test
    void libroSinAutor() {
        Libro libro = Libro.builder().titulo("Lazarillo de Tormes").isbn("456").anioPublicacion(1554).build();

        LibroDTO dto = LibroDTO.of(libro);

        assertEquals("Lazarillo de Tormes", dto.titulo());
        assertNull(dto.autor());
    }

    @Test
    void autorSinSegundoApellido() {
        Autor autor = Autor.builder().nombre("George").apellido1("Orwell").build();
        Libro libro = Libro.builder().titulo("1984").autor(autor).build();

        assertEquals("George Orwell", LibroDTO.of(libro).autor());
    }

}
