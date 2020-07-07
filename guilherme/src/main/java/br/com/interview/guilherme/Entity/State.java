package br.com.interview.guilherme.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "state")
public class State implements Serializable {
    private static final long serialVersionUID = -8673807357289662663L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Nome é obrigatório")
    private String name;

}
