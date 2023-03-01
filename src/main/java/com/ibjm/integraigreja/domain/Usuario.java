package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.Perfil;
import org.springframework.data.annotation.Id; // Verificar isso aqui
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/*@Document(collection = "pessoa")*/
@Document
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String nome;
    protected String email;
    protected String telefone;
    protected String cpf;
    private String pwd;
    protected Perfil perfil;

    public Usuario() {
    }

    public Usuario(String id, String nome, String email, String telefone, String cpf, String pwd, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.pwd = pwd;
        this.perfil = perfil;
    }

    //Sobrecarga sem pwd
    public Usuario(String id, String nome, String email, String telefone, String cpf, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.perfil = perfil;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(email, other.email) && Objects.equals(id, other.id);
    }

}
