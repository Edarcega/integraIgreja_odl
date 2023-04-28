package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Grupo;
import com.ibjm.integraigreja.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoResouces {

    @Autowired
    private GrupoService service;

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


}
