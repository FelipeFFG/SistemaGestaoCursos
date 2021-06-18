package com.sistema.gestao.dto;

import com.sistema.gestao.model.Aluno;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
public class RequisicaoNovoAluno {

    @NotBlank
    private String nome;
    @NotBlank
    private String sexo;
    @NotBlank
    private LocalDate dataNascimento;


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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Aluno toAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setSexo(sexo);
        aluno.setDataNascimento(dataNascimento);
        return aluno;
    }


}
