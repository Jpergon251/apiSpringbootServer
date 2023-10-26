package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
