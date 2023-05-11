package com.example.carserviceapp.controller;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    //getting a list of clients
    @GetMapping("/")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    //finding the client by id
    @GetMapping("/{id}")
    public ClientModel getClientById(@PathVariable("id") long id) {
        return clientService.getClientById(id);
    }

    //adding a new client
    @PostMapping("/")
    public ClientModel addClient(@RequestBody ClientModel client) {
        return clientService.addClient(client);

    }

    //editing client's details
    @PatchMapping("/{id}")
    public ClientModel EditClient(@PathVariable long id, @RequestBody ClientModel clientmodel) {
        return clientService.EditClient(id, clientmodel);
    }

    //deletion of the client
    @DeleteMapping("/{id}")
    public ClientModel removeClient(@PathVariable("id") long id) {
        return clientService.deleteClient(id);
    }

}