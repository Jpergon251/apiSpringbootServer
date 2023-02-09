package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;

import es.joseantonioperez.proyectospringjose.models.Juego;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.*;
@Component
public class JuegoFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));
    Random rand = new Random();
    public List<Juego> get(int number){

        return IntStream.range(0, number)
                .mapToObj(x -> new Juego(   esFaker.name().firstName(),
                                            esFaker.number()
                        ))
                .collect(Collectors.toList());
    }
}
