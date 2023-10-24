package es.joseantonioperez.proyectospringjose.factories;
import com.github.javafaker.Faker;

import es.joseantonioperez.proyectospringjose.models.Jugador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

import java.util.stream.*;

@Component
public class JugadorFactory {
    Faker esFaker =  new Faker(new Locale("es-ES"));

/*
    public  List<Jugador> get(int number){
        return IntStream.range(0,number)
                .mapToObj(x ->new Jugador(
                        esFaker.esports().player(), // Genera un nombre completo aleatorio
                        esFaker.options().option("jungla", "mid", "top", "adc", "support"),
                        esFaker.number().numberBetween(18, 35), // Genera una edad aleatoria entre 18 y 35 años
                        esFaker.number().numberBetween(5000,15000),
                        esFaker.leagueOfLegends().champion(),
                        esFaker.number().numberBetween(100,10000),
                        esFaker.number().numberBetween(100,10000),
                        esFaker.number().numberBetween(100,10000)

                        ))
                .collect(Collectors.toList());
    }*/
}
