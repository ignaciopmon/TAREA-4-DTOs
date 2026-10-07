package com.salesianostriana.dam.tarea4dtos.ejercicio4.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Habitacion {

    private Long id;
    private String numero;
    private String tipo;
    private Double precioNoche;
    private Integer planta;
}
