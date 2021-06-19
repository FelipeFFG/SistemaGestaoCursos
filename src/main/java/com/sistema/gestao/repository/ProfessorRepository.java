package com.sistema.gestao.repository;

import com.sistema.gestao.model.Curso;
import com.sistema.gestao.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor,String> {

    List<Professor> findById(Integer id);

}
