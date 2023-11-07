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

    @GetMapping("/equipos/")
    public ResponseEntity<Object> getEquipos(){
        return new ResponseEntity<>(equipoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/equipos/{id}/")
    public ResponseEntity<Object> getEquipoById(@PathVariable Long id){
        return new ResponseEntity<>(equipoRepository.findById(id), HttpStatus.OK);
    }


    @GetMapping("/equipos/dto/")
    public ResponseEntity<Object> getEquiposDTO(){
        List<EquipoDTO> response = new ArrayList<>();
        for (Equipo equipo : equipoRepository.findAll()){
            response.add(new EquipoDTO(equipo));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/equipos/dto/{id}")
    public ResponseEntity<Object> getEquipoDTOById(@PathVariable Long id) {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);

        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            return new ResponseEntity<>(new EquipoDTO(equipo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El equipo no se encontró", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/equipos/create")
    public ResponseEntity<Object> createEquipo() {
        return new ResponseEntity<>(
                equipoRepository.save(new Equipo()), HttpStatus.OK
        );
    }

    @DeleteMapping("/equipos/{id}/")
    public ResponseEntity<Object> deleteEquipo(@PathVariable("id") Long id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        equipo.ifPresent(value -> equipoRepository.delete(value));
        return new ResponseEntity<>(equipo.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/equipos/{id}/")
    public ResponseEntity<Object> updateEquipo(@PathVariable("id") Long id, @RequestBody Equipo equipo) {
        Optional<Equipo> oldEquipo = equipoRepository.findById(id);
        if (oldEquipo.isPresent()) {
            equipo.setId(id);
            equipoRepository.save(equipo);
            return new ResponseEntity<>(equipo, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}