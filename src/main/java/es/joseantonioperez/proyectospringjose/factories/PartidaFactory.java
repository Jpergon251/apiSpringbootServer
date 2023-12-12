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
        LocalDateTime thirtyDaysAgo = now.minusDays(365*3);

        return IntStream.range(0, number)
                .mapToObj(x -> {
                    Equipo equipoLocal;
                    Equipo equipoVisitante;

                    // Genera equipos locales y visitantes hasta que sean diferentes
                    do {
                        equipoLocal = esFaker.options().nextElement(equipos);
                        equipoVisitante = esFaker.options().nextElement(equipos);
                    } while (equipoLocal.equals(equipoVisitante));

                    return new Partida(
                            generateRandomDateTime(thirtyDaysAgo, now),
                            esFaker.number().numberBetween(1200, 4000),
                            esFaker.number().numberBetween(10000, 80000),
                            esFaker.number().numberBetween(100, 400),
                            esFaker.number().numberBetween(0, 2),
                            esFaker.number().numberBetween(0, 11),
                            esFaker.number().numberBetween(0, 5),
                            esFaker.number().numberBetween(10000, 80000),
                            esFaker.number().numberBetween(100, 400),
                            esFaker.number().numberBetween(0, 2),
                            esFaker.number().numberBetween(0, 11),
                            esFaker.number().numberBetween(0, 5),
                            equipoLocal,
                            equipoVisitante
                    );
                })
                .collect(Collectors.toList());
    }

    private LocalDateTime generateRandomDateTime(LocalDateTime start, LocalDateTime end) {
        long startEpochSecond = start.toEpochSecond(ZoneOffset.UTC);
        long endEpochSecond = end.toEpochSecond(ZoneOffset.UTC);
        long randomEpochSecond = ThreadLocalRandom.current().nextLong(startEpochSecond, endEpochSecond);

        return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, ZoneOffset.UTC);
    }
}
