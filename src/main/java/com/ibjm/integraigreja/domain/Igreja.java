package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.StatusIgreja;

import java.io.Serializable;
import java.util.Objects;

public class Igreja implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String razaosocial;
    private String denominação;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereço;
    private Integer numero;
    private String cep;
    private String responsavel;
    private String cargo;
    private String cpfresponsavel;
    private String telefoneresponsavel;
    private StatusIgreja statusIgreja;

    public Igreja() {
    }

    public Igreja(String id, String nome, String razaosocial, String denominação, String cnpj, String email, String telefone,
                  String endereço, Integer numero, String cep, String responsavel, String cargo, String cpfresponsavel,
                  String telefoneresponsavel, StatusIgreja statusIgreja) {
        this.id = id;
        this.nome = nome;
        this.razaosocial = razaosocial;
        this.denominação = denominação;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereço = endereço;
        this.numero = numero;
        this.cep = cep;
        this.responsavel = responsavel;
        this.cargo = cargo;
        this.cpfresponsavel = cpfresponsavel;
        this.telefoneresponsavel = telefoneresponsavel;
        this.statusIgreja = statusIgreja;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getDenominação() {
        return denominação;
    }

    public void setDenominação(String denominação) {
        this.denominação = denominação;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpfresponsavel() {
        return cpfresponsavel;
    }

    public void setCpfresponsavel(String cpfresponsavel) {
        this.cpfresponsavel = cpfresponsavel;
    }

    public String getTelefoneresponsavel() {
        return telefoneresponsavel;
    }

    public void setTelefoneresponsavel(String telefoneresponsavel) {
        this.telefoneresponsavel = telefoneresponsavel;
    }

    public StatusIgreja getStatusIgreja() {
        return statusIgreja;
    }

    public void setStatusIgreja(StatusIgreja statusIgreja) {
        this.statusIgreja = statusIgreja;
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
