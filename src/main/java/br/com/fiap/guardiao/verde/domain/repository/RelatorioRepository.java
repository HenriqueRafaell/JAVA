package br.com.fiap.guardiao.verde.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.guardiao.verde.domain.entity.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long>{
	@EntityGraph(attributePaths = {"alerta", "ocorrencia"})
	Optional<Relatorio> findById(Long id);
}
