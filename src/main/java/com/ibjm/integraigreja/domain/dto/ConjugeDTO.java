package com.ibjm.integraigreja.domain.dto;

import com.ibjm.integraigreja.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConjugeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idMembro;
    private String nome;
    private String email;
    private String cpf;
    private Date dataDeNascimento;
    private String nascionalidade;
    private String profissao;
    private Boolean ehMembro;

}
