package com.ibjm.integraigreja.domain.dto;

import com.ibjm.integraigreja.domain.Membro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class PaiMaeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idMembro;
    private String nome;

    public PaiMaeDTO(Membro membro) {
        this.idMembro = membro.getId();
        this.nome = membro.getNome();
    }

    public PaiMaeDTO(String nome) {
        this.nome = nome;
    }
}
