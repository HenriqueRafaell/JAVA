package br.com.fiap.guardiao.verde.service;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import br.com.fiap.guardiao.verde.domain.mapper.AlertaMapper;
import br.com.fiap.guardiao.verde.domain.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService {

    private final AlertaRepository repository;
    private final AlertaMapper mapper;

    public AlertaService(AlertaRepository repository, AlertaMapper mapper) {
        this.repository = repository;
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
        return mapper.toDTO(repository.save(alerta));
    }
}
