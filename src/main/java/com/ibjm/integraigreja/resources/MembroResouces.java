package com.ibjm.integraigreja.resources;

import com.ibjm.integraigreja.domain.Endereco;
import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Membro;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.repositories.IgrejaRepository;
import com.ibjm.integraigreja.services.EnderecoService;
import com.ibjm.integraigreja.services.IgrejaService;
import com.ibjm.integraigreja.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/membros")
public class MembroResouces {

    @Autowired
    private MembroService service;

    @Autowired
    private IgrejaService igrejaService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired IgrejaRepository igrejaRepository;

    @GetMapping
    public ResponseEntity<List<Membro>> consultarTodos() {
        List<Membro> list = service.consultarTodos();
        return ResponseEntity.ok().body(list);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Membro> consultarPorId(@PathVariable String id) {
        Membro membro = service.consultarPorId(id);
        return ResponseEntity.ok().body(membro);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Membro membro) {
        // Necessário criar os metodos de validação de campos obrigatórios
        Endereco endereco = enderecoService.findByCep(membro.getEndereco().getCep());
        Igreja igreja = igrejaService.consultarPorId(membro.getIgreja().getId());

        Membro newMembro = new Membro(null, membro.getNome(), membro.getCpf(), membro.getIdentidade(), membro.getSexo(), membro.getDataDeNascimento(), membro.getNascionalidade(), endereco, membro.getNumero(),
                membro.getNomeDoPai(), membro.getNomeDaMae(), membro.getProfissao(), membro.getEstadoCivil(), membro.getConjuge(), membro.getDataDoCasamento(), membro.getPossuiFilhos(), membro.getPortadorDeNecessidadesEspeciais(),
                membro.getDetalhamentoPne(), membro.getFilhos(), membro.getDataCadastro(), membro.getDataDaInscricao(), membro.getBatizado(), membro.getIgrejaAnterior(), new IgrejaDTO(igrejaService.consultarPorId(igreja.getId())), membro.getTipoMembro(), membro.getFuncoes());
        membro = service.inserir(newMembro);
        igreja.getMembros().add(newMembro);
        igrejaService.atualiza(igreja.getId(),igreja);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(membro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
