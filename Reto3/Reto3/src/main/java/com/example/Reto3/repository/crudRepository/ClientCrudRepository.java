package com.example.Reto3.repository.crudRepository;

import org.springframework.data.repository.CrudRepository;
import com.example.Reto3.entities.Client;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
    
}
