package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
public class JugadorController {

    @Autowired
    JugadorRepository jugadorRepository;
    @GetMapping("/juegoPartida/")
    public ResponseEntity<Object> index() {return new ResponseEntity<>(jugadorRepository.findAll(),HttpStatus.OK);}

    @GetMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(jugadorRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/juegoPartida/create")
    public ResponseEntity<Object> create(@RequestBody Jugador jugador) {
        jugadorRepository.save(jugador);
        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }

    @DeleteMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        jugador.ifPresent(value -> jugadorRepository.delete(value));
        return new ResponseEntity<>(jugador.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/juegoPartida/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Jugador jugador) {
        Optional<Jugador> oldJugador = jugadorRepository.findById(id);
        if(oldJugador.isPresent()) {
            jugador.setId(id);
            jugadorRepository.save(jugador);
            return new ResponseEntity<>(jugador, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
