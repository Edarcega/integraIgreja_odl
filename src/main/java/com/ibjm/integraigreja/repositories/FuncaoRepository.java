package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Funcao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepository extends MongoRepository<Funcao, String> {
}
