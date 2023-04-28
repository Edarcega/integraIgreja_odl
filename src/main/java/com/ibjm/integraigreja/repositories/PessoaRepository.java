package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository <Pessoa,String> {
}
