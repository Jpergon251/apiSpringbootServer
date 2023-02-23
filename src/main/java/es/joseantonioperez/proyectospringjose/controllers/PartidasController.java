package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.models.Partida;
import es.joseantonioperez.proyectospringjose.repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
public class PartidasController {
    @Autowired
    PartidaRepository partidaRepository;
    @GetMapping("/partida/")
    public ResponseEntity<Object> index() {return new ResponseEntity<>(partidaRepository.findAll(),HttpStatus.OK);}

    @GetMapping("/partida/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(partidaRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/partida/create")
    public ResponseEntity<Object> create(@RequestBody Partida partida) {
        partidaRepository.save(partida);
        return new ResponseEntity<>(partida, HttpStatus.OK);
    }

    @DeleteMapping("/partida/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Partida> partida = partidaRepository.findById(id);
        partida.ifPresent(value -> partidaRepository.delete(value));
        return new ResponseEntity<>(partida.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/partida/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Partida partida) {
        Optional<Partida> oldJugador = partidaRepository.findById(id);
        if(oldJugador.isPresent()) {
            partida.setId(id);
            partidaRepository.save(partida);
            return new ResponseEntity<>(partida, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
