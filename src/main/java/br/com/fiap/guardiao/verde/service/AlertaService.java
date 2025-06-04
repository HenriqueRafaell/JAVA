package br.com.fiap.guardiao.verde.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import br.com.fiap.guardiao.verde.domain.repository.AlertaRepository;

@Service
public class AlertaService {

	private final AlertaRepository alertaRepository;
	
	@Autowired
	public AlertaService (AlertaRepository alertaRepository) {
		this.alertaRepository = alertaRepository;
	}
	
	public Alerta salvarAlerta(Alerta alerta) {
		alerta.setDataEnvio(new Date());
		return alertaRepository.save(alerta);
	}

	
	
}
