package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Classe;
import com.ibjm.integraigreja.domain.dto.MembroDTO;
import com.ibjm.integraigreja.repositories.ClasseRepository;
import com.ibjm.integraigreja.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private MembroService membroService;

    public List<Classe> consultarTodos() {
        return classeRepository.findAll();
    }

    // Verificar porque do optional
    public Classe consultarPorId(String id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Classe inserir(Classe obj) {
        return classeRepository.insert(obj);
    }

    public Classe atualiza(String id, Classe classe) {
        Classe newClasse = consultarPorId(id);
        atualizarDados(newClasse, classe);
        return classeRepository.save(newClasse);
    }

    private void atualizarDados(Classe newClasse, Classe classe) {
        newClasse.setNome(classe.getNome());
        newClasse.setTipoClasse(classe.getTipoClasse());
        newClasse.setProfessor(new MembroDTO(membroService.consultarPorId(classe.getProfessor().getId())));
        newClasse.setStatusClasse(classe.getStatusClasse());
    }

    public Classe inseriraluno(String id, Classe classe) {
        // Inserir validação se já há um aluno com o ID em questão
        Classe newClasse = consultarPorId(id);
        List<MembroDTO> list = classe.getAlunos();
        List<MembroDTO> alunos = list.stream().map(x -> new MembroDTO(membroService.consultarPorId(x.getId()))).collect(Collectors.toList());
        newClasse.getAlunos().addAll(alunos);
        return classeRepository.save(newClasse);
    }

    public void delete(String id) {
        consultarPorId(id);
        classeRepository.deleteById(id);
    }

}
