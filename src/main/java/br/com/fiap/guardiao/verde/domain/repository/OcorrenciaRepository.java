package br.com.fiap.guardiao.verde.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{

}
