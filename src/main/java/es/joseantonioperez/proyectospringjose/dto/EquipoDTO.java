package es.joseantonioperez.proyectospringjose.dto;

import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDTO implements Serializable {

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
    private List<JugadorDTO> jugadores;


    public EquipoDTO(
            Equipo equipo
    ) {
        this.id = equipo.getId();
        this.nombre = equipo.getNombre();
        this.nickCoach = equipo.getNickCoach();
        this.coach = equipo.getCoach();
        this.logo = equipo.getLogo();
        this.tiempoDeJuego = equipo.getTiempoDeJuego();
        this.victorias = equipo.getVictorias();
        this.derrotas = equipo.getDerrotas();
        this.oro = equipo.getOro();
        this.minions = equipo.getMinions();
        this.barones = equipo.getBarones();
        this.torres = equipo.getTorres();
        this.dragones = equipo.getDragones();
        for (Jugador jugador : equipo.getJugadores()){
            jugadores.add(new JugadorDTO(jugador));
        }
    }


}
