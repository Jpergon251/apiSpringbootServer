package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

   /* @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Verifica si el nombre de usuario o el correo electrónico ya existen
        if (userRepository.findByUsername(user.getUsername()) || userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Nombre de usuario o correo electrónico ya registrados", HttpStatus.BAD_REQUEST);
        }

        // Encripta la contraseña antes de guardarla
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Guarda el usuario en la base de datos
        userRepository.save(user);

        return new ResponseEntity<>("Usuario registrado con éxito", HttpStatus.CREATED);
    }*/
}