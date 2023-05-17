package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Classe;
import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.domain.enums.StatusClasse;
import com.ibjm.integraigreja.services.ClasseService;
import com.ibjm.integraigreja.services.IgrejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClasseResouces {

    @Autowired
    private ClasseService service;

    @Autowired
    private IgrejaService igrejaService;

    @GetMapping
    public ResponseEntity<List<Classe>> consultarTodos() {
        List<Classe> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Classe> consultarPorId(@PathVariable String id) {
        Classe classe = service.consultarPorId(id);
        return ResponseEntity.ok().body(classe);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Classe classe) {
        Classe newClasse = classe;
        IgrejaDTO igreja = new IgrejaDTO(igrejaService.consultarPorId(classe.getIgreja().getId()));
        Igreja igrejaCompleto = igrejaService.consultarPorId(igreja.getId());
        newClasse.setIgreja(igreja);
        newClasse.setStatusClasse(StatusClasse.ATIVO);
        newClasse.setAlunos(new ArrayList<>());
        classe = service.inserir(newClasse);
        igrejaCompleto.getClasses().add(classe);
        igrejaService.atualiza(igreja.getId(), igrejaCompleto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(classe.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualiza(@RequestBody Classe classe, @PathVariable String id) {
        Classe obj = service.atualiza(id, classe);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/inseriraluno/{id}")
    public ResponseEntity<Void> inseriraluno(@RequestBody Classe classe, @PathVariable String id) {
        Classe obj = service.inseriraluno(id, classe);
        return ResponseEntity.noContent().build();
    }

}
