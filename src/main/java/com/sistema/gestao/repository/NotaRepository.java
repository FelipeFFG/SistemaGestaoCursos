package com.sistema.gestao.repository;

import com.sistema.gestao.model.Frequencia;
import com.sistema.gestao.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota,String> {

}
