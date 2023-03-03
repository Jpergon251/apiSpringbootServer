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

    public Partida(double v){};

    public Partida(Double duracion, Date fechaPartida) {
        this.duracion = duracion;
    }

}
