package com.sistema.gestao.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;


@Entity
public class AlunoTurma {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    private Turma turma;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Aluno aluno;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoTurma() {
    }

    public AlunoTurma(Turma turma, Aluno aluno) {
        this.turma = turma;
        this.aluno = aluno;
    }
}
