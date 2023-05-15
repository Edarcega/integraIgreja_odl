package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Filho;
import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.PaiMaeDTO;
import com.ibjm.integraigreja.services.FilhoService;
import com.ibjm.integraigreja.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/filhos")
public class FilhoResouces {

    @Autowired
    private FilhoService service;

    @Autowired
    private MembroService membroService;

    @GetMapping
    public ResponseEntity<List<Filho>> consultarTodos() {
        List<Filho> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Filho> consultarPorId(@PathVariable String id) {
        Filho filho = service.consultarPorId(id);
        return ResponseEntity.ok().body(filho);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Filho filho) {
        // Criar metodos para fazer as validações de dados obrigatórios e regras de negócio
        Filho newFilho = filho;
        newFilho.setPai(new PaiMaeDTO(membroService.consultarPorId(filho.getPai().getId())));
        newFilho.setMae(new PaiMaeDTO(membroService.consultarPorId(filho.getMae().getId())));
        filho = service.inserir(newFilho);
        // criar validação se o pai/mãe não é nulo, adaptar para caso um dos dois sejam nulos carregar objeto generico
        Membro pai = membroService.consultarPorId(filho.getPai().getId());
        pai.getFilhos().add(newFilho);
        membroService.atualiza(pai.getId(), pai);
        Membro mae = membroService.consultarPorId(filho.getMae().getId());
        mae.getFilhos().add(newFilho);
        membroService.atualiza(mae.getId(), mae);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filho.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
