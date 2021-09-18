package com.lp2.desafio.model.repository;

import com.lp2.desafio.model.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

    boolean existsByName(String name);
    
    Client  findByName(String name);
}
