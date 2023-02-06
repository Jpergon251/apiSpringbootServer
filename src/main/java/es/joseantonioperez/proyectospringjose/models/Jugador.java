package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Integer edad;
    private Double horasJugadas;

    @ManyToOne
    @JoinColumn()
    private Juego juego;

    @ManyToOne
    @JoinColumn()
    private JuegoPartida juegoPartida;

    public Jugador(){}

    public Jugador(String nombre, Integer edad, Double horasJugadas, Juego juego) {
        this.nombre = nombre;
        this.edad = edad;
        this.horasJugadas = horasJugadas;
        this.juego = juego;
    }
}
