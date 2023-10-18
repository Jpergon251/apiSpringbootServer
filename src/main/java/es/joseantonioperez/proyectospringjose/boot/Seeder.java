package es.joseantonioperez.proyectospringjose.boot;

import es.joseantonioperez.proyectospringjose.factories.*;
import es.joseantonioperez.proyectospringjose.models.*;
import es.joseantonioperez.proyectospringjose.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    PartidaRepository partidaRepository;


    @Autowired
    EquipoFactory equipoFactory;
    @Autowired
    JugadorFactory jugadorFactory;
    @Autowired
    PartidaFactory partidaFactory;

    @Override
    public void run(String... args) {
        User testUser = new User("Jose", "pestillo");
        userRepository.save(testUser);

        // Genera una lista de jugadores únicos
        List<Jugador> jugadores = jugadorFactory.get(50);
        jugadorRepository.saveAll(jugadores);

        // Genera una lista de 5 equipos, cada uno con 6 jugadores ficticios

        for (int i = 0; i < 5; i++) {
            List<Jugador> jugadoresEquipo = jugadores.subList(i * 6, (i + 1) * 6);
            Equipo equipo = equipoFactory.get(1, jugadoresEquipo).get(0);
            equipoRepository.save(equipo);
        }

        List<Partida> partidas = partidaFactory.get(10);
        partidaRepository.saveAll(partidas);

    }
}
