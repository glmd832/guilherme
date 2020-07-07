package br.com.interview.guilherme.DTO;

import br.com.interview.guilherme.Entity.State;
import lombok.Data;

import java.io.Serializable;

@Data
public class CityDto implements Serializable {
    private static final long serialVersionUID = -876595809449308019L;

    private Long id;
    private String name;
    private StateDto stateDto;
}
