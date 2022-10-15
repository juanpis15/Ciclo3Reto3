package com.example.Reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Reto3.entities.Category;
import com.example.Reto3.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if(e.isPresent()){
                return c;
            }else{
                return categoryRepository.save(c);
            }
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Category> e = categoryRepository.getCategory(id);
        if(e.isPresent()){
            categoryRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
