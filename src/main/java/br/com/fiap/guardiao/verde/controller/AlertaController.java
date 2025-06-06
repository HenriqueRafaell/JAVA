package br.com.fiap.guardiao.verde.controller;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.service.AlertaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/alertas")
public class AlertaController {

    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @GetMapping("/buscarTodos")
    public List<AlertaDTO> getAll() {
        return service.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<AlertaDTO> create(@RequestBody AlertaDTO dto) {
        AlertaDTO created = service.save(dto);
        return ResponseEntity.ok(created);
    }
}
