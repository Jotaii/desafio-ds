package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRespository extends JpaRepository<Persona, Integer> {

    // custom query to search to blog post by title or content
    //List<Persona> findAll();
    Persona findById(int id);
    //boolean delete(int id);   
}
