package br.com.interview.guilherme.DTO;

import br.com.interview.guilherme.Entity.City;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ClientDto implements Serializable {
    private static final long serialVersionUID = 9165040598760173860L;

    private Long id;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private Integer age;
    private List<CityDto> cities;
}
