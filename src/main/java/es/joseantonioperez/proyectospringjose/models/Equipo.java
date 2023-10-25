package es.joseantonioperez.proyectospringjose.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

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

}
