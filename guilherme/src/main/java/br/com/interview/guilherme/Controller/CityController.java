package br.com.interview.guilherme.Controller;

import br.com.interview.guilherme.DTO.CityDto;
import br.com.interview.guilherme.Service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST - Cidade")
@RestController
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @ApiOperation(value = "Salvar uma cidade")
    @PostMapping("/city")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody CityDto cityDto) {
        cityService.saveCity(cityDto);
    }
}
