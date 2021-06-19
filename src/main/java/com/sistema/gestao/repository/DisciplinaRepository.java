package com.sistema.gestao.repository;


import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository  extends JpaRepository<Disciplina,String> {

    List<Disciplina> findById(Integer id);
}

