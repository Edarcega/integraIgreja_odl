package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.repositories.MembroRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public List<Membro> consultarTodos() {
        return membroRepository.findAll();
    }

    // Verificar porque do optional
    public Membro consultarPorId(String id) {
        Optional<Membro> membro = membroRepository.findById(id);
        return membro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
