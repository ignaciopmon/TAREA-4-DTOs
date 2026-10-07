package com.salesianostriana.dam.tarea4dtos.ejercicio3.dto;

import com.salesianostriana.dam.tarea4dtos.ejercicio3.model.Autor;
import com.salesianostriana.dam.tarea4dtos.ejercicio3.model.Libro;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {

    public static LibroDTO of(Libro libro) {
        if (libro == null) {
            return null;
        }

        Autor autor = libro.getAutor();

        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                autor == null ? null
                        : autor.getNombre() + " " + autor.getApellido1()
                          + (autor.getApellido2() == null ? "" : " " + autor.getApellido2()),
                libro.getAnioPublicacion()
        );
    }
}
