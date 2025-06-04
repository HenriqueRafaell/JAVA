package br.com.fiap.guardiao.verde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.guardiao.verde.domain.dto.OcorrenciaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;
import br.com.fiap.guardiao.verde.domain.mapper.OcorrenciaMapper;
import br.com.fiap.guardiao.verde.domain.repository.LocalizacaoRepository;
import br.com.fiap.guardiao.verde.service.OcorrenciaService;

@RestController	
@RequestMapping("v1/ocorrencia") 
public class OcorrenciaController {

	
	private OcorrenciaService ocorrenciaService;
    private LocalizacaoRepository localizacaoRepository;
	
    @Autowired
	public OcorrenciaController(OcorrenciaService ocorrenciaService, LocalizacaoRepository localizacaoRepository) {
		this.ocorrenciaService = ocorrenciaService;
        this.localizacaoRepository = localizacaoRepository;
	}
	
    @PostMapping("/criar")
    public ResponseEntity<Ocorrencia> criarOcorrencia(@RequestBody OcorrenciaDTO dto) {
        Ocorrencia ocorrencia = OcorrenciaMapper.toEntity(dto, localizacaoRepository);
        Ocorrencia salva = ocorrenciaService.salvarOcorrencia(ocorrencia);
        return ResponseEntity.ok(salva);
    }
	
	@GetMapping("/buscarTodos")
	public ResponseEntity<List<Ocorrencia>> listarTodosLocalizacao(){
		List<Ocorrencia> ocorrencia = ocorrenciaService.buscarTodos();
		return ResponseEntity.ok(ocorrencia);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Ocorrencia> atualizarLocalizacao(
	        @PathVariable Long id,
	        @RequestBody OcorrenciaDTO ocorrenciaDTO) {

		Ocorrencia ocorrencia = ocorrenciaService.atualizarLocalizacao(id, ocorrenciaDTO);

	    if (ocorrencia != null) {
	        return ResponseEntity.ok(ocorrencia);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
		boolean deletado = ocorrenciaService.deletarPorId(id);
		if(deletado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
