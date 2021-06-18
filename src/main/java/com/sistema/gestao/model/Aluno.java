package com.sistema.gestao.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
public class Aluno {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricula;
    private String sexo;
    private String nome;
    private LocalDate dataNascimento = LocalDate.now();

    public Aluno(String nome,String sexo,String matricula) {
        this.sexo = sexo;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Aluno() {
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
