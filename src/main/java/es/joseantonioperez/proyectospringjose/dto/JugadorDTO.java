package es.joseantonioperez.proyectospringjose.dto;

import es.joseantonioperez.proyectospringjose.models.Jugador;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO  implements Serializable {

    private Long id;
    private String nick;
    private String nombre;
    private String posicion;
    private Integer edad;
    private String nacionalidad;
    private String campeonFavorito;
    private Integer bajas;
    private Integer muertes;
    private Integer asistencias;
    private Double kda;
    private String foto;
    private String equipo;


    public JugadorDTO(Jugador jugador){
        this.id = jugador.getId();
        this.nick = jugador.getNick();
        this.nombre = jugador.getNombre();
        this.posicion = jugador.getPosicion();
        this.edad = jugador.getEdad();
        this.nacionalidad = jugador.getNacionalidad();
        this.campeonFavorito = jugador.getCampeonFavorito();
        this.bajas = jugador.getBajas();
        this.muertes = jugador.getMuertes();
        this.asistencias = jugador.getAsistencias();
        this.foto = jugador.getFoto();
        this.kda = jugador.getKda();
        this.equipo = jugador.getEquipo().getNombre();
    }

}
