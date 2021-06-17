package com.sistema.gestao.controller;


import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping
    public String registrarAulno(){
        Aluno aluno = new Aluno("joao","masculino");
        alunoRepository.save(aluno);
        return "home";
    }

    public String ConsultarAluno(String nome_aluno){
        List<Aluno> lista_alunos = alunoRepository.findByNome(nome_aluno); //passar uma lista de alunos.
        return "home";
    }

    public String ExcluirAluno(String id){
        alunoRepository.deleteById(id); // aluno deletado por id.
        return "home";
    }


    public String AlterarMatricula(Aluno aluno,Integer matricula){
        aluno.setMatricula(matricula);
        return "home";
    }
}
