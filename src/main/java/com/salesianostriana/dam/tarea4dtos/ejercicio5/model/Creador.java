package com.salesianostriana.dam.tarea4dtos.ejercicio5.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Creador {

    private Long id;
    private String nombre;
    private String apellidos;
    private String pais;
}
