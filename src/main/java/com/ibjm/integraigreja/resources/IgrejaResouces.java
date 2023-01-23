package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.UsuarioDTO;
import com.ibjm.integraigreja.services.IgrejaService;
import com.ibjm.integraigreja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/igrejas")
public class IgrejaResouces {

    @Autowired
    private IgrejaService service;

    @GetMapping
    public ResponseEntity<List<Igreja>> consultarTodos() {
        List<Igreja> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Igreja> consultarPorId(@PathVariable String id) {
        Igreja igreja = service.consultarPorId(id);
        return ResponseEntity.ok().body(igreja);
    }


}
