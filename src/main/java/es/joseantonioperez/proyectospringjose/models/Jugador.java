package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private List<EstadisticasJugador> estadisticasJugadorList;

    // Constructor, getters y setters
}
