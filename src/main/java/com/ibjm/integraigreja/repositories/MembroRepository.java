package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Membro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends MongoRepository <Membro,String> {
}
