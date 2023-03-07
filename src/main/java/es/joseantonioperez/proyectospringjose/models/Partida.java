package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter
public class Partida {
    @Id
    @GeneratedValue
    private Long id;
    private Double duracion;
    @OneToMany(mappedBy = "partida")
    private List<JuegoPartidaJugador> juegoPartidaJugador;

    public Partida(){

    };

    public Partida(double duracion) {
        this.duracion = duracion;
    }
}
