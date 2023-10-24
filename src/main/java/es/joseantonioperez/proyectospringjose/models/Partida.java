package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Getter @Setter
public class Partida {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha;

    private int duracion;


    // Las Stats del equipo local
    private Integer oroLocal;
    private Integer minionsLocal;
    private Integer baronesLocal;
    private Integer torresLocal;
    private Integer dragonesLocal;

    // Las Stats del equipo visitante

    private Integer oroVisitante;
    private Integer minionsVisitante;
    private Integer baronesVisitante;
    private Integer torresVisitante;
    private Integer dragonesVisitante;
    @ManyToOne
    private Equipo equipoLocal;

    @ManyToOne
    private Equipo equipoVisitante;

    @ManyToOne
    private Equipo equipoGanador;

    // Constructor

    public Partida() {
        // Constructor sin argumentos
    }

    public Partida(LocalDateTime fecha, int duracion, Equipo equipoLocal, Equipo equipoVisitante, Equipo equipoGanador) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.equipoGanador = equipoGanador;

    }

}
