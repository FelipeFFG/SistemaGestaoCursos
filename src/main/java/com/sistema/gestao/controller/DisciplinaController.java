package com.sistema.gestao.controller;


import com.sistema.gestao.dto.RequisicaoDisciplina;
import com.sistema.gestao.model.Disciplina;
import com.sistema.gestao.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller()
@RequestMapping("disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;


    @GetMapping
    public String disciplina_home(){ return "disciplina";
    }


    @GetMapping("formulario")
    public String formulario(RequisicaoDisciplina requisicao){
        return "disciplina/formulario";
    }


    @PostMapping("novo")
    public String novo(RequisicaoDisciplina requisicao, BindingResult result){
        if(result.hasErrors()){
            return "disciplina/formulario";
        }
        Disciplina disciplina = requisicao.toDisciplina();
        disciplinaRepository.save(disciplina);
        return "redirect:/home";
    }


    @GetMapping ("consulta")
    public String consulta(RequisicaoDisciplina requisicao, Model model){
        List<Disciplina> disciplinas =  disciplinaRepository.findById(requisicao.getId());
        model.addAttribute("disciplinas",disciplinas);
        return "/disciplina/consulta";
    }

}
