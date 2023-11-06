package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.dto.JugadorDTO;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.*;
@RestController
public class
JugadorController {

    @Autowired
    JugadorRepository jugadorRepository;

    @GetMapping("/jugadores/")
    public ResponseEntity<Object> getJugadores(){
        return new ResponseEntity<> (jugadorRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping("/jugadores/{id}/")
    public ResponseEntity<Object> getJugador(@PathVariable Long id){
        return new ResponseEntity<> (jugadorRepository.findById(id),HttpStatus.OK);
    }
    @GetMapping("/jugadores/dto/")
    public ResponseEntity<Object> getJugadoresDTO() {
        List<JugadorDTO> resultado = new ArrayList<>();
        for (Jugador jugador : jugadorRepository.findAll()) {
            resultado.add(new JugadorDTO(jugador));
        }
        return new ResponseEntity<>(resultado,HttpStatus.OK);
    }

    @GetMapping("/jugadores/dto/{id}/")
    public ResponseEntity<Object> getJugadorDTO(@PathVariable("id") Long id) {

        return new ResponseEntity<>(new JugadorDTO(jugadorRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/jugadores/create")
    public ResponseEntity<Object> createJugador(@RequestBody Jugador jugador) {
        return new ResponseEntity<>(
                jugadorRepository.save(jugador), HttpStatus.OK
        );
    }
    @DeleteMapping("/jugadores/{id}/")
    public ResponseEntity<Object> deleteJugador(@PathVariable("id") Long id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        jugador.ifPresent(value -> jugadorRepository.delete(value));
        return new ResponseEntity<>(jugador.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/jugadores/{id}/")
    public ResponseEntity<Object> updateJugador(@PathVariable("id") Long id, @RequestBody Jugador jugador) {
        Optional<Jugador> oldJugador = jugadorRepository.findById(id);
        if(oldJugador.isPresent()) {
            jugador.setId(id);
            jugadorRepository.save(jugador);
            return new ResponseEntity<>(jugador, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
