package com.sistema.gestao.dto;

import com.sistema.gestao.model.Disciplina;

public class RequisicaoDiciplina {


    private Integer id;
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

    public Disciplina toDisciplina(){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        return disciplina;
    }
}
