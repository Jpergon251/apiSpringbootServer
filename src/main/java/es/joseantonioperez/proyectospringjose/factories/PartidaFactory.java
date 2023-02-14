package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;


import es.joseantonioperez.proyectospringjose.models.JuegoPartida;
import es.joseantonioperez.proyectospringjose.models.Partida;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.*;

@Component
public class PartidaFactory {
    Faker esFaker =  new Faker(new Locale("es-ES"));

    public List<Partida> get (int number, List<JuegoPartida> juegoPartidas){
        return IntStream.range(0,number)
                .mapToObj(x -> new Partida(
                        esFaker.number().randomDouble(1, 480,3600),
                        esFaker.date().birthday()
                ))
                .collect(Collectors.toList());
    }
}
