package com.sistema.gestao.repository;

import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,String> {
    List<Curso> findById(Integer id);
}
