package com.sistema.gestao.controller;

import com.sistema.gestao.dto.RequisicaoFrequencia;
import com.sistema.gestao.dto.RequisicaoNota;
import com.sistema.gestao.dto.RequisicaoNovoAluno;
import com.sistema.gestao.dto.RequisicaoProfessor;
import com.sistema.gestao.model.*;
import com.sistema.gestao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("professor")
public class ProfessorController {


    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public String professor_home(){
        return "professor";
    }


    @GetMapping("formulario")
    public String formulario(RequisicaoProfessor requisicao){
        return "professor/formulario";
    }


    @PostMapping("novo")
    public String novo(RequisicaoProfessor requisicao, BindingResult result){
        List<Turma>  turmas = turmaRepository.findById(requisicao.getTurma());
        Professor professor = new Professor(requisicao.getNome(),requisicao.getSexo(),requisicao.getRegistro(),turmas.get(0));
        professorRepository.save(professor);
        return "redirect:/home";
    }



    @GetMapping ("consulta")
    public String consulta(RequisicaoProfessor requisicao, Model model){
        List<Professor> professor = professorRepository.findById(requisicao.getId());
        if (professor.size() > 0){
            List<Turma>  turmas = turmaRepository.findById(professor.get(0).getTurma().getId());
            model.addAttribute("turmas",turmas);
        }
        return "/professor/consulta";
    }



    @GetMapping("formulariofrequencia")
    public String formulario(RequisicaoFrequencia requisicao){
        return "professor/frequencia";
    }



    @PostMapping("novofrequencia")
    public String novo(RequisicaoFrequencia frequencia, BindingResult result){
        List<Aluno> alunos= alunoRepository.findById(frequencia.getAluno());
        List<Professor> professors= professorRepository.findById(frequencia.getProfessor());
        Frequencia frequencias = new Frequencia(frequencia.getFrequencia(),alunos.get(0),professors.get(0));
        frequenciaRepository.save(frequencias);
        return "redirect:/professor";
    }




    @GetMapping("formularionota")
    public String formulario(RequisicaoNota requisicao){
        return "professor/nota";
    }



    @PostMapping("novonota")
    public String novo(RequisicaoNota requisicao, BindingResult result){
        List<Aluno> alunos= alunoRepository.findById(requisicao.getAluno());
        List<Professor> professors= professorRepository.findById(requisicao.getProfessor());
        Nota nota = new Nota(requisicao.getNota(),alunos.get(0),professors.get(0));
        notaRepository.save(nota);
        return "redirect:/professor";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/professor";
    }


}
