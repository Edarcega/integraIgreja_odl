package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.TipoFuncao;
import com.ibjm.integraigreja.domain.enums.TipoMembro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Membro extends Pessoa{
    private static final long serialVersionUID = 1L;

    private Date dataDaInscricao;
    private Double batizado;
    private String igrejaAnterior;
    private List<Igreja> igreja;
    private TipoMembro tipoMembro;
    private List<TipoFuncao> funcoes;

}
