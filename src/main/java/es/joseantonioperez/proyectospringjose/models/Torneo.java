package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Torneo {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    @OneToMany(mappedBy = "torneo")
    private List<Partida> partidas;

    // Constructor

    public Torneo() {
        // Constructor sin argumentos
    }

    public Torneo(String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }


}