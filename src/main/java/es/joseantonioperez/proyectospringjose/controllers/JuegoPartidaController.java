package es.joseantonioperez.proyectospringjose.controllers;


import es.joseantonioperez.proyectospringjose.models.JuegoPartidaJugador;
import es.joseantonioperez.proyectospringjose.repositories.JuegoPartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> create(@RequestBody JuegoPartidaJugador juegoPartidaJugador) {
        juegoPartidaRepository.save(juegoPartidaJugador);
        return new ResponseEntity<>(juegoPartidaJugador, HttpStatus.OK);
    }

    @DeleteMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<JuegoPartidaJugador> juego = juegoPartidaRepository.findById(id);
        juego.ifPresent(value -> juegoPartidaRepository.delete(value));
        return new ResponseEntity<>(juego.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody JuegoPartidaJugador juegoPartidaJugador) {
        Optional<JuegoPartidaJugador> oldJuegoPartida = juegoPartidaRepository.findById(id);
        if(oldJuegoPartida.isPresent()) {
            juegoPartidaJugador.setId(id);
            juegoPartidaRepository.save(juegoPartidaJugador);
            return new ResponseEntity<>(juegoPartidaJugador, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
