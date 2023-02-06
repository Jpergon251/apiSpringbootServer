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
    private Partidas partidas;


    public JuegoPartida(){}

    public JuegoPartida(Jugador jugador, Partidas partidas) {
        this.jugador = jugador;
        this.partidas = partidas;
    }
}
