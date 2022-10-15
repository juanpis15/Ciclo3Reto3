package com.example.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Reto3.entities.Client;
import com.example.Reto3.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client>getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client cl){
        if(cl.getIdClient()==null){
            return clientRepository.save(cl);
        }else{
            Optional<Client> e = clientRepository.getClient(cl.getIdClient());
            if(e.isPresent()){
                return cl;
            }else{
                return clientRepository.save(cl);
            }
        }
    }

    public boolean delete(int idClient){
        boolean flag = false;
        Optional<Client> e = clientRepository.getClient(idClient);
        if(e.isPresent()){
            clientRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
