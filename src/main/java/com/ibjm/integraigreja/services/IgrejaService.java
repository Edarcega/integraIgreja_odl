package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.repositories.IgrejaRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IgrejaService {

    @Autowired
    private IgrejaRepository repository;

    public List<Igreja> consultarTodos() {
        return repository.findAll();
    }

    // Verificar porque do optional
    public Igreja consultarPorId(String id) {
        Optional<Igreja> igreja = repository.findById(id);
        return igreja.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
