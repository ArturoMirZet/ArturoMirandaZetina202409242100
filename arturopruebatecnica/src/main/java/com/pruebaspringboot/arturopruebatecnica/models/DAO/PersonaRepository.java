package com.pruebaspringboot.arturopruebatecnica.models.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaspringboot.arturopruebatecnica.models.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

}
