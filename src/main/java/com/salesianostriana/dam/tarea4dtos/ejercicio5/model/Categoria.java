package com.salesianostriana.dam.tarea4dtos.ejercicio5.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Categoria {

    private Long id;
    private String nombre;
    private String descripcion;
}
