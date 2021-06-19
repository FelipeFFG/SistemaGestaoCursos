package com.sistema.gestao.dto;

import com.sistema.gestao.model.Curso;

public class RequisicaoCurso {


    private  Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso toCurso(){
        Curso curso = new Curso();
        curso.setNome(nome);
        return curso;
    }
}
