package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.domain.enums.TipoFuncao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Funcao {
    private static final long serialVersionUID = 1L;

    private String id;
    private String descricao;
    private TipoFuncao tipoFuncao;
    private IgrejaDTO igrejaDTO;

}
