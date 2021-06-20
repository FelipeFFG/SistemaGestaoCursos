package com.sistema.gestao.controller;

import com.sistema.gestao.dto.RequisicaoTurma;
import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Turma;
import com.sistema.gestao.repository.AlunoRepository;
import com.sistema.gestao.repository.CursoRepository;
import com.sistema.gestao.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @Autowired
    private AlunoRepository alunoRepository;


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
        return "redirect:/turma";
    }



    @GetMapping ("consulta")
    public String consulta(Model model){
        List<Turma> turma =  turmaRepository.findAll();
        model.addAttribute("turmas",turma);
        return "/turma/consulta";
    }


    @GetMapping ("listar_alunos")
    public String consulta(RequisicaoTurma requisicao, Model model){
        List<Turma> turmas = turmaRepository.findById(requisicao.getId());
        if (turmas.size() >0){
            List<Aluno> alunos =  alunoRepository.findAllByTurma(turmas.get(0));
            model.addAttribute("alunos",alunos);
        }
        return "/turma/listar_alunos";
    }

}
