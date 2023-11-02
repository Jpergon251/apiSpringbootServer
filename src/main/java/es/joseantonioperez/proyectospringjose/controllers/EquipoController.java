package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.dto.EquipoDTO;
import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
public class EquipoController {

    @Autowired
    EquipoRepository equipoRepository;

    @GetMapping("/equipo/")
    public ResponseEntity<Object> index() {
        List<EquipoDTO> resultado = new ArrayList<>();
        for (Equipo equipo: equipoRepository.findAll()) {
            resultado.add(new EquipoDTO(equipo));
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/equipo/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new EquipoDTO(equipoRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/equipo/create")
    public ResponseEntity<Object> create(@RequestBody EquipoDTO equipoDTO) {
        return new ResponseEntity<>(
                new EquipoDTO(equipoRepository.save(new Equipo(equipoDTO))), HttpStatus.OK
        );
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