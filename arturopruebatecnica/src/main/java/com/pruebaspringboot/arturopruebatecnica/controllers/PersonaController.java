package com.pruebaspringboot.arturopruebatecnica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaspringboot.DTO.PersonaResDTO;
import com.pruebaspringboot.arturopruebatecnica.models.entity.Persona;
import com.pruebaspringboot.arturopruebatecnica.services.PersonaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/perso")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public List<Persona> getpersonas() {
        return personaService.listaPersonas();
    }

    @PostMapping("/")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona newPersona = personaService.guardarPersona(persona);
        return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResDTO> obtenerPersonaPorId(@PathVariable Long id) {
        Optional<Persona> personaOpt = personaService.MPersonaId(id);
        return personaOpt.map(persona -> {
            String mensaje = String.format("El registro de %s, próximamente tendrás %d años.",
                    persona.getNombre(), persona.getEdad() + 1);
            PersonaResDTO respuesta = new PersonaResDTO(mensaje);
            return ResponseEntity.ok(respuesta);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
