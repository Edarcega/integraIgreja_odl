package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Classe;
import com.ibjm.integraigreja.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClasseResouces {

    @Autowired
    private ClasseService service;

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


}
