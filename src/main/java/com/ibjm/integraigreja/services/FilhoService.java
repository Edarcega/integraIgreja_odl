package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Filho;
import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.repositories.FilhoRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilhoService {

    @Autowired
    private FilhoRepository filhoRepository;

    public List<Filho> consultarTodos() {
        return filhoRepository.findAll();
    }

    // Verificar porque do optional
    public Filho consultarPorId(String id) {
        Optional<Filho> filho = filhoRepository.findById(id);
        return filho.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Filho inserir(Filho obj) {
        return filhoRepository.insert(obj);
    }

}
