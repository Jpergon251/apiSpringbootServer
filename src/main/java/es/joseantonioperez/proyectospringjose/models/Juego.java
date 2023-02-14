package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Juego {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcion;

    private String portada;
    @ManyToOne
    @JoinColumn()
    private JuegoPartida juegoPartida;

    public Juego(){}


    public Juego(String nombre) {
        this.nombre = nombre;
    }
}
