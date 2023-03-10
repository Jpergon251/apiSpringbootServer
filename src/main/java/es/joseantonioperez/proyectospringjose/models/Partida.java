package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter
public class Partida {
    @Id
    @GeneratedValue
    private Long id;
    private Double duracion;
    @JsonManagedReference(value = "partida")
    @OneToMany(mappedBy = "partida")
    private List<JuegoPartidaJugador> juegoPartidaJugador;

    public Partida(){

    };

    public Partida(double duracion) {
        this.duracion = duracion;
    }
}
