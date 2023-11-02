package es.joseantonioperez.proyectospringjose.dto;

import es.joseantonioperez.proyectospringjose.models.Partida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO implements Serializable {
    private Long id;
    private LocalDateTime fecha;
    private Integer duracion;
    private Integer oroLocal;
    private Integer minionsLocal;
    private Integer baronesLocal;
    private Integer torresLocal;
    private Integer dragonesLocal;
    private Integer oroVisitante;
    private Integer minionsVisitante;
    private Integer baronesVisitante;
    private Integer torresVisitante;
    private Integer dragonesVisitante;
    private String equipoGanador;
    private EquipoDTO equipoLocal;
    private EquipoDTO equipoVisitante;

    public PartidaDTO(Partida partida) {

        this.id = partida.getId();
        this.fecha = partida.getFecha();
        this.duracion = partida.getDuracion();
        this.oroLocal = partida.getOroLocal();
        this.minionsLocal = partida.getMinionsLocal();
        this.baronesLocal = partida.getBaronesLocal();
        this.torresLocal = partida.getTorresLocal();
        this.oroVisitante = partida.getOroVisitante();
        this.minionsVisitante = partida.getMinionsVisitante();
        this.baronesVisitante = partida.getBaronesVisitante();
        this.torresVisitante = partida.getTorresVisitante();
        this.dragonesVisitante = partida.getDragonesVisitante();
        this.equipoGanador = partida.getEquipoGanador();
        this.equipoLocal = new EquipoDTO(partida.getEquipoLocal());
        this.equipoVisitante = new EquipoDTO(partida.getEquipoVisitante());

    }
}
