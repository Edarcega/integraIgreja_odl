package com.ibjm.integraigreja.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Grupo {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Nome;
    private Igreja igreja;
    private Membro lider;
    private Membro viceLider;


}
