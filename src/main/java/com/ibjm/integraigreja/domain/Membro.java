package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.domain.enums.EstadoCivil;
import com.ibjm.integraigreja.domain.enums.TipoMembro;
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
public class Membro {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String cpf;
    private String identidade;
    private Character sexo;
    private Date dataDeNascimento;
    private String nascionalidade;
    private Endereco endereco;
    private String numero;
    private String nomeDoPai;
    private String nomeDaMae;
    private String profissao;
    private EstadoCivil estadoCivil;
    private Pessoa conjuge;
    private Date dataDoCasamento;
    private Boolean possuiFilhos;
    private Boolean portadorDeNecessidadesEspeciais;
    private String detalhamentoPne;
    @DBRef(lazy = true)
    private List<Filho> filhos;
    private Date dataCadastro;
    private Date dataDaInscricao;
    private Boolean batizado;
    private String igrejaAnterior;
    private IgrejaDTO igreja;
    private TipoMembro tipoMembro;
    @DBRef(lazy = true)
    private List<Funcao> funcoes;

}
