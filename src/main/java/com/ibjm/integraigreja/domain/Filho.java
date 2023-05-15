package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.dto.PaiMaeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Filho implements Serializable {
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
    private PaiMaeDTO pai;
    private PaiMaeDTO mae;
    private Boolean portadorDeNecessidadesEspeciais;
    private String detalhamentoPne;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filho filho = (Filho) o;
        return Objects.equals(id, filho.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
