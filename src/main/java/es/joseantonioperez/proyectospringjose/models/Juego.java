package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Juego {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @JsonBackReference
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    public Juego(){}

    public Juego(String nombre, Set<Jugador> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }
}
