package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Filho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilhoRepository extends MongoRepository<Filho, String> {
}
