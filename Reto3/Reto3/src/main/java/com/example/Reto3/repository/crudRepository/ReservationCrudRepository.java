package com.example.Reto3.repository.crudRepository;

import org.springframework.data.repository.CrudRepository;
import com.example.Reto3.entities.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer>{
    
}
