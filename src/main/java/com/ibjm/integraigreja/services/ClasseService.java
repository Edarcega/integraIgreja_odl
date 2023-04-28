package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Classe;
import com.ibjm.integraigreja.repositories.ClasseRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> consultarTodos() {
        return classeRepository.findAll();
    }

    // Verificar porque do optional
    public Classe consultarPorId(String id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
