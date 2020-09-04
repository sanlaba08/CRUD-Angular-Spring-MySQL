package com.example.demo.controller.rest;

import com.example.demo.controller.model.PersonaController;
import com.example.demo.domain.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/personas")
public class WebController {
    private PersonaController personaController;

    public WebController(PersonaController personaController) {
        this.personaController = personaController;
    }

    @GetMapping("/")
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> personas = personaController.getPersonas();
        if (personas.size() > 0) {
            return ResponseEntity.ok().body(personas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity addPersona(@RequestBody Persona persona) throws URISyntaxException {
        Persona person = personaController.addPersona(persona);
        return ResponseEntity.created(new URI("http://localhost:8080/personas/" + persona.getId())).body(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPersona(@PathVariable Integer id) {
        Optional<Persona> persona = personaController.getPersona(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(persona);
        }
    }

    @PutMapping("/{id}")
    public Persona editPersona(@RequestBody Persona persona, @PathVariable Integer id) {
        persona.setId(id);
        return personaController.editPersona(persona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersona(@PathVariable Integer id){
        System.out.println(id);
        personaController.deletePersona(id);
        return ResponseEntity.ok().build();
    }
}




    





