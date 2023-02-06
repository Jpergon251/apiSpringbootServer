package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity @Getter @Setter
public class Partidas {
    @Id
    @GeneratedValue
    private Long id;
    private Double duracion;
    @ManyToOne
    @JoinColumn()
    private Juego juego;

    @ManyToOne
    @JoinColumn()
    private JuegoPartida juegoPartida;

    public Partidas(){};
    public Partidas(Double duracion, Juego juego, JuegoPartida juegoPartida) {
        this.duracion = duracion;
        this.juego = juego;
        this.juegoPartida = juegoPartida;
    }
}
