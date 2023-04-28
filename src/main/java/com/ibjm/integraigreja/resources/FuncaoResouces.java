package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Funcao;
import com.ibjm.integraigreja.services.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcoes")
public class FuncaoResouces {

    @Autowired
    private FuncaoService service;

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


}
