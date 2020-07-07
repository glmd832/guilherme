package br.com.interview.guilherme.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class StateDto implements Serializable {
    private static final long serialVersionUID = -1305028115734825907L;

    private Long id;
    private String name;
}
