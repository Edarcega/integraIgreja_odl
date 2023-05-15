package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Usuario;
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

    public Igreja atualiza(String id, Igreja igreja) {
        Igreja newIgrega = consultarPorId(id);
        atualizarDados(newIgrega, igreja);
        return repository.save(newIgrega);
    }

    public Igreja inserir(Igreja obj) {
        return repository.insert(obj);
    }

    private void atualizarDados(Igreja newIgrega, Igreja igreja) {
        newIgrega.setNome(igreja.getNome());
        newIgrega.setRazaosocial(igreja.getRazaosocial());
        newIgrega.setDenominação(igreja.getDenominação());
        newIgrega.setCnpj(igreja.getCnpj());
        newIgrega.setEmail(igreja.getEmail());
        newIgrega.setTelefone(igreja.getTelefone());
        newIgrega.setNumero(igreja.getNumero());
        newIgrega.setResponsavel(igreja.getResponsavel());
        newIgrega.setCargo(igreja.getCargo());
        newIgrega.setCpfresponsavel(igreja.getCpfresponsavel());
        newIgrega.setStatusIgreja(igreja.getStatusIgreja());
        newIgrega.setMembros(igreja.getMembros());
        newIgrega.setGrupos(igreja.getGrupos());
        newIgrega.setClasses(igreja.getClasses());
    }

    public void delete(String id) {
        consultarPorId(id);
        repository.deleteById(id);
    }

}
