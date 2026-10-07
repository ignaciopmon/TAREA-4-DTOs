package com.salesianostriana.dam.tarea4dtos.ejercicio5.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Serie {

    private Long id;
    private String titulo;
    private String sinopsis;
    private Integer numeroTemporadas;
    private Creador creador;
    private Categoria categoria;
    private List<String> imagenes;
}
