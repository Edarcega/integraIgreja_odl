package com.ibjm.integraigreja.repositories;

import com.ibjm.integraigreja.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <Usuario,String> {
}
