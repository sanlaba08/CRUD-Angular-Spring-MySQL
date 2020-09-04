package com.example.demo.repository;

import com.example.demo.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM personas WHERE id = ?", nativeQuery = true)
    Persona findPersonaById(@Param("id") Integer id);

}
