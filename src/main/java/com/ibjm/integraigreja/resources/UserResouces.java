package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.UsuarioDTO;
import com.ibjm.integraigreja.services.MembroService;
import com.ibjm.integraigreja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResouces {

    @Autowired
    private UserService service;

    @Autowired
    private MembroService membroService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> consultarTodos() {
        List<Usuario> list = service.consultarTodos();
        List<UsuarioDTO> listDTO = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> consultarPorId(@PathVariable String id) {
        Usuario usuario = service.consultarPorId(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

//    @PostMapping
//    public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDto) {
//        Usuario obj = service.fromDTO(objDto);
//        obj = service.inserir(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Usuario usuario) {
        Membro membro = null;
        Usuario newUsuario = new Usuario(null, usuario.getEmail(), usuario.getPerfil(), usuario.getPwd(), usuario.getMembroId());
        String idMembro = usuario.getMembroId();
        if (idMembro != null || idMembro != "") {
            membro = membroService.consultarPorId(idMembro);
            newUsuario.setMembroId(idMembro);
            usuario = service.inserir(newUsuario);
            membro.setUsuario(usuario);
            membroService.atualiza(idMembro, membro);
        } else {
            usuario = service.inserir(newUsuario);
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualiza(@RequestBody Usuario usuario, @PathVariable String id) {
        Usuario obj = service.atualiza(id, usuario);
        return ResponseEntity.noContent().build();
    }

}
