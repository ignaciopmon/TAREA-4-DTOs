package com.salesianostriana.dam.tarea4dtos.ejercicio5;

import com.salesianostriana.dam.tarea4dtos.ejercicio5.dto.SerieDTO;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Categoria;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Creador;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Serie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class PruebasEjercicio5 implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\n===== EJERCICIO 5. SERIES DE UNA PLATAFORMA DE STREAMING =====");

        Creador vinceGilligan = Creador.builder()
                .id(1L)
                .nombre("Vince")
                .apellidos("Gilligan")
                .pais("Estados Unidos")
                .build();

        Creador alexPina = Creador.builder()
                .id(2L)
                .nombre("Álex")
                .apellidos("Pina")
                .pais("España")
                .build();

        Categoria drama = Categoria.builder()
                .id(1L)
                .nombre("Drama")
                .descripcion("Series de drama")
                .build();

        Categoria thriller = Categoria.builder()
                .id(2L)
                .nombre("Thriller")
                .descripcion("Series de suspense")
                .build();

        Serie completa = Serie.builder()
                .id(1L)
                .titulo("Breaking Bad")
                .sinopsis("Un profesor de química se convierte en fabricante de droga.")
                .numeroTemporadas(5)
                .creador(vinceGilligan)
                .categoria(drama)
                .imagenes(List.of(
                        "https://img.ejemplo.com/breaking-bad/portada.jpg",
                        "https://img.ejemplo.com/breaking-bad/temporada1.jpg"))
                .build();

        Serie sinCategoria = Serie.builder()
                .id(2L)
                .titulo("Better Call Saul")
                .sinopsis("La historia de Jimmy McGill.")
                .numeroTemporadas(6)
                .creador(vinceGilligan)
                .imagenes(List.of("https://img.ejemplo.com/better-call-saul/portada.jpg"))
                .build();

        Serie sinImagenes = Serie.builder()
                .id(3L)
                .titulo("La casa de papel")
                .sinopsis("Un grupo de atracadores asalta la Fábrica de Moneda y Timbre.")
                .numeroTemporadas(5)
                .creador(alexPina)
                .categoria(thriller)
                .build();

        Serie imagenesVacia = Serie.builder()
                .id(4L)
                .titulo("Vis a vis")
                .sinopsis("Una joven ingresa en prisión.")
                .numeroTemporadas(4)
                .creador(alexPina)
                .categoria(drama)
                .imagenes(new ArrayList<>())
                .build();

        Serie sinCreador = Serie.builder()
                .id(5L)
                .titulo("Serie anónima")
                .numeroTemporadas(1)
                .categoria(drama)
                .imagenes(List.of("https://img.ejemplo.com/anonima/portada.jpg"))
                .build();

        System.out.println("1. Completa:       " + SerieDTO.of(completa));
        System.out.println("2. Sin categoría:  " + SerieDTO.of(sinCategoria));
        System.out.println("3. Sin imágenes:   " + SerieDTO.of(sinImagenes));
        System.out.println("4. Imágenes vacía: " + SerieDTO.of(imagenesVacia));
        System.out.println("5. null:           " + SerieDTO.of(null));
        System.out.println("Extra. Sin creador: " + SerieDTO.of(sinCreador));
    }
}
