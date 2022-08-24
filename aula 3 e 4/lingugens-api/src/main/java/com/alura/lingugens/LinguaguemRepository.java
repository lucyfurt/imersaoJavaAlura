package com.alura.lingugens;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguaguemRepository extends MongoRepository<Linguagens, String> {

}
