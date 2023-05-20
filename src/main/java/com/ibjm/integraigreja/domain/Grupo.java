package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.dto.IgrejaDTO;
import com.ibjm.integraigreja.domain.dto.MembroDTO;
import com.ibjm.integraigreja.domain.enums.StatusGrupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Grupo {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String Nome;
    private IgrejaDTO igreja;
    private MembroDTO lider;
    private List<MembroDTO> participantes = new ArrayList<>();
    private StatusGrupo statusGrupo;

}
