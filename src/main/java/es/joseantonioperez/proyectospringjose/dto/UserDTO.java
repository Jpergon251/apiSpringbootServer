package es.joseantonioperez.proyectospringjose.dto;

import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long Id;
    private String username;
    private String email;
    private List<Jugador> jugadoresFavoritos;
    private User.UserRole role;

    public UserDTO(User user){
        this.Id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.jugadoresFavoritos = user.getJugadoresFavoritos();
        this.role = user.getRole();
    }

}
