package br.com.fiap.guardiao.verde.domain.mapper;

import br.com.fiap.guardiao.verde.domain.dto.UsuarioDTO;
import br.com.fiap.guardiao.verde.domain.entity.Usuario;
import br.com.fiap.guardiao.verde.domain.repository.TipoUsuarioRepository;
import br.com.fiap.guardiao.verde.domain.entity.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        if (dto.getTipoUsuarioId() != null) {
            TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(dto.getTipoUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("TipoUsuario não encontrado: " + dto.getTipoUsuarioId()));
            usuario.setTipoUsuario(tipoUsuario);
        } else {
            usuario.setTipoUsuario(null);
        }

        return usuario;
    }

    public UsuarioDTO toDTO(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        if (entity.getTipoUsuario() != null) {
            dto.setTipoUsuarioId(entity.getTipoUsuario().getId());
        }
        return dto;
    }
}