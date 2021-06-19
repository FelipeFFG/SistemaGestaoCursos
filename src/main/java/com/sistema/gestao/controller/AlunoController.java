package com.sistema.gestao.controller;


import com.sistema.gestao.dto.RequisicaoNovoAluno;
import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public String aluno_home(){
        return"aluno";
    }

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoAluno requisicao){
        return "aluno/formulario";
    }


    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoAluno requisicao, BindingResult result){
        if(result.hasErrors()){
            return "aluno/formulario";
        }
        Aluno aluno = requisicao.toAluno();
        alunoRepository.save(aluno);
        return "redirect:/home";
    }


    @GetMapping ("consulta")
    public String consulta(RequisicaoNovoAluno id, Model model){
        List<Aluno> alunos =  alunoRepository.findById(id.getId());
        model.addAttribute("alunos",alunos);
        return "/aluno/consulta";
    }

    @Transactional
    @GetMapping("excluir")
    public String excluir(RequisicaoNovoAluno id, Model model){
        List<Aluno> alunos =alunoRepository.deleteById(id.getId());
        model.addAttribute("alunos",alunos);
        return "/aluno/excluir";
    }



    @Transactional
    @GetMapping("update")
    public String update(RequisicaoNovoAluno id, Model model)  {
        List<Aluno> aluno =  alunoRepository.findById(id.getId());
        if(aluno.size()>0){
            aluno.get(0).setMatricula(id.getMatricula());
            alunoRepository.save(aluno.get(0));
        }
        model.addAttribute("alunos",aluno);
        return "/aluno/update";
    }





}
