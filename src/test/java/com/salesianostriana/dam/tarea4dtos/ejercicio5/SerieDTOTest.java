package com.salesianostriana.dam.tarea4dtos.ejercicio5;

import com.salesianostriana.dam.tarea4dtos.ejercicio5.dto.SerieDTO;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Categoria;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Creador;
import com.salesianostriana.dam.tarea4dtos.ejercicio5.model.Serie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SerieDTOTest {

    private final Creador creador = Creador.builder().nombre("Vince").apellidos("Gilligan").build();
    private final Categoria categoria = Categoria.builder().nombre("Drama").descripcion("Series de drama").build();

    @Test
    void serieCompleta() {
        Serie serie = Serie.builder().titulo("Breaking Bad").numeroTemporadas(5)
                .creador(creador).categoria(categoria)
                .imagenes(List.of("portada.jpg", "temporada1.jpg")).build();

        SerieDTO dto = SerieDTO.of(serie);

        assertEquals("Breaking Bad", dto.titulo());
        assertEquals(5, dto.temporadas());
        assertEquals("Vince Gilligan", dto.creador());
        assertEquals("Drama", dto.categoria());
        assertEquals("portada.jpg", dto.imagenPrincipal());
    }

    @Test
    void serieSinCategoria() {
        Serie serie = Serie.builder().titulo("Better Call Saul").creador(creador)
                .imagenes(List.of("portada.jpg")).build();

        assertNull(SerieDTO.of(serie).categoria());
    }

    @Test
    void serieSinCreador() {
        Serie serie = Serie.builder().titulo("Anónima").categoria(categoria).build();

        assertNull(SerieDTO.of(serie).creador());
    }

    @Test
    void serieSinImagenes() {
        Serie serie = Serie.builder().titulo("La casa de papel").creador(creador).categoria(categoria).build();

        assertNull(SerieDTO.of(serie).imagenPrincipal());
    }

    @Test
    void serieConImagenesVacia() {
        Serie serie = Serie.builder().titulo("Vis a vis").imagenes(new ArrayList<>()).build();

        assertNull(SerieDTO.of(serie).imagenPrincipal());
    }

    @Test
    void serieNull() {
        assertNull(SerieDTO.of(null));
    }
}
