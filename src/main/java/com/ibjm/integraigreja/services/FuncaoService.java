package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Funcao;
import com.ibjm.integraigreja.repositories.FuncaoRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncaoService {

    @Autowired
    private FuncaoRepository funcaoRepository;

    public List<Funcao> consultarTodos() {
        return funcaoRepository.findAll();
    }

    // Verificar porque do optional
    public Funcao consultarPorId(String id) {
        Optional<Funcao> funcao = funcaoRepository.findById(id);
        return funcao.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
