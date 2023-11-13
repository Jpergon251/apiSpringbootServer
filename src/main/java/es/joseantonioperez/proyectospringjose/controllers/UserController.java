package es.joseantonioperez.proyectospringjose.controllers;

import es.joseantonioperez.proyectospringjose.dto.UserDTO;
import es.joseantonioperez.proyectospringjose.models.User;
import es.joseantonioperez.proyectospringjose.repositories.UserRepository;
import es.joseantonioperez.proyectospringjose.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    // Obtener la lista de todos los usuarios

    @GetMapping("/users/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por su ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Obtener los usuarios pero en DTO
    @GetMapping("/users/dto/")
    public ResponseEntity<Object> getUsersDTO() {
        List<UserDTO> response = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            response.add(new UserDTO(user));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/dto/{id}")
    public ResponseEntity<UserDTO> getUserDTOById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO(user.get());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Crear un nuevo usuario
    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Comprobar si ya existe un usuario con el mismo nombre de usuario
        User existingUserWithUsername = userRepository.findByUsername(user.getUsername());

        if (existingUserWithUsername != null) {
            // Usuario con el mismo nombre de usuario ya existe
            return ResponseEntity.badRequest().body("Nombre de usuario ya está en uso.");
        }

        // Comprobar si ya existe un usuario con el mismo correo electrónico
        User existingUserWithEmail = userRepository.findByEmail(user.getEmail());

        if (existingUserWithEmail != null) {
            // Usuario con el mismo correo electrónico ya está en uso
            return ResponseEntity.badRequest().body("Correo electrónico ya está en uso.");
        }

        // No existe un usuario con el mismo nombre de usuario ni con el mismo correo electrónico, crear el nuevo usuario
        // Asegurarse de encriptar la contraseña aquí
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(User.UserRole.USER); // Asignar el rol USER
        User newUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    // Actualizar la información de un usuario
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        return userRepository.findById(id)
                .map(user -> {
                    if (updatedUser.getUsername() != null && !updatedUser.getUsername().isEmpty()) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if (updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty()) {
                        user.setEmail(updatedUser.getEmail());
                    }
                    if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                        user.setPassword(new BCryptPasswordEncoder().encode(updatedUser.getPassword()));
                    }
                    if (updatedUser.getRole() != null) {
                        user.setRole(updatedUser.getRole());
                    }
                    userRepository.save(user);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un usuario
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}