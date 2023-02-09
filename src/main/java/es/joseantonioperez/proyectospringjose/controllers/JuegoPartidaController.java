package es.joseantonioperez.proyectospringjose.controllers;


import es.joseantonioperez.proyectospringjose.models.JuegoPartida;
import es.joseantonioperez.proyectospringjose.repositories.JuegoPartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
@RestController
public class JuegoPartidaController {
    @Autowired
    JuegoPartidaRepository juegoPartidaRepository;
    @GetMapping("/juegoPartida/")
    public ResponseEntity<Object> index() {return new ResponseEntity<>(juegoPartidaRepository.findAll(),HttpStatus.OK);}

    @GetMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(juegoPartidaRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/juegoPartida/create")
    public ResponseEntity<Object> create(@RequestBody JuegoPartida juegoPartida) {
        juegoPartidaRepository.save(juegoPartida);
        return new ResponseEntity<>(juegoPartida, HttpStatus.OK);
    }

    @DeleteMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<JuegoPartida> juego = juegoPartidaRepository.findById(id);
        juego.ifPresent(value -> juegoPartidaRepository.delete(value));
        return new ResponseEntity<>(juego.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody JuegoPartida juegoPartida) {
        Optional<JuegoPartida> oldJuegoPartida = juegoPartidaRepository.findById(id);
        if(oldJuegoPartida.isPresent()) {
            juegoPartida.setId(id);
            juegoPartidaRepository.save(juegoPartida);
            return new ResponseEntity<>(juegoPartida, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
