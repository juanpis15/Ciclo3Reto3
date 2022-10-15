package com.example.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.Reto3.entities.Message;
import com.example.Reto3.repository.crudRepository.MessageCrudRepository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return(List<Message>) messageCrudRepository.findAll();
    }

    public Message save(Message me){
        return messageCrudRepository.save(me);
    }

    public void delete(Message me){
        messageCrudRepository.delete(me);
    }

    public Optional<Message> getMessage(int idMessage){
        return messageCrudRepository.findById(idMessage);
    }
}
