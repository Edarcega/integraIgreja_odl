package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Igreja;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgrejaRepository extends MongoRepository<Igreja, String> {
}
