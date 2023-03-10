package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class JuegoPartidaJugador {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "juego")
    @JsonBackReference(value = "juego-partida")
    private Juego juego;

    @ManyToOne
    @JoinColumn(name = "partida")
    @JsonBackReference(value = "partida")
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "jugador")
    @JsonBackReference(value = "jugador-partida")
    private Jugador jugador;

    public JuegoPartidaJugador() {
    }
    public JuegoPartidaJugador(Juego juego,  Partida partida, Jugador jugador) {
        this.juego = juego;
        this.partida = partida;
        this.jugador = jugador;
    }
}

