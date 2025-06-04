package br.com.fiap.guardiao.verde.domain.mapper;

import br.com.fiap.guardiao.verde.domain.dto.OcorrenciaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Localizacao;
import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;
import br.com.fiap.guardiao.verde.domain.repository.LocalizacaoRepository;

public class OcorrenciaMapper {

    public static Ocorrencia toEntity(OcorrenciaDTO dto, LocalizacaoRepository localizacaoRepository) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDataOcorrencia(dto.getDataOcorrencia());
        ocorrencia.setStatus(dto.getStatus());

        Localizacao localizacao = localizacaoRepository.findById(dto.getLocalizacao().getId())
            .orElseThrow(() -> new RuntimeException("Localização não encontrada com ID: " + dto.getLocalizacao().getId()));

        ocorrencia.setLocalizacao(localizacao);

        return ocorrencia;
    }
}
