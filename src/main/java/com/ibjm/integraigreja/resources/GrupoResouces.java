package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Grupo;
import com.ibjm.integraigreja.domain.Grupo;
import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.domain.dto.MembroDTO;
import com.ibjm.integraigreja.domain.enums.StatusGrupo;
import com.ibjm.integraigreja.services.GrupoService;
import com.ibjm.integraigreja.services.IgrejaService;
import com.ibjm.integraigreja.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoResouces {

    @Autowired
    private GrupoService service;

    @Autowired
    IgrejaService igrejaService;

    @Autowired
    MembroService membroService;

    @GetMapping
    public ResponseEntity<List<Grupo>> consultarTodos() {
        List<Grupo> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Grupo> consultarPorId(@PathVariable String id) {
        Grupo grupo = service.consultarPorId(id);
        return ResponseEntity.ok().body(grupo);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Grupo grupo) {
        Igreja igreja = igrejaService.consultarPorId(grupo.getIgreja().getId());

        Grupo newGrupo = new Grupo(null, grupo.getNome(), new IgrejaDTO(igreja), new MembroDTO(membroService.consultarPorId(grupo.getLider().getId())), new ArrayList<>(), StatusGrupo.ATIVO);
        grupo = service.inserir(newGrupo);
        igreja.getGrupos().add(grupo);
        igrejaService.atualiza(igreja.getId(), igreja);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grupo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
