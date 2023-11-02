package es.joseantonioperez.proyectospringjose.dto;

import es.joseantonioperez.proyectospringjose.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long Id;
    private String username;

    public UserDTO(User user){
        this.Id = user.getId();
        this.username = user.getUsername();
    }

}
