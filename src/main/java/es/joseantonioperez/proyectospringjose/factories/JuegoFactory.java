package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;

import es.joseantonioperez.proyectospringjose.models.Juego;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.*;
@Component
public class JuegoFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));
    public List<Juego> get(int number){

        return IntStream.range(0, number)
                .mapToObj(x -> new Juego(
                            esFaker.esports().game()
                        ))
                .collect(Collectors.toList());
    }
}
