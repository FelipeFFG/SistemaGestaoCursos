package com.sistema.gestao.dto;


import com.sistema.gestao.model.Professor;
import com.sistema.gestao.model.Turma;

import javax.persistence.OneToMany;

public class RequisicaoProfessor {


    private Integer id;
    private String nome;
    private String sexo;
    private String registro;
    private Integer turma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTurma() {
        return turma;
    }

    public void setTurma(Integer turma) {
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }


    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setSexo(sexo);
        professor.setRegistro(registro);
        return professor;
    }
}
