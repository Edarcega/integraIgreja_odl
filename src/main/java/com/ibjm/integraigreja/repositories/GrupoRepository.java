package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Grupo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends MongoRepository<Grupo, String> {
}
