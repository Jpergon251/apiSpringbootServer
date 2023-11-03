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


    public JugadorDTO(Jugador jugador){
        this.id = jugador.getId();
        this.nick = jugador.getNick();
        this.nombre = jugador.getNombre();
        this.posicion = jugador.getPosicion();
        this.edad = jugador.getEdad();
        this.nacionalidad = jugador.getNacionalidad();

    }

}
