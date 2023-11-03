package es.joseantonioperez.proyectospringjose.factories;

import com.github.javafaker.Faker;
import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Partida;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PartidaFactory {
    private final Faker esFaker = new Faker(new Locale("es-ES"));


    public List<Partida> get(int number, List<Equipo> equipos) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime thirtyDaysAgo = now.minusDays(60);


        return IntStream.range(0, number)
                .mapToObj(x -> new Partida(
                        generateRandomDateTime(thirtyDaysAgo, now),  // Fecha actual
                        esFaker.number().numberBetween(1200, 4000), // Duración aleatoria entre 20 y 60 minutos
                        esFaker.number().numberBetween(10000, 80000),  // Oro local aleatorio entre 5000 y 20000
                        esFaker.number().numberBetween(100, 400),  // Minions local aleatorios entre 100 y 400
                        esFaker.number().numberBetween(0, 2),  // Barones locales aleatorios entre 0 y 4
                        esFaker.number().numberBetween(0, 11),  // Torres locales aleatorias entre 0 y 11
                        esFaker.number().numberBetween(0, 5),  // Dragones locales aleatorios entre 0 y 5
                        esFaker.number().numberBetween(5000, 100000),  // Oro visitante aleatorio entre 5000 y 20000
                        esFaker.number().numberBetween(100, 400),  // Minions visitantes aleatorios entre 100 y 400
                        esFaker.number().numberBetween(0, 2),  // Barones visitantes aleatorios entre 0 y 4
                        esFaker.number().numberBetween(0, 11),  // Torres visitantes aleatorias entre 0 y 11
                        esFaker.number().numberBetween(0, 5),  // Dragones visitantes aleatorios entre 0 y 5
                        esFaker.options().nextElement(equipos),  // Equipo local (puedes personalizar esta parte)
                        esFaker.options().nextElement(equipos)  // Equipo visitante (puedes personalizar esta parte)
               ))
                .collect(Collectors.toList());
    }

    private LocalDateTime generateRandomDateTime(LocalDateTime start, LocalDateTime end) {
        long startEpochSecond = start.toEpochSecond(ZoneOffset.UTC);
        long endEpochSecond = end.toEpochSecond(ZoneOffset.UTC);
        long randomEpochSecond = ThreadLocalRandom.current().nextLong(startEpochSecond, endEpochSecond);

        return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, ZoneOffset.UTC);
    }
}
