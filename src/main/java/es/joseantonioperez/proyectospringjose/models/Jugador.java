package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @JsonManagedReference(value = "jugador-partida")
    @OneToMany(mappedBy = "jugador")
    private List<JuegoPartidaJugador> juegoPartidaJugador;

    public Jugador(){}

    public Jugador(String nombre, Integer edad, Integer horasJugadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.horasJugadas = horasJugadas;
    }
}
