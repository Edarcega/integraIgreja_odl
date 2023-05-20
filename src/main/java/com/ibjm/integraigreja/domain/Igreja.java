package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.StatusIgreja;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Igreja implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String nome;
    private String razaosocial;
    private String denominação;
    private String cnpj;
    private String email;
    private String telefone;
    private Endereco endereço;
    private String numero;
    private String responsavel;
    private String cargo;
    private String cpfresponsavel;
    private String telefoneresponsavel;
    private StatusIgreja statusIgreja;
    @DBRef(lazy = true)
    private List<Membro> membros = new ArrayList<>();
    @DBRef(lazy = true)
    private List<Grupo> grupos = new ArrayList<>();
    @DBRef(lazy = true)
    private List<Classe> classes = new ArrayList<>();
    @DBRef(lazy = true)
    private List<Filial> filiais = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Igreja igreja = (Igreja) o;
        return Objects.equals(cnpj, igreja.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }
}
