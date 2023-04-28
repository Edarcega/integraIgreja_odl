package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/membros")
public class MembroResouces {

    @Autowired
    private MembroService service;

    @GetMapping
    public ResponseEntity<List<Membro>> consultarTodos() {
        List<Membro> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Membro> consultarPorId(@PathVariable String id) {
        Membro membro = service.consultarPorId(id);
        return ResponseEntity.ok().body(membro);
    }


}
