package es.joseantonioperez.proyectospringjose.models;

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

    private String nombre;
    private String posicion;
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "team_id") // Esta anotación especifica la columna en la tabla "Jugador" que almacena la clave foránea "team_id"
    private Equipo equipo;

    // Constructor

    public Jugador() {
        // Constructor sin argumentos
    }

    public Jugador(String nombre, String posicion, Integer edad) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }


}
