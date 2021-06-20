package com.sistema.gestao.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Nota {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer nota;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Aluno aluno;
    @ManyToOne
    private Professor professor;

    public Nota() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
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

    public Nota(Integer nota, Aluno aluno, Professor professor) {
        this.nota = nota;
        this.aluno = aluno;
        this.professor = professor;
    }
}
