package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.UsuarioDTO;
import com.ibjm.integraigreja.repositories.UserRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<Usuario> consultarTodos() {
        return repository.findAll();
    }

    // Verificar porque od optional
    public Usuario consultarPorId(String id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Usuario inserir(Usuario obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        consultarPorId(id);
        repository.deleteById(id);
    }

    public Usuario atualiza(String id, Usuario usuario) {
        Usuario newUsuario = consultarPorId(id);
        atualizarDados(newUsuario, usuario);
        return repository.save(newUsuario);
    }

    private void atualizarDados(Usuario newUsuario, Usuario usuario) {
        newUsuario.setEmail(usuario.getEmail());
        newUsuario.setPwd(usuario.getPwd());
        newUsuario.setPerfil(usuario.getPerfil());
    }

    public Usuario fromDTO(UsuarioDTO objDto) {
        return new Usuario(objDto.getId(), objDto.getEmail(), objDto.getPerfil());
    }


}
