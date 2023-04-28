package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Classe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends MongoRepository<Classe, String> {
}
