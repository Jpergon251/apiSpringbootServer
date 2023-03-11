package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Juego {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @JsonManagedReference(value = "juego-partida")
    @OneToMany(mappedBy = "juego")
    private List<JuegoPartidaJugador> juegoPartidaJugador;

    public Juego(){}


    public Juego(String nombre) {

        this.nombre = nombre;
    }
}
