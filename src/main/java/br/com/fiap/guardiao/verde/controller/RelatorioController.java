package br.com.fiap.guardiao.verde.controller;

import br.com.fiap.guardiao.verde.domain.dto.RelatorioDTO;
import br.com.fiap.guardiao.verde.service.RelatorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/relatorios")
public class RelatorioController {

    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping("/buscarTodos")
    public List<RelatorioDTO> getAll() {
        return service.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<RelatorioDTO> create(@RequestBody RelatorioDTO dto) {
        RelatorioDTO created = service.save(dto);
        return ResponseEntity.ok(created);
    }
}
