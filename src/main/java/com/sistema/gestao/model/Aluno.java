package com.sistema.gestao.model;

import jdk.jfr.MemoryAddress;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
public class Aluno implements Cloneable{



    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricula;
    private String sexo;
    private String nome;
    private Date dataNascimento;

    @ManyToOne()
    private Turma turma;



    private String nome_turma;

    public String getNome_turma(){
        nome_turma = turma.getNome();
        return nome_turma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno(String nome, String sexo, String matricula, Date dataNascimento, Turma turma)  {
        this.sexo = sexo;
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.turma = turma;
    }

    public Aluno() {
    }

    @Override
    public Aluno clone() throws CloneNotSupportedException {
        return (Aluno) super.clone();
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
