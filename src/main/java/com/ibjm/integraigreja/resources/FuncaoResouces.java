package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Funcao;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.services.FuncaoService;
import com.ibjm.integraigreja.services.IgrejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcoes")
public class FuncaoResouces {

    @Autowired
    private FuncaoService service;

    @Autowired
    private IgrejaService igrejaService;

    @GetMapping
    public ResponseEntity<List<Funcao>> consultarTodos() {
        List<Funcao> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcao> consultarPorId(@PathVariable String id) {
        Funcao funcao = service.consultarPorId(id);
        return ResponseEntity.ok().body(funcao);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Funcao funcao) {
        Funcao newFuncao = funcao;
        newFuncao.setIgreja(new IgrejaDTO(igrejaService.consultarPorId(funcao.getIgreja().getId())));
        funcao = service.inserir(newFuncao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualiza(@RequestBody Funcao funcao, @PathVariable String id) {
        Funcao obj = service.atualiza(id, funcao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
