package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Equipo {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String entrenador;
    private String historial;

    @ElementCollection

    private List<String> jugadores;

    // Constructor

    public Equipo() {
        // Constructor sin argumentos
    }

    public Equipo(String nombre, String entrenador, String historial , List<String> jugadores) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.historial = historial;
        this.jugadores = jugadores;
    }
}
