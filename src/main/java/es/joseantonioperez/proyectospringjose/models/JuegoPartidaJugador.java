package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class JuegoPartidaJugador {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Jugador jugador;

    @ManyToOne
    @JoinColumn()
    private Partida partida;


    public JuegoPartidaJugador(){}

    public JuegoPartidaJugador(Jugador jugador, Partida partida) {
        this.jugador = jugador;
        this.partida = partida;
    }
}
