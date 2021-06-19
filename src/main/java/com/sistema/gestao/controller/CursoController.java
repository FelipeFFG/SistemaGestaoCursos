package com.sistema.gestao.controller;


import com.sistema.gestao.dto.RequisicaoCurso;
import com.sistema.gestao.dto.RequisicaoDisciplina;
import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Disciplina;
import com.sistema.gestao.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;



    @GetMapping
    public String curso_home(){
        return "curso";
    }


    @GetMapping("formulario")
    public String formulario(RequisicaoCurso requisicao){
        return "curso/formulario";
    }


    @PostMapping("novo")
    public String novo(RequisicaoCurso requisicao, BindingResult result){
        if(result.hasErrors()){
            return "curso/formulario";
        }
        Curso disciplina = requisicao.toCurso();
        cursoRepository.save(disciplina);
        return "redirect:/home";
    }


    @GetMapping ("consulta")
    public String consulta(RequisicaoCurso requisicao, Model model){
        List<Curso> cursos = cursoRepository.findById(requisicao.getId());
        model.addAttribute("cursos",cursos);
        return "/curso/consulta";
    }





}
