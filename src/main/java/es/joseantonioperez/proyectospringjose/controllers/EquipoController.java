package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@RestController
public class EquipoController {

    @Autowired
    EquipoRepository equipoRepository;

    @GetMapping("/equipo/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(equipoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/equipo/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(equipoRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/equipo/create")
    public ResponseEntity<Object> create(@RequestBody Equipo equipo) {
        equipoRepository.save(equipo);
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    @DeleteMapping("/equipo/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        equipo.ifPresent(value -> equipoRepository.delete(value));
        return new ResponseEntity<>(equipo.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/equipo/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Equipo equipo) {
        Optional<Equipo> oldEquipo = equipoRepository.findById(id);
        if (oldEquipo.isPresent()) {
            equipo.setId(id);
            equipoRepository.save(equipo);
            return new ResponseEntity<>(equipo, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}