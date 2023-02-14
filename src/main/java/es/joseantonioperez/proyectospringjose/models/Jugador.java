package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Integer edad;
    private Integer horasJugadas;

    @ManyToOne
    @JoinColumn()
    private JuegoPartida juegoPartida;

    public Jugador(){}

    public Jugador(String nombre, Integer edad, Integer horasJugadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.horasJugadas = horasJugadas;
    }
}
