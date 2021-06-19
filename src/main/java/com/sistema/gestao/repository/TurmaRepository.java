package com.sistema.gestao.repository;

import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Disciplina;
import com.sistema.gestao.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma,String> {

    List<Turma> findById(Integer id);




}
