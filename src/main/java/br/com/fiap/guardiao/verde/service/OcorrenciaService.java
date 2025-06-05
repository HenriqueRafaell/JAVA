package br.com.fiap.guardiao.verde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.guardiao.verde.domain.dto.OcorrenciaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Localizacao;
import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;
import br.com.fiap.guardiao.verde.domain.mapper.OcorrenciaMapper;
import br.com.fiap.guardiao.verde.domain.repository.LocalizacaoRepository;
import br.com.fiap.guardiao.verde.domain.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	private final OcorrenciaRepository ocorrenciaRepository;
	private final LocalizacaoRepository localizacaoRepository;

	@Autowired
	public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository, LocalizacaoRepository localizacaoRepository) {
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.localizacaoRepository = localizacaoRepository;
	}

	public Ocorrencia salvarOcorrencia(Ocorrencia ocorrencia) {
	    return ocorrenciaRepository.save(ocorrencia);
	}

	public List<Ocorrencia> buscarTodos() {
		return ocorrenciaRepository.findAll();
	}

	public Ocorrencia atualizarLocalizacao(Long id, OcorrenciaDTO ocorrenciaDTO) {
		Optional<Ocorrencia> optional = ocorrenciaRepository.findById(id);

		if (optional.isPresent()) {
			Ocorrencia ocorrenciaExists = optional.get();

			ocorrenciaExists.setDataOcorrencia(ocorrenciaDTO.getDataOcorrencia());
			ocorrenciaExists.setStatus(ocorrenciaDTO.getStatus());

			Optional<Localizacao> localizacaoOpt = localizacaoRepository.findById(ocorrenciaDTO.getLocalizacao().getId());
			if (localizacaoOpt.isEmpty()) {
				throw new RuntimeException("Localização não encontrada com ID: " + ocorrenciaDTO.getLocalizacao().getId());
			}
			ocorrenciaExists.setLocalizacao(localizacaoOpt.get());

			return ocorrenciaRepository.save(ocorrenciaExists);
		}
		return null;
	}

	public boolean deletarPorId(Long id) {
		if (ocorrenciaRepository.existsById(id)) {
			ocorrenciaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
