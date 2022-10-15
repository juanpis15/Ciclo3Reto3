package com.example.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.Reto3.entities.Client;
import com.example.Reto3.repository.crudRepository.ClientCrudRepository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return(List<Client>) clientCrudRepository.findAll();
    }

    public Client save(Client cl){
        return clientCrudRepository.save(cl);
    }

    public void delete(Client cl){
        clientCrudRepository.delete(cl);
    }

    public Optional<Client> getClient(int idClient){
        return clientCrudRepository.findById(idClient);
    }
}
