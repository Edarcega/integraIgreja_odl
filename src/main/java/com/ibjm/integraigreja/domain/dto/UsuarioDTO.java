package com.ibjm.integraigreja.domain.dto;

import com.ibjm.integraigreja.domain.Usuario;
import com.ibjm.integraigreja.domain.enums.Perfil;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Perfil perfil;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
        telefone = obj.getTelefone();
        cpf = obj.getCpf();
        perfil = obj.getPerfil();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
