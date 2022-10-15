package com.example.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Reto3.entities.Message;
import com.example.Reto3.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message>getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message me){
        if(me.getIdMessage()==null){
            return messageRepository.save(me);
        }else{
            Optional<Message> e = messageRepository.getMessage(me.getIdMessage());
            if(e.isPresent()){
                return me;
            }else{
                return messageRepository.save(me);
            }
        }
    }

    public boolean delete(int idMessage){
        boolean flag = false;
        Optional<Message> e = messageRepository.getMessage(idMessage);
        if(e.isPresent()){
            messageRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

}
