package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "usercustom")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String email;
    private String password;
    public enum UserRole {
        ADMIN,
        USER,

        BANNED
    }
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany
    private List<Jugador> jugadoresFavoritos;

    @OneToMany
    private List<Equipo> equiposFavoritos;
    public User(String username, String email, String password, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.role = role;
    }
}
