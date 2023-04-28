package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.TipoClasse;
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
public class Classe {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Nome;
    private Igreja igreja;
    private TipoClasse tipoClasse;
    private Membro professor;
    private List<Membro> alunosMembro;
    private List<Pessoa> alunosGen;
    private Date dataCriacao;

}
