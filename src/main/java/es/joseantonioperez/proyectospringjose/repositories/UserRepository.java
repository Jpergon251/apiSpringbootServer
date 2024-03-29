package es.joseantonioperez.proyectospringjose.repositories;

import es.joseantonioperez.proyectospringjose.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);


    User findByUsernameOrEmail(String username, String email);
}
