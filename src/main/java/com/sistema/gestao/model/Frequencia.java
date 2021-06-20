package com.sistema.gestao.model;

import javax.persistence.*;

import java.sql.Date;

@Entity
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date frequencia;
    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    @ManyToOne
    private Professor professor;

    public Frequencia() {
    }

    public Frequencia(Date frequencia, Aluno aluno, Professor professor) {
        this.frequencia = frequencia;
        this.aluno = aluno;
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Date frequencia) {
        this.frequencia = frequencia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
