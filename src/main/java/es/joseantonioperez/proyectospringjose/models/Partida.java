package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.time.LocalDateTime;

@Entity @Getter @Setter
public class Partida {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha;

    private Integer duracion;


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
    @JsonIgnoreProperties({"equipo"})
    private Equipo equipoLocal;

    @ManyToOne
    @JsonIgnoreProperties({"equipo"})

    private Equipo equipoVisitante;

    @ManyToOne
    @JsonIgnoreProperties({"equipo"})

    private Equipo equipoGanador;

    // Constructor

    public Partida() {
        // Constructor sin argumentos
    }

    public Partida(
            LocalDateTime fecha,
            Integer duracion,
            Integer oroLocal,
            Integer minionsLocal,
            Integer baronesLocal,
            Integer torresLocal,
            Integer dragonesLocal,
            Integer oroVisitante,
            Integer minionsVisitante,
            Integer baronesVisitante,
            Integer torresVisitante,
            Integer dragonesVisitante,
            Equipo equipoLocal,
            Equipo equipoVisitante
    ) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.oroLocal = oroLocal;
        this.minionsLocal = minionsLocal;
        this.baronesLocal = baronesLocal;
        this.torresLocal = torresLocal;
        this.dragonesLocal = dragonesLocal;
        this.oroVisitante = oroVisitante;
        this.minionsVisitante = minionsVisitante;
        this.baronesVisitante = baronesVisitante;
        this.torresVisitante = torresVisitante;
        this.dragonesVisitante = dragonesVisitante;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;

        // Elije aleatoriamente el equipo ganador entre equipoLocal y equipoVisitante

        Random random = new Random();
        this.equipoGanador = random.nextBoolean() ? equipoLocal : equipoVisitante;
    }
}
