package br.com.fiap.guardiao.verde.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.guardiao.verde.domain.dto.RelatorioDTO;
import br.com.fiap.guardiao.verde.domain.entity.Relatorio;
import br.com.fiap.guardiao.verde.domain.mapper.RelatorioMapper;
import br.com.fiap.guardiao.verde.domain.repository.RelatorioRepository;

@Service
public class RelatorioService {

    private final RelatorioRepository repository;
    private final RelatorioMapper mapper;

    public RelatorioService(RelatorioRepository repository, RelatorioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RelatorioDTO> findAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::toDTO)
                         .collect(Collectors.toList());
    }

    public RelatorioDTO save(RelatorioDTO dto) {
        Relatorio entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }	
}
