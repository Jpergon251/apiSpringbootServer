package es.joseantonioperez.proyectospringjose.models;

import es.joseantonioperez.proyectospringjose.dto.PartidaDTO;
import es.joseantonioperez.proyectospringjose.services.EquipoService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.time.LocalDateTime;

@Entity @Getter @Setter
public class Partida {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha;

    private Integer duracion;


    // Las Stats del equipo local
    private Integer oroLocal;
    private Integer minionsLocal;
    private Integer baronesLocal;
    private Integer torresLocal;
    private Integer dragonesLocal;

    // Las Stats del equipo visitante

    private Integer oroVisitante;
    private Integer minionsVisitante;
    private Integer baronesVisitante;
    private Integer torresVisitante;
    private Integer dragonesVisitante;


    private String equipoGanador;
    @ManyToOne
    private Equipo equipoLocal;

    @ManyToOne

    private Equipo equipoVisitante;



    // Constructor

    public Partida() {
        // Constructor sin argumentos
    }

    public Partida(
            LocalDateTime fecha,
            Integer duracion,
            Integer oroLocal,
            Integer minionsLocal,
            Integer baronesLocal,
            Integer torresLocal,
            Integer dragonesLocal,
            Integer oroVisitante,
            Integer minionsVisitante,
            Integer baronesVisitante,
            Integer torresVisitante,
            Integer dragonesVisitante,
            Equipo equipoLocal,
            Equipo equipoVisitante
    ) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.oroLocal = oroLocal;
        this.minionsLocal = minionsLocal;
        this.baronesLocal = baronesLocal;
        this.torresLocal = torresLocal;
        this.dragonesLocal = dragonesLocal;
        this.oroVisitante = oroVisitante;
        this.minionsVisitante = minionsVisitante;
        this.baronesVisitante = baronesVisitante;
        this.torresVisitante = torresVisitante;
        this.dragonesVisitante = dragonesVisitante;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;

        // Elije aleatoriamente el equipo ganador entre equipoLocal y equipoVisitante

        Random random = new Random();
        this.equipoGanador = random.nextBoolean() ? equipoLocal.getNombre() : equipoVisitante.getNombre();



    }
    public Partida(PartidaDTO partidaDTO) {
        this.id = partidaDTO.getId();
        this.fecha = partidaDTO.getFecha();
        this.duracion = partidaDTO.getDuracion();
        this.oroLocal = partidaDTO.getOroLocal();
        this.minionsLocal = partidaDTO.getMinionsLocal();
        this.baronesLocal = partidaDTO.getBaronesLocal();
        this.torresLocal = partidaDTO.getTorresLocal();
        this.oroVisitante = partidaDTO.getOroVisitante();
        this.minionsVisitante = partidaDTO.getMinionsVisitante();
        this.baronesVisitante = partidaDTO.getBaronesVisitante();
        this.torresVisitante = partidaDTO.getTorresVisitante();
        this.dragonesVisitante = partidaDTO.getDragonesVisitante();
        this.equipoGanador = partidaDTO.getEquipoGanador();
        this.equipoLocal = new Equipo(partidaDTO.getEquipoLocal());
        this.equipoVisitante = new Equipo(partidaDTO.getEquipoVisitante());
    }
}
