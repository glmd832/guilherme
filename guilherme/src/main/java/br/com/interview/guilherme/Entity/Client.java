package br.com.interview.guilherme.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1618676620832009403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotNull
    @NotBlank(message = "Genero é obrigatório")
    private String gender;

    @NotBlank(message = "Data de nascimento é obrigatório")
    private Date dateOfBirth;

    @NotBlank(message = "Idade é obrigatório")
    private Integer age;

    @OneToMany
    @JoinColumn(name = "cities_id")
    private List<City> cities;
}
