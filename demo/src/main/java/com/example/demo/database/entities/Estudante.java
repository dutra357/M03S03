package com.example.demo.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;


@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String matricula;

    @ManyToMany(mappedBy = "estudantes")
    private List<Turma> turma;

    public Estudante() {}
    public Estudante(Long id, String nome, String matricula, List<Turma> turma) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudante estudante = (Estudante) o;
        return Objects.equals(getId(), estudante.getId()) && Objects.equals(getNome(), estudante.getNome()) && Objects.equals(getMatricula(), estudante.getMatricula()) && Objects.equals(getTurma(), estudante.getTurma());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getMatricula(), getTurma());
    }
}
