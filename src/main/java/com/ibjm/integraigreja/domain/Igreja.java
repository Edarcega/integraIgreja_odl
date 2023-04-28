package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.StatusIgreja;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Document
public class Igreja implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private List<Membro> membros;

    public Igreja() {
    }

    public Igreja(String id, String nome, String razaosocial, String denominação, String cnpj, String email, String telefone,
                  Endereco endereço, String numero, String responsavel, String cargo, String cpfresponsavel, String telefoneresponsavel,
                  StatusIgreja statusIgreja, List<Membro> membros) {
        this.id = id;
        this.nome = nome;
        this.razaosocial = razaosocial;
        this.denominação = denominação;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereço = endereço;
        this.numero = numero;
        this.responsavel = responsavel;
        this.cargo = cargo;
        this.cpfresponsavel = cpfresponsavel;
        this.telefoneresponsavel = telefoneresponsavel;
        this.statusIgreja = statusIgreja;
        this.membros = membros;
    }

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
