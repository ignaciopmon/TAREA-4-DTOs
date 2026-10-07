package com.salesianostriana.dam.tarea4dtos.ejercicio3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Autor {

    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nacionalidad;
}
