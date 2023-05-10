package com.example.carserviceapp.service;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){return clientRepository.findAll();}

    public void addClient(ClientModel clientModel){clientRepository.save(clientModel);}

    public void SaveEditClient(ClientModel clientModel){clientRepository.save(clientModel);}

    public void deleteClient(Long id){clientRepository.deleteById(id);}

    public ClientModel getClientById(Long id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if(client.isPresent()){
            return clientRepository.findById(id).orElse(null);
        } else {
            log.info("nothing found");
            return null;
        }
    }

}
