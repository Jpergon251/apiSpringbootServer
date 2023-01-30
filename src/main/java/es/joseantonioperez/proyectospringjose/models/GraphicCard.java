package es.joseantonioperez.proyectospringjose.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class GraphicCard {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String companyName;

    private Integer modelNumber;
}
