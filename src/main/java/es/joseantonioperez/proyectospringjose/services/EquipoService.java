package es.joseantonioperez.proyectospringjose.services;

import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Partida;
import es.joseantonioperez.proyectospringjose.repositories.EquipoRepository;
import es.joseantonioperez.proyectospringjose.repositories.PartidaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .toList();

        for (Equipo equipo : equipos) {
            // Realiza la actualización para cada equipo
            actualizarDatosEquipo(equipo);
        }
    }


    public void actualizarDatosEquipo(Equipo equipo) {
        // Busca todas las partidas en las que el equipo es equipo local o visitante
        List<Partida> partidasDelEquipo = partidaRepository.findByEquipoLocalOrEquipoVisitante(equipo, equipo);
        int oroAcumulado = 0;
        int minionsAcumulados = 0;
        int baronesAcumulados = 0;
        int torresAcumuladas = 0;
        int dragonesAcumulados = 0;
        int tiempoDeJuegoAcumulado = 0;
        int victoriasAcumuladas = 0;
        int derrotasAcumuladas = 0;

        for (Partida partida : partidasDelEquipo) {
            if (partida.getEquipoLocal().equals(equipo)) {
                oroAcumulado += partida.getOroLocal();
                minionsAcumulados += partida.getMinionsLocal();
                baronesAcumulados += partida.getBaronesLocal();
                torresAcumuladas += partida.getTorresLocal();
                dragonesAcumulados += partida.getDragonesLocal();
                tiempoDeJuegoAcumulado += partida.getDuracion();

                if (equipo.getNombre().equals(partida.getEquipoGanador())) {
                    victoriasAcumuladas++;
                } else {
                    derrotasAcumuladas++;
                }
            } else {
                oroAcumulado += partida.getOroVisitante();
                minionsAcumulados += partida.getMinionsVisitante();
                baronesAcumulados += partida.getBaronesVisitante();
                torresAcumuladas += partida.getTorresVisitante();
                dragonesAcumulados += partida.getDragonesVisitante();
                tiempoDeJuegoAcumulado += partida.getDuracion();

                if (equipo.getNombre().equals(partida.getEquipoGanador())) {
                    victoriasAcumuladas++;
                } else {
                    derrotasAcumuladas++;
                }
            }
        }

        equipo.setOro(oroAcumulado);
        equipo.setMinions(minionsAcumulados);
        equipo.setBarones(baronesAcumulados);
        equipo.setTorres(torresAcumuladas);
        equipo.setDragones(dragonesAcumulados);
        equipo.setTiempoDeJuego(tiempoDeJuegoAcumulado);
        equipo.setVictorias(victoriasAcumuladas);
        equipo.setDerrotas(derrotasAcumuladas);

        equipoRepository.save(equipo);
    }
}