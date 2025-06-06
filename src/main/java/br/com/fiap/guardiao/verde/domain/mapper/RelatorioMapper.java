package br.com.fiap.guardiao.verde.domain.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.guardiao.verde.domain.dto.RelatorioDTO;
import br.com.fiap.guardiao.verde.domain.entity.Relatorio;
import br.com.fiap.guardiao.verde.domain.repository.AlertaRepository;
import br.com.fiap.guardiao.verde.domain.repository.OcorrenciaRepository;

@Component
public class RelatorioMapper {

    private final AlertaRepository alertaRepository;
    private final OcorrenciaRepository ocorrenciaRepository;

    public RelatorioMapper(AlertaRepository alertaRepository, OcorrenciaRepository ocorrenciaRepository) {
        this.alertaRepository = alertaRepository;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Relatorio toEntity(RelatorioDTO dto) {
        Relatorio entity = new Relatorio();
        if (dto.getAlertaId() != null) {
            entity.setAlerta(alertaRepository.findById(dto.getAlertaId()).orElse(null));
        }
        if (dto.getOcorrenciaId() != null) {
            entity.setOcorrencia(ocorrenciaRepository.findById(dto.getOcorrenciaId()).orElse(null));
        }
        entity.setDataRelatorio(dto.getDataRelatorio());
        entity.setResumo(dto.getResumo());
        return entity;
    }

    public RelatorioDTO toDTO(Relatorio entity) {
        RelatorioDTO dto = new RelatorioDTO();
        dto.setDataRelatorio(entity.getDataRelatorio());
        dto.setResumo(entity.getResumo());
        if (entity.getAlerta() != null) {
            dto.setAlertaId(entity.getAlerta().getId());
        }
        if (entity.getOcorrencia() != null) {
            dto.setOcorrenciaId(entity.getOcorrencia().getId());
        }
        return dto;
    }
}