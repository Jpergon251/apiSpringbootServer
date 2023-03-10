package es.joseantonioperez.proyectospringjose.boot;

import es.joseantonioperez.proyectospringjose.factories.JuegoFactory;
import es.joseantonioperez.proyectospringjose.factories.JuegoPartidaJugadorFactory;
import es.joseantonioperez.proyectospringjose.factories.JugadorFactory;
import es.joseantonioperez.proyectospringjose.factories.PartidaFactory;
import es.joseantonioperez.proyectospringjose.models.*;
import es.joseantonioperez.proyectospringjose.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    JuegoRepository juegoRepository;
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    JuegoPartidaJugadorRepository juegoPartidaJugadorRepository;

    @Autowired
    JuegoFactory juegoFactory;
    @Autowired
    JugadorFactory jugadorFactory;
    @Autowired
    PartidaFactory partidaFactory;
    @Autowired
    JuegoPartidaJugadorFactory juegoPartidaJugadorFactory;
    @Override
    public void run(String... args) {
        User testUser = new User("Jose", "pestillo");
        userRepository.save(testUser);
        List<Jugador> jugadores = jugadorFactory.get(15);
        jugadorRepository.saveAll(jugadores);
        List<Juego> juegos = juegoFactory.get(5);
        juegoRepository.saveAll(juegos);
        List<Partida> partidas = partidaFactory.get(10);
        partidaRepository.saveAll(partidas);

        List<JuegoPartidaJugador> juegoPartidaJugadors = juegoPartidaJugadorFactory.get(10,juegos,partidas,jugadores);
        juegoPartidaJugadorRepository.saveAll(juegoPartidaJugadors);

    }
}
