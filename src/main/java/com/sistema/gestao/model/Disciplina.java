package com.sistema.gestao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String codigo;
    private String nome;


    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Disciplina() {
    }
}
