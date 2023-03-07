package es.joseantonioperez.proyectospringjose.controllers;


import es.joseantonioperez.proyectospringjose.models.JuegoPartidaJugador;
import es.joseantonioperez.proyectospringjose.repositories.JuegoPartidaJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class JuegoPartidaController {
    @Autowired
    JuegoPartidaJugadorRepository juegoPartidaJugadorRepository;
    @GetMapping("/juegoPartidajugador/")
    public ResponseEntity<Object> index() {return new ResponseEntity<>(juegoPartidaJugadorRepository.findAll(),HttpStatus.OK);}

    @GetMapping("/juegoPartidajugador/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(juegoPartidaJugadorRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/juegoPartidajugador/create")
    public ResponseEntity<Object> create(@RequestBody JuegoPartidaJugador juegoPartidaJugador) {
        juegoPartidaJugadorRepository.save(juegoPartidaJugador);
        return new ResponseEntity<>(juegoPartidaJugador, HttpStatus.OK);
    }

    @DeleteMapping("/juegoPartidajugador/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<JuegoPartidaJugador> juegoPartidaJugador = juegoPartidaJugadorRepository.findById(id);
        juegoPartidaJugador.ifPresent(value -> juegoPartidaJugadorRepository.delete(value));
        return new ResponseEntity<>(juegoPartidaJugador.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/juegoPartidajugador/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody JuegoPartidaJugador juegoPartidaJugador) {
        Optional<JuegoPartidaJugador> oldJuegoPartida = juegoPartidaJugadorRepository.findById(id);
        if(oldJuegoPartida.isPresent()) {
            juegoPartidaJugador.setId(id);
            juegoPartidaJugadorRepository.save(juegoPartidaJugador);
            return new ResponseEntity<>(juegoPartidaJugador, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
