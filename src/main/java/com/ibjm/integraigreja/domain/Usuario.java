package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/*@Document(collection = "pessoa")*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String email;
    private Perfil perfil;
    private String pwd;
    private String membroId;

}
