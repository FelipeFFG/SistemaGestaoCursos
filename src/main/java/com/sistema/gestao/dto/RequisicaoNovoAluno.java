package com.sistema.gestao.dto;

import com.sistema.gestao.model.Aluno;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
public class RequisicaoNovoAluno {

    @NotBlank
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sexo;
    @NotBlank
    private String matricula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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


    public Aluno toAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setSexo(sexo);
        aluno.setMatricula(matricula);
        return aluno;
    }


}
