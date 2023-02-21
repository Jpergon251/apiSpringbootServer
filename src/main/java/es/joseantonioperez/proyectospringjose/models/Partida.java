package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter
public class Partida {
    @Id
    @GeneratedValue
    private Long id;
    private Double duracion;
    private Date fecha_partida;

    @ManyToOne
    @JoinColumn()
    private JuegoPartidaJugador juegoPartidaJugador;

    public Partida(){};

    public Partida(Double duracion, Date fecha_partida) {
        this.duracion = duracion;
        this.fecha_partida = fecha_partida;
    }

}
