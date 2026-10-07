package com.salesianostriana.dam.tarea4dtos.ejercicio3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Libro {

    private Long id;
    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private Integer numeroPaginas;
    private Autor autor;
}
