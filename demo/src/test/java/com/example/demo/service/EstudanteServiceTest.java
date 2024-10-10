package com.example.demo.service;

import com.example.demo.database.entities.Estudante;
import com.example.demo.database.repositories.EstudanteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstudanteServiceTest {

    @Mock
    EstudanteRepository estudanteRepository;

    @InjectMocks
    EstudanteService estudanteService;



    @BeforeEach
    public void setup() {
    }

    @Test
    void cadastrarEstudante() {

        Estudante estudante = new Estudante(1l, "Estudante 01", "Mat. 2222-15", Collections.emptyList());
        when(estudanteRepository.save(any(Estudante.class))).thenReturn(estudante);

        Estudante retorno = estudanteService.cadastrarEstudante("Estudante 01", "Mat. 2222-15");

        verify(estudanteRepository).save(any(Estudante.class));

        assertNotNull(retorno);
        assertEquals(estudante.getNome(), retorno.getNome());
    }

    @Test
    void listarEstudantes() {
        Estudante estudante = new Estudante(1l, "Estudante 01", "Mat. 2222-15", Collections.emptyList());

        when(estudanteRepository.findAll()).thenReturn(List.of(estudante));

        List<Estudante> retorno = estudanteService.listarEstudantes();

        verify(estudanteRepository).findAll();
        assertEquals(estudante.getNome(), retorno.get(0).getNome());
    }

    @Test
    void buscarEstudantePorId() {
        Estudante estudante = new Estudante(1l, "Estudante 01", "Mat. 2222-15", Collections.emptyList());

        when(estudanteRepository.findById(anyLong())).thenReturn(Optional.ofNullable(estudante));

        Estudante resultado = estudanteService.buscarEstudantePorId(1L);

        verify(estudanteRepository).findById(anyLong());
        assertEquals(estudante.getNome(), resultado.getNome());
    }

    @Test
    void atualizarEstudante() {

        Estudante estudante = new Estudante(1l, "Estudante 01", "Mat. 2222-15", Collections.emptyList());

        when(estudanteRepository.save(estudante)).thenReturn(estudante);
        when(estudanteRepository.findById(anyLong())).thenReturn(Optional.ofNullable(estudante));

        Estudante update = estudanteService.atualizarEstudante(1L, "Novo NOME", "Mat. 0000-00");

        verify(estudanteRepository).findById(anyLong());
        verify(estudanteRepository).save(any(Estudante.class));

        assertNotNull(update);
        assertEquals(update.getNome(), "Novo NOME");

    }

    @Test
    void removerEstudante() {

        estudanteService.removerEstudante(1L);

        verify(estudanteRepository).deleteById(anyLong());

    }
}