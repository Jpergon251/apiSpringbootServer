package es.joseantonioperez.proyectospringjose.factories;

import com.github.javafaker.Faker;
import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class EquipoFactory {
    private final Faker esFaker = new Faker(new Locale("es-ES"));

    public List<Equipo> get(int number, List<Jugador>jugadores) {
        return IntStream.range(0, number)
                .mapToObj(x -> new Equipo(
                        esFaker.esports().team(), // Genera un nombre de equipo aleatorio
                        esFaker.name().name(), // Genera un nombre de entrenador aleatorio
                        esFaker.lorem().sentence(), // Genera una descripción aleatoria del historial del equipo
                        jugadores.stream().map(Jugador::getNombre).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}