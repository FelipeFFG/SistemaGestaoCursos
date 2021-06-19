package com.sistema.gestao.dto;

import com.sistema.gestao.model.Aluno;

import java.sql.Date;
import java.time.LocalDate;


public class RequisicaoNovoAluno {


    private Integer id;

    private String nome;

    private String sexo;

    private String matricula;

    private Date dataNascimento;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

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
        aluno.setDataNascimento(dataNascimento);
        return aluno;
    }


}
