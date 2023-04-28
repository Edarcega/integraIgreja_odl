package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Pessoa;
import com.ibjm.integraigreja.repositories.PessoaRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> consultarTodos() {
        return pessoaRepository.findAll();
    }

    // Verificar porque do optional
    public Pessoa consultarPorId(String id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
