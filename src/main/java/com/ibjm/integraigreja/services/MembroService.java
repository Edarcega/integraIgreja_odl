package com.ibjm.integraigreja.services;

import com.ibjm.integraigreja.domain.Funcao;
import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.domain.dto.ConjugeDTO;
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

    @Autowired
    private FuncaoService funcaoService;

    public List<Membro> consultarTodos() {
        return membroRepository.findAll();
    }

    // Verificar porque do optional
    public Membro consultarPorId(String id) {
        Optional<Membro> membro = membroRepository.findById(id);
        return membro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Membro inserir(Membro obj) {
        return membroRepository.insert(obj);
    }

    public Membro atualiza(String id, Membro membro) {
        Membro newMembro = consultarPorId(id);
        atualizarDados(newMembro, membro);
        return membroRepository.save(newMembro);
    }

    private void atualizarDados(Membro newMembro, Membro membro) {
        // Esta classe não pode ficar assim, precisa arrumar para validar quais os dados foram alterados.
        newMembro.setNome(membro.getNome());
        newMembro.setCpf(membro.getCpf());
        newMembro.setIdentidade(membro.getIdentidade());
        newMembro.setSexo(membro.getSexo());
        newMembro.setDataDeNascimento(membro.getDataDeNascimento());
        newMembro.setNascionalidade(membro.getNascionalidade());
        newMembro.setEndereco(membro.getEndereco());
        newMembro.setNumero(membro.getNumero());
        newMembro.setNomeDoPai(membro.getNomeDoPai());
        newMembro.setNomeDaMae(membro.getNomeDaMae());
        newMembro.setProfissao(membro.getProfissao());
        newMembro.setEstadoCivil(membro.getEstadoCivil());
        newMembro.setConjuge(membro.getConjuge());
        newMembro.setDataDoCasamento(membro.getDataDoCasamento());
        newMembro.setPossuiFilhos(membro.getPossuiFilhos());
        newMembro.setPortadorDeNecessidadesEspeciais(membro.getPortadorDeNecessidadesEspeciais());
        newMembro.setDetalhamentoPne(membro.getDetalhamentoPne());
        newMembro.setDataCadastro(membro.getDataCadastro());
        newMembro.setDataDaInscricao(membro.getDataDaInscricao());
        newMembro.setBatizado(membro.getBatizado());
        newMembro.setIgrejaAnterior(membro.getIgrejaAnterior());
        newMembro.setTipoMembro(membro.getTipoMembro());
        newMembro.setFilhos(membro.getFilhos());
        newMembro.setUsuario(membro.getUsuario());
    }

    public Membro atualizaFuncao(String id, Funcao funcao) {
        Membro newMembro = consultarPorId(id);
        newMembro.getFuncoes().add(funcaoService.consultarPorId(funcao.getId()));
        return membroRepository.save(newMembro);
    }

    public Membro addConjuge(String id, ConjugeDTO conjuge) {
        Membro newMembro = consultarPorId(id);
        newMembro.setConjuge(conjuge);

        return membroRepository.save(newMembro);
    }

    public void delete(String id) {
        consultarPorId(id);
        membroRepository.deleteById(id);
    }

}
