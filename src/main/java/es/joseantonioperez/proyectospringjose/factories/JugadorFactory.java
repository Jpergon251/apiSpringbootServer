package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;

import es.joseantonioperez.proyectospringjose.models.Jugador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.*;

@Component
public class JugadorFactory {
    Faker esFaker =  new Faker(new Locale("es-ES"));

    public  List<Jugador> get(int number){
        return IntStream.range(0,number)
                .mapToObj(x ->new Jugador(
                        esFaker.funnyName().toString(),
                        esFaker.number().numberBetween(16,35),
                        esFaker.number().numberBetween(450,10000)
                ))
                .collect(Collectors.toList());
    }
}
