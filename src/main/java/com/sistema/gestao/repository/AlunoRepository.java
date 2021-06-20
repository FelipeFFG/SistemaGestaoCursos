package com.sistema.gestao.repository;

import com.sistema.gestao.model.Aluno;
import com.sistema.gestao.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,String> {

    List<Aluno> deleteById(Integer id);

    List<Aluno> findById(Integer id);


    List<Aluno> findAllByTurma(Turma turma);
 }
