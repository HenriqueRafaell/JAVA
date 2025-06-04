package br.com.fiap.guardiao.verde.controller;

import java.net.http.HttpRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import br.com.fiap.guardiao.verde.service.AlertaService;

@RestController
@RequestMapping("/v1/alerts")
public class AlertaController {

	private final AlertaService alertaService;
	
	public AlertaController(AlertaService alertaService) {
		this.alertaService = alertaService;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<AlertaDTO> criarAlerta(@RequestBody Alerta alerta){
		Alerta salvo = alertaService.salvarAlerta(alerta);
		return new ResponseEntity<>(salvo, HttpStatus.CREATED);	
	}
}
