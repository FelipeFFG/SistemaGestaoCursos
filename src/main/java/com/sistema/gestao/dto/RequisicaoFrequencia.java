package com.sistema.gestao.dto;

import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.model.Frequencia;
import com.sistema.gestao.model.Professor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class RequisicaoFrequencia {



    private Date frequencia;
    private Integer aluno;
    private Integer professor;


    public Date getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Date frequencia) {
        this.frequencia = frequencia;
    }

    public Integer getAluno() {
        return aluno;
    }

    public void setAluno(Integer aluno) {
        this.aluno = aluno;
    }

    public Integer getProfessor() {
        return professor;
    }

    public void setProfessor(Integer professor) {
        this.professor = professor;
    }
}
