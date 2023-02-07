package es.joseantonioperez.proyectospringjose.boot;

import es.joseantonioperez.proyectospringjose.models.Juego;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.repositories.JuegoPartidaRepository;
import es.joseantonioperez.proyectospringjose.repositories.JuegoRepository;
import es.joseantonioperez.proyectospringjose.repositories.JugadorRepository;
import es.joseantonioperez.proyectospringjose.repositories.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    JuegoRepository juegoRepository;
    @Autowired
    JuegoPartidaRepository juegoPartidaRepository;
    @Autowired
    PartidasRepository partidasRepository;
    @Autowired
    JugadorRepository jugadorRepository;

    @Override
    public void run(String... args) {

    }
}
