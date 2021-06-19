package com.sistema.gestao.dto;


import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Turma;
import com.sistema.gestao.repository.CursoRepository;

import javax.persistence.ManyToOne;
import java.util.List;

public class RequisicaoTurma {

    private String nome;
    private Curso curso;
    private Integer id_curso;

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
