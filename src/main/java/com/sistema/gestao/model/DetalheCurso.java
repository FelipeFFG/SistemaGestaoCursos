package com.sistema.gestao.model;

import javax.persistence.*;


public class DetalheCurso {


    @OneToMany
    private Curso curso;
    @ManyToOne
    private Turma turma;


}
