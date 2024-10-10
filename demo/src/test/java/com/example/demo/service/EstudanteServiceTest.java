package com.example.demo.service;

import com.example.demo.database.entities.Estudante;
import com.example.demo.database.repositories.EstudanteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstudanteServiceTest {

    @Mock
    EstudanteRepository repository;

    @InjectMocks
    EstudanteService estudanteService;
    Estudante estudante;
    List<Estudante> list;

    @BeforeEach
    public void setup() {
    }

    @Test
    void cadastrarEstudante() {
        Estudante estudante = new Estudante("Estudante 01", "Mat. 2222-15");

        when(repository.save(any())).thenReturn(estudante);

        Estudante retorno = estudanteService.cadastrarEstudante("Estudante 01", "Mat. 2222-15");

        assertNotNull(retorno);
        assertEquals(estudante.getNome(), retorno.getNome());
    }

    @Test
    void listarEstudantes() {
        Estudante estudante = new Estudante("Estudante 01", "Mat. 2222-15");

        when(repository.findAll()).thenReturn(list);

        List<Estudante> retorno = estudanteService.listarEstudantes();

        assertEquals(list, retorno);
    }

    @Test
    void buscarEstudantePorId() {
        Estudante estudante = new Estudante("Estudante 01", "Mat. 2222-15");

        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(estudante));

        estudanteService.buscarEstudantePorId(1L);

        assertDoesNotThrow( () ->
                estudanteService.buscarEstudantePorId(1L)
        );
    }

    @Test
    void atualizarEstudante() {
    }

    @Test
    void removerEstudante() {
    }
}