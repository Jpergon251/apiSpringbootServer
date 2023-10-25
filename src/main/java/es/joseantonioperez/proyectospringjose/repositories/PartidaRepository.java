package es.joseantonioperez.proyectospringjose.repositories;

import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Partida;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartidaRepository extends CrudRepository<Partida,Long > {
    List<Partida> findByEquipoLocalOrEquipoVisitante(Equipo equipo, Equipo equipo1);
}
