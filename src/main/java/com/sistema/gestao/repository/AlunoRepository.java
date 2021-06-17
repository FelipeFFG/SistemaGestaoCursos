package com.sistema.gestao.repository;

import com.sistema.gestao.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,String> {



    List<Aluno>findAlunoBy();

    List<Aluno> findByNome(String nome);





}
