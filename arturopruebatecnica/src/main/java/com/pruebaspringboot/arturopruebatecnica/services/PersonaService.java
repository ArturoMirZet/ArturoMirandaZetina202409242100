package com.pruebaspringboot.arturopruebatecnica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaspringboot.arturopruebatecnica.models.DAO.PersonaRepository;
import com.pruebaspringboot.arturopruebatecnica.models.entity.Persona;

@Service
public class PersonaService {
@Autowired
private PersonaRepository personaRepository;
public List<Persona>listaPersonas(){
    return personaRepository.findAll();
}
public Optional<Persona> MPersonaId(Long id){
    return personaRepository.findById(id);
}
public Persona guardarPersona(Persona persona){
    return personaRepository.save(persona);
}
}
