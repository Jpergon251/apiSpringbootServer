package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.models.User;
import es.joseantonioperez.proyectospringjose.repositories.UserRepository;
import es.joseantonioperez.proyectospringjose.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    // Obtener la lista de todos los usuarios
    @GetMapping
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
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
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

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // user debe contener el email y la contraseña proporcionados por el cliente

        User loggedUser = userRepository.findByEmail(user.getEmail());

        if (loggedUser != null && user.getPassword().equals(loggedUser.getPassword())) {
            // El usuario se autenticó exitosamente
            // Genera un token de acceso
            Authentication authentication = new UsernamePasswordAuthenticationToken(loggedUser.getUsername(), null, Collections.emptyList());
            String accessToken = tokenService.generateToken(authentication);

            return ResponseEntity.ok(accessToken);
        } else {
            // Las credenciales son incorrectas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}