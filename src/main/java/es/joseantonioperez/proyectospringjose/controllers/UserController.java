package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.models.User;
import es.joseantonioperez.proyectospringjose.repositories.UserRepository;
import es.joseantonioperez.proyectospringjose.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    // Obtener la lista de todos los usuarios
    @GetMapping("/user/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por su ID
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Comprueba si ya existe un usuario con el mismo nombre de usuario o correo electrónico
        User existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());

        if (existingUser != null) {
            // Usuario con el mismo nombre de usuario o correo electrónico ya existe
            return ResponseEntity.badRequest().body("Nombre de usuario o correo electrónico ya están en uso.");
        } else {
            // No existe un usuario con el mismo nombre de usuario o correo electrónico, crea el nuevo usuario
            // Asegúrate de encriptar la contraseña aquí
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            User newUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
    }
    // Actualizar la información de un usuario
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    userRepository.save(user);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un usuario
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}