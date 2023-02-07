package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;

import es.joseantonioperez.proyectospringjose.models.Juego;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.models.Partidas;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class JuegoFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));

    public List<Juego> get(int number, List<Partidas> partidas, List<Jugador> jugador){
        Random rand = new Random();
        return IntStream.range(0, number)
                .mapToObj(x -> new Jugador( esFaker.funnyName(),
                                            esFaker.number().numberBetween(16,20),
                                            esFaker.number().randomDouble(2,0,1000),
                                            jugador.get(rand.nextInt(jugador.size()),)

                        ));
    }
}
