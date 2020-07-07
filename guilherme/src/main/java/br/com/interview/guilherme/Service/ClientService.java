package br.com.interview.guilherme.Service;

import br.com.interview.guilherme.DTO.CityDto;
import br.com.interview.guilherme.DTO.ClientDto;
import br.com.interview.guilherme.Entity.City;
import br.com.interview.guilherme.Entity.Client;
import br.com.interview.guilherme.Mapper.Mappable;
import br.com.interview.guilherme.Repository.CityRepository;
import br.com.interview.guilherme.Repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements Mappable {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CityRepository cityRepository;


    public ClientDto createClient(ClientDto clientDto) {
        Client client = map(clientDto, Client.class);
        client.setCities(validateCity(clientDto.getCities()));
        Client clientSave = clientRepository.save(client);
        ClientDto clientMapped = map(clientSave, ClientDto.class);
        return clientMapped;
    }

    private List<City> validateCity(List<CityDto> cities) {
        List<City> cityList = new ArrayList<>();
        for(CityDto city : cities){
            City cityValid = cityRepository.findByName(city.getName());
            if(cityValid != null){
                cityList.add(cityValid);
            }else {
                City newCity = new City();
                newCity.setName(city.getName());
                cityRepository.save(newCity);
                cityList.add(newCity);
            }
        }
        return cityList;
    }

    public ClientDto fetchId(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return map(client, ClientDto.class);
    }

    public Client findByName (String name){
        return clientRepository.findByName(name);
    }

    public void updateClient(ClientDto clientDto, String name) {
        Client cliente = clientRepository.findByName(name);
        clientDto.setName(name);
        clientRepository.save(map(clientDto, Client.class));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}
