package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PersonaController {

    @Autowired
    PersonaRespository personaRespository;

    @GetMapping("/persona")
    public List<Persona> index(){
        return personaRespository.findAll();
    }

    @GetMapping("/persona/{id}")
    public Persona show(@PathVariable String id){
        int personaId = Integer.parseInt(id);
        return personaRespository.findById(personaId);
    }

    @PostMapping("/persona")
    public Persona create(@RequestBody Map<String, String> body){
        String nombre = body.get("nombre");
        int edad = Integer.parseInt(body.get("edad"));
        return personaRespository.save(new Persona(nombre, edad));
    }

    @PutMapping("/persona/{id}")
    public Persona update(@PathVariable String id, @RequestBody Map<String, String> body){
        int personaId = Integer.parseInt(id);
        // getting blog
        Persona persona = personaRespository.findById(personaId);
        persona.setNombre(body.get("nombre"));
        persona.setEdad(Integer.parseInt(body.get("edad")));
        return personaRespository.save(persona);
    }

    @DeleteMapping("persona/{id}")
    public boolean delete(@PathVariable String id){
        int personaId = Integer.parseInt(id);
        personaRespository.deleteById(personaId);
        return true;
    }

}
