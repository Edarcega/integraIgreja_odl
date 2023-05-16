package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/*@Document(collection = "pessoa")*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String email;
    private Perfil perfil;
    private String pwd;

    public Usuario(String id, String email, Perfil perfil) {
        this.id = id;
        this.email = email;
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
