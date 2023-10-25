package es.joseantonioperez.proyectospringjose.services;

import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Partida;
import es.joseantonioperez.proyectospringjose.repositories.EquipoRepository;
import es.joseantonioperez.proyectospringjose.repositories.PartidaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PartidaRepository partidaRepository;
    @PostConstruct
    public void actualizarDatosEquipos() {
        // Obtén la lista de todos los equipos y conviértela en una List
        List<Equipo> equipos = StreamSupport.stream(equipoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        for (Equipo equipo : equipos) {
            // Realiza la actualización para cada equipo
            actualizarDatosEquipo(equipo);
        }
    }

    public void actualizarDatosEquipo(Equipo equipo) {
        List<Partida> partidasDelEquipo = partidaRepository.findByEquipoLocalOrEquipoVisitante(equipo, equipo);
        int oroAcumulado = 0;

        for (Partida partida : partidasDelEquipo) {
            oroAcumulado += partida.getOroLocal(); // Suma el oro ganado en partidas locales
            oroAcumulado += partida.getOroVisitante(); // Suma el oro ganado en partidas visitantes
        }

        equipo.setOro(oroAcumulado); // Actualiza el campo "oro" del equipo con el valor acumulado
        equipoRepository.save(equipo);
    }
}