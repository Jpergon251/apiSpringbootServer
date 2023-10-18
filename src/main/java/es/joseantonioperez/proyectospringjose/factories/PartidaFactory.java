package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;


import es.joseantonioperez.proyectospringjose.models.Partida;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

@Component
public class PartidaFactory {
    private final Faker esFaker = new Faker(new Locale("es-ES"));

    public List<Partida> get(int number) {
        return IntStream.range(0, number)
                .mapToObj(x -> new Partida(
                        esFaker.date().past(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), // Genera una fecha pasada aleatoria en los últimos 30 días
                        esFaker.esports().team(), // Genera un nombre de equipo aleatorio
                        esFaker.esports().team(),// Genera otro nombre de equipo aleatorio
                        esFaker.options().option("Victoria", "Derrota", "Empate"), // Genera un resultado aleatorio
                        esFaker.number().numberBetween(15, 60) // Genera una duración aleatoria en minutos
                ))
                .collect(Collectors.toList());
    }
}
