package com.sistema.gestao.controller;


import com.sistema.gestao.dto.AlunoID;
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
import java.util.ArrayList;
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
    public String consulta(AlunoID id, Model model){
        List<Aluno> alunos =  alunoRepository.findById(id.getId());
        model.addAttribute("alunos",alunos);
        return "/aluno/consulta";
    }

    @Transactional
    @GetMapping("excluir")
    public String excluir(AlunoID id, Model model){
        List<Aluno> alunos =alunoRepository.deleteById(id.getId());
        model.addAttribute("alunos",alunos);
        return "/aluno/excluir";
    }



//    @Transactional
//    @GetMapping("update")
//    public String update(AlunoID id, Model model){
//        List<Aluno> copia = alunoRepository.findById(id.getId());
//        alunoRepository.deleteById(id.getId());
//        Aluno aluno = copia.get(0);
//        aluno.setMatricula(id.getMatricula());
//        alunoRepository.save(aluno);
//        List<Aluno> lista_alunos = new ArrayList<Aluno>(1);
//        lista_alunos.add(aluno);
//        model.addAttribute("alunos",lista_alunos);
//        return "/aluno/update";
//    }



    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){                                                            //retornando para o /home
        return "redirect:/aluno";
    }

}
