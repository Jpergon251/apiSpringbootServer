package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.joseantonioperez.proyectospringjose.dto.JugadorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue
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
    private String foto;
    @JsonIgnoreProperties({"jugadores"})
    @ManyToOne
    @JoinColumn() // Esta anotación especifica la columna en la tabla "Jugador" que almacena la clave foránea "team_id"
    @JsonBackReference
    private Equipo equipo;

    // Constructor

    public Jugador() {
        // Constructor sin argumentos
    }

    public Jugador(String nick, String nombre, String posicion, Integer edad, String nacionalidad, String campeonFavorito, Integer bajas, Integer muertes, Integer asistencias, String foto, Equipo equipo) {
        this.nick = nick;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.campeonFavorito = campeonFavorito;
        this.bajas = bajas;
        this.muertes = muertes;
        this.asistencias = asistencias;
        this.foto = foto;
        this.equipo = equipo;
    }

    public Jugador(JugadorDTO jugador){
        this.nick = jugador.getNick();
        this.nombre = jugador.getNombre();
        this.posicion = jugador.getPosicion();
        this.edad = jugador.getEdad();
        this.nacionalidad = jugador.getNacionalidad();

    }
}
