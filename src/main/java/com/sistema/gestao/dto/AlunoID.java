package com.sistema.gestao.dto;

public class AlunoID {

    private Integer id;
    private String matricula;

    public Integer getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlunoID(Integer id) {
        this.id = id;
    }

    public AlunoID() {
    }
}
