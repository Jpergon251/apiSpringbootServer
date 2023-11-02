package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.dto.PartidaDTO;
import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Partida;
import es.joseantonioperez.proyectospringjose.repositories.EquipoRepository;
import es.joseantonioperez.proyectospringjose.repositories.PartidaRepository;
import es.joseantonioperez.proyectospringjose.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class  PartidasController {
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    private EquipoService equipoService;
    @GetMapping("/partida/")
    public ResponseEntity<Object> index() {
        List<PartidaDTO> resultado = new ArrayList<>();
                for( Partida partida : partidaRepository.findAll() ) {
                    resultado.add(new PartidaDTO(partida));
                }
        return new ResponseEntity<>(resultado,HttpStatus.OK);
    }

    @GetMapping("/partida/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new PartidaDTO(partidaRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/partida/create")
    public ResponseEntity<Object> create(@RequestBody PartidaDTO partidaDTO) {

        equipoService.actualizarDatosEquipo(new Equipo(partidaDTO.getEquipoLocal()));
        equipoService.actualizarDatosEquipo(new Equipo(partidaDTO.getEquipoVisitante()));
        return new ResponseEntity<>(
            new PartidaDTO(partidaRepository.save(new Partida(partidaDTO))), HttpStatus.OK
        );
    }

    @DeleteMapping("/partida/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Partida> partida = partidaRepository.findById(id);
        partida.ifPresent(value -> partidaRepository.delete(value));
        return new ResponseEntity<>(partida.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/partida/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Partida partida) {
        Optional<Partida> oldPartida = partidaRepository.findById(id);
        if(oldPartida.isPresent()) {
            partida.setId(id);
            partidaRepository.save(partida);
            return new ResponseEntity<>(partida, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
