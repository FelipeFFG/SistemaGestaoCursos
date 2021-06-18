package com.sistema.gestao.controller;


import com.sistema.gestao.dto.RequisicaoNovoAluno;
import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping
    public String alunoHome(Model model){
        Aluno aluno = new Aluno();
        aluno.setNome("JOAO");
        aluno.setSexo("MASCULINO");
        aluno.setMatricula("123415213");
        List<Aluno> alunos = Arrays.asList(aluno);
        model.addAttribute("alunos",alunos);
        return "aluno";

    }



    /*@GetMapping
    public String aluno_home(Model model){

    }
*/

}
