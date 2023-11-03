package es.joseantonioperez.proyectospringjose.dto;

import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
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

    private List<JugadorDTO> jugadores;

    public EquipoDTO(
            Equipo equipo
    ) {
        this.id = equipo.getId();
        this.nombre = equipo.getNombre();
        this.nickCoach = equipo.getNickCoach();
        this.coach = equipo.getCoach();
        this.logo = equipo.getLogo();

        this.jugadores = new ArrayList<>();
        for (Jugador jugador : equipo.getJugadores()){
            this.jugadores.add(new JugadorDTO(jugador));
        }
    }
}
