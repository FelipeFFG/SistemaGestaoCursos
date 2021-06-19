package com.sistema.gestao.model;

import javax.persistence.*;

@Entity
public class Turma {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer id;
    private String nome;

    private String escrita_curso;

    @ManyToOne()
    private Curso curso;


    public void setEscrita_curso(String escrita_curso) {
        this.escrita_curso = escrita_curso;
    }

    public Turma() {
    }

    public Turma(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public String getEscrita_curso(){
        escrita_curso = curso.getNome();
        return escrita_curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
