package com.sistema.gestao.controller;

import com.sistema.gestao.dto.RequisicaoCurso;
import com.sistema.gestao.dto.RequisicaoTurma;
import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Turma;
import com.sistema.gestao.repository.CursoRepository;
import com.sistema.gestao.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("turma")
public class TurmaController {


    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private CursoRepository cursoRepository;


    @GetMapping
    public String turma_home(){
        return "turma";
    }


    @GetMapping("formulario")
    public String formulario(RequisicaoTurma requisicao){
        return "turma/formulario";
    }


    @PostMapping("novo")
    public String novo(RequisicaoTurma requisicao, BindingResult result){
        List<Curso> cursos =cursoRepository.findById(requisicao.getId_curso());
        if(cursos.size() >0){
            Turma turma = new Turma(requisicao.getNome(),cursos.get(0));
            turmaRepository.save(turma);
        }
        return "redirect:/home";
    }




}
