package com.ibjm.integraigreja.domain.dto;

import com.ibjm.integraigreja.domain.Igreja;
import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.enums.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class IgrejaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;


    public IgrejaDTO(Igreja igreja) {
        this.id = igreja.getId();
        this.nome = igreja.getNome();
    }
}
