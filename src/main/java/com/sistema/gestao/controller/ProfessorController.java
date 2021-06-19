package com.sistema.gestao.controller;

import com.sistema.gestao.dto.RequisicaoNovoAluno;
import com.sistema.gestao.dto.RequisicaoProfessor;
import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.model.Professor;
import com.sistema.gestao.model.Turma;
import com.sistema.gestao.repository.AlunoRepository;
import com.sistema.gestao.repository.ProfessorRepository;
import com.sistema.gestao.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("professor")
public class ProfessorController {


    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TurmaRepository turmaRepository;



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

}
