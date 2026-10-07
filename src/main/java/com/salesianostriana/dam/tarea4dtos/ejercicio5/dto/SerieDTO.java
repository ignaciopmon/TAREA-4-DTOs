package com.salesianostriana.dam.tarea4dtos.ejercicio5.dto;

import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Categoria;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Creador;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Serie;

import java.util.List;

public record SerieDTO(
        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal
) {

    public static SerieDTO of(Serie serie) {
        if (serie == null) {
            return null;
        }

        Creador creador = serie.getCreador();
        Categoria categoria = serie.getCategoria();
        List<String> imagenes = serie.getImagenes();

        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                creador == null ? null : creador.getNombre() + " " + creador.getApellidos(),
                categoria == null ? null : categoria.getNombre(),
                imagenes == null || imagenes.isEmpty() ? null : imagenes.get(0)
        );
    }
}
