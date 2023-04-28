package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Grupo;
import com.ibjm.integraigreja.repositories.GrupoRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> consultarTodos() {
        return grupoRepository.findAll();
    }

    // Verificar porque do optional
    public Grupo consultarPorId(String id) {
        Optional<Grupo> grupo = grupoRepository.findById(id);
        return grupo.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
