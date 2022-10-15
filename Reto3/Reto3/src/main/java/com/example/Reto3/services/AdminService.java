package com.example.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Reto3.entities.Admin;
import com.example.Reto3.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin>getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if(a.getId()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> e = adminRepository.getAdmin(a.getId());
            if(e.isPresent()){
                return a;
            }else{
                return adminRepository.save(a);
            }
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Admin> e = adminRepository.getAdmin(id);
        if(e.isPresent()){
            adminRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
