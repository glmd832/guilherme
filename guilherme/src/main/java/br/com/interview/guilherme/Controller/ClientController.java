package br.com.interview.guilherme.Controller;

import br.com.interview.guilherme.DTO.ClientDto;
import br.com.interview.guilherme.Entity.Client;
import br.com.interview.guilherme.Service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(value = "API REST - Cliente")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Cadastrar Cliente")
    @PostMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClientDto clientDto) {
        ClientDto responseClient = clientService.createClient(clientDto);
    }

    @ApiOperation(value = "Consultar cliente pelo ID")
    @GetMapping("/client/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ClientDto fetchId (@PathVariable Long id){
        return clientService.fetchId(id);
    }

    @ApiOperation(value = "Consultar um cliente pelo nome")
    @GetMapping("/client/{nome}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Client fetchName (@PathVariable String name) {
        return clientService.findByName(name);
    }

    @ApiOperation(value = "Alterar o nome do cliente")
    @PutMapping("/client/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ClientDto clientDto, @PathVariable String name){
        clientService.updateClient(clientDto, name);
    }

    @ApiOperation(value = "Deletar cliente")
    @DeleteMapping("/client/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        clientService.deleteClient(id);
    }
}
