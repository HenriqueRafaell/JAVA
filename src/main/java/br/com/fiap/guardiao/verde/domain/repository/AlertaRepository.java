package br.com.fiap.guardiao.verde.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.guardiao.verde.domain.entity.Alerta;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long>{

}
