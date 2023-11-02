package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import es.joseantonioperez.proyectospringjose.dto.EquipoDTO;
import es.joseantonioperez.proyectospringjose.dto.JugadorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Equipo {
    @Id
    @GeneratedValue
    private Long id;



    private String nombre;
    private String nickCoach;
    private String coach;
    private String logo;

    private Integer tiempoDeJuego;
    private Integer victorias;
    private Integer derrotas;
    private Integer oro;
    private Integer minions;
    private Integer barones;
    private Integer torres;
    private Integer dragones;




    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference
    private List<Jugador> jugadores;


    // Constructor
    public Equipo() {
        // Constructor sin argumentos
    }
    public Equipo(
            String nombre,
            String coach,
            String nickCoach
            ) {
        this.nombre = nombre;
        this.coach = coach;
        this.nickCoach = nickCoach;


    }

    public Equipo(EquipoDTO equipoDTO){
        this.nombre = equipoDTO.getNombre();
        this.coach = equipoDTO.getCoach();
        this.nickCoach = equipoDTO.getNickCoach();
        this.logo = equipoDTO.getLogo();
        this.tiempoDeJuego = equipoDTO.getTiempoDeJuego();
        this.victorias = equipoDTO.getVictorias();
        this.derrotas = equipoDTO.getDerrotas();
        this.oro = equipoDTO.getOro();
        this.minions = equipoDTO.getMinions();
        this.barones = equipoDTO.getBarones();
        this.torres = equipoDTO.getTorres();
        this.dragones = equipoDTO.getDragones();
        this.jugadores = new ArrayList<>();
        for (JugadorDTO jugadorDTO : equipoDTO.getJugadores()) {
            // Crea una instancia de Jugador a partir de JugadorDTO y luego agrega el jugador a la lista
            Jugador jugador = new Jugador(jugadorDTO);
            jugadores.add(jugador);
        }

    }

}
