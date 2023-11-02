package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.dto.JugadorDTO;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;
@RestController
public class
JugadorController {

    @Autowired
    JugadorRepository jugadorRepository;
    @GetMapping("/jugadores/")
    public ResponseEntity<Object> index() {
        List<JugadorDTO> resultado = new ArrayList<>();
        for (Jugador jugador : jugadorRepository.findAll()) {
            resultado.add(new JugadorDTO(jugador));
        }
        return new ResponseEntity<>(resultado,HttpStatus.OK);
    }

    @GetMapping("/jugadores/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {

        return new ResponseEntity<>(new JugadorDTO(jugadorRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/jugadores/create")
    public ResponseEntity<Object> create(@RequestBody JugadorDTO jugador) {
        return new ResponseEntity<>(
                new JugadorDTO(jugadorRepository.save(new Jugador(jugador))), HttpStatus.OK
        );
    }
    @DeleteMapping("/jugadores/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        jugador.ifPresent(value -> jugadorRepository.delete(value));
        return new ResponseEntity<>(jugador.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/jugadores/{id}/")
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
