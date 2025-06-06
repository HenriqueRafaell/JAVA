package br.com.fiap.guardiao.verde.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.guardiao.verde.domain.entity.TipoUsuario;


@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

}