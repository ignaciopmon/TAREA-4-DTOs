package com.salesianostriana.dam.tarea4dtos.ejercicio4.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Cliente {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
}
