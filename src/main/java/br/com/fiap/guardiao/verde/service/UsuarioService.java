package br.com.fiap.guardiao.verde.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.guardiao.verde.domain.dto.UsuarioDTO;
import br.com.fiap.guardiao.verde.domain.entity.TipoUsuario;
import br.com.fiap.guardiao.verde.domain.entity.Usuario;
import br.com.fiap.guardiao.verde.domain.mapper.UsuarioMapper;
import br.com.fiap.guardiao.verde.domain.repository.TipoUsuarioRepository;
import br.com.fiap.guardiao.verde.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper, TipoUsuarioRepository tipoUsuarioRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<UsuarioDTO> findAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::toDTO)
                         .collect(Collectors.toList());
    }

    public UsuarioDTO salvar(UsuarioDTO dto) {
        TipoUsuario tipo = tipoUsuarioRepository.findById(dto.getTipoUsuarioId())
            .orElseThrow(() -> new RuntimeException("Tipo de usuário não encontrado!"));

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipoUsuario(tipo);
        System.out.println(dto.getTipoUsuarioId());
        usuario = repository.save(usuario);

        return mapper.toDTO(usuario);
    }
}
