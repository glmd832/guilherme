package br.com.interview.guilherme.Service;

import br.com.interview.guilherme.DTO.CityDto;
import br.com.interview.guilherme.Entity.City;
import br.com.interview.guilherme.Mapper.Mappable;
import br.com.interview.guilherme.Repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CityService implements Mappable {

    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    public CityService(CityRepository cityRepository, ModelMapper mapper) {
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    public void saveCity(CityDto cityDto) {
        City city = map(cityDto, City.class);
        cityRepository.save(city);
    }

    public City findByName (String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public ModelMapper mapper() {
        return null;
    }
}
