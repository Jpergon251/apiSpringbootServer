package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity @Getter @Setter
public class Partida {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha;
    private String equipoLocal;
    private String equipoVisitante;
    private String resultado;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Torneo torneo;

    // Constructor

    public Partida() {
        // Constructor sin argumentos
    }

    public Partida(LocalDateTime fecha, String equipoLocal, String equipoVisitante, String resultado, int duracion) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;
        this.duracion = duracion;
    }

}
