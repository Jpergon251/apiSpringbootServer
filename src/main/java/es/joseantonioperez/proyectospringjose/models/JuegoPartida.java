package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class JuegoPartida {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Jugador jugador;

    @ManyToOne
    @JoinColumn()
    private Partida partida;


    public JuegoPartida(){}

    public JuegoPartida(Jugador jugador, Partida partida) {
        this.jugador = jugador;
        this.partida = partida;
    }
}
