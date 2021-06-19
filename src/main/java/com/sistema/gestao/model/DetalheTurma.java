package com.sistema.gestao.model;


import javax.persistence.OneToMany;


public class DetalheTurma {


    @OneToMany
    private Aluno aluno;
    @OneToMany
    private Professor professor;
    @OneToMany
    private Turma turma;

    public DetalheTurma() {

    }

    public DetalheTurma(Aluno aluno, Professor professor, Turma turma) {
        this.aluno = aluno;
        this.professor = professor;
        this.turma = turma;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
