package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Filho;
import com.ibjm.integraigreja.domain.Membro;
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
        Membro pai = null;
        Membro mae = null;
        if (filho.getPai().getIdMembro() != null) {
            newFilho.setPai(new PaiMaeDTO(membroService.consultarPorId(filho.getPai().getIdMembro())));
            pai = membroService.consultarPorId(filho.getPai().getIdMembro());
        } else {
            newFilho.setPai(new PaiMaeDTO(filho.getPai().getNome()));
        }

        if (filho.getMae().getIdMembro() != null) {
            newFilho.setMae(new PaiMaeDTO(membroService.consultarPorId(filho.getMae().getIdMembro())));
            mae = membroService.consultarPorId(filho.getMae().getIdMembro());
        } else {
            newFilho.setMae(new PaiMaeDTO(filho.getMae().getNome()));
        }

        filho = service.inserir(newFilho);
        // criar validação se o pai/mãe não é nulo, adaptar para caso um dos dois sejam nulos carregar objeto generico

        if (pai != null) {
            pai.getFilhos().add(newFilho);
            membroService.atualiza(pai.getId(), pai);
        }
        if (mae != null) {
            mae.getFilhos().add(newFilho);
            membroService.atualiza(mae.getId(), mae);
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filho.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
