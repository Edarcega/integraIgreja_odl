package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.domain.dto.MembroDTO;
import com.ibjm.integraigreja.domain.enums.TipoClasse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Classe {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Nome;
    private IgrejaDTO igreja;
    private TipoClasse tipoClasse;
    private MembroDTO professor;
    @DBRef(lazy = true)
    private List<MembroDTO> alunosMembro;
    @DBRef(lazy = true)
    private List<Pessoa> alunosDiscipulandos;
    private Date dataCriacao;

}
