package com.sistema.gestao.repository;

import com.sistema.gestao.model.Disciplina;
import com.sistema.gestao.model.Frequencia;
import com.sistema.gestao.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FrequenciaRepository extends JpaRepository<Frequencia,String> {


    List<Frequencia> findById(Integer id);

    List<Frequencia> findByProfessor(Professor id);
}
