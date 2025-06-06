package br.com.fiap.guardiao.verde.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;
import br.com.fiap.guardiao.verde.domain.mapper.AlertaMapper;
import br.com.fiap.guardiao.verde.domain.repository.AlertaRepository;
import br.com.fiap.guardiao.verde.domain.repository.OcorrenciaRepository;

@Service
public class AlertaService {

    private final AlertaRepository repository;
	private final OcorrenciaRepository ocorrenciaRepository;
    private final AlertaMapper mapper;

    public AlertaService(AlertaRepository repository, AlertaMapper mapper, OcorrenciaRepository ocorrenciaRepository) {
        this.repository = repository;
    	this.ocorrenciaRepository = ocorrenciaRepository;
        this.mapper = mapper;
    }

    public List<AlertaDTO> findAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::toDTO)
                         .collect(Collectors.toList());
    }

    public AlertaDTO save(AlertaDTO dto) {
        Alerta alerta = mapper.toEntity(dto);
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(dto.getOcorrencia().getId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ocorrencia não encontrada"));
        alerta.setOcorrencia(ocorrencia);
        return mapper.toDTO(repository.save(alerta));
    }	
}
