package com.example.demo.service;

import com.example.demo.domain.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }

    public Persona addPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Optional<Persona> getPersona(Integer id){
        return personaRepository.findById(id);
    }

    public Persona deletePersona(Integer id){
        Persona persona = personaRepository.findPersonaById(id);
       if(persona != null){
           personaRepository.delete(persona);
       }
       return persona;
    }
}
