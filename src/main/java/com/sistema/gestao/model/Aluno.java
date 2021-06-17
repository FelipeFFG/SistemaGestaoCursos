package com.sistema.gestao.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
public class Aluno {


    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;

    private String sexo;
    private String nome;
    private LocalDate dataNascimento = LocalDate.now();

    public Aluno(String nome,String sexo) {
        this.sexo = sexo;
        this.nome = nome;
    }

    public Aluno() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
