package com.example.Reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.Reto3.entities.Admin;
import com.example.Reto3.repository.crudRepository.AdminCrudRepository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return(List<Admin>) adminCrudRepository.findAll();
    }

    public Admin save(Admin a){
        return adminCrudRepository.save(a);
    }
    public void delete(Admin a){
        adminCrudRepository.delete(a);
    }

    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
}
