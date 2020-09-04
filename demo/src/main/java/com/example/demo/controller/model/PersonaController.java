package com.example.demo.controller.model;

import com.example.demo.domain.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonaController {
    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }

    public Persona addPersona(Persona persona){
        return personaService.addPersona(persona);
    }

    public Optional<Persona> getPersona(Integer id){
        return personaService.getPersona(id);
    }

    public Persona editPersona(Persona persona){
        return personaService.addPersona(persona);
    }

    public Persona deletePersona(Integer id){
        return personaService.deletePersona(id);
    }
}
