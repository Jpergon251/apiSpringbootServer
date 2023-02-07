package es.joseantonioperez.proyectospringjose.repositories;

import es.joseantonioperez.proyectospringjose.models.Jugador;
import org.springframework.data.repository.CrudRepository;

public interface JugadorRepository extends CrudRepository<Jugador, Long> {
}
