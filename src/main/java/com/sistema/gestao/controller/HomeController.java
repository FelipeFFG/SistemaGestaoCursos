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
    public String home(){
        return "home";
    }

}
