package com.example.carserviceapp.service;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientModel addClient(ClientModel clientModel) {
        ClientModel clientModel1 = ClientModel.builder()
                .name(clientModel.getName())
                .surname(clientModel.getSurname())
                .number(clientModel.getNumber())
                .email(clientModel.getEmail())
                .document(clientModel.getDocument())
                .build();
        clientRepository.save(clientModel1);
        return clientModel1;
    }


    public ClientModel EditClient(long id, ClientModel clientModel) {
        ClientModel modelNew = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        modelNew.setName(clientModel.getName());
        modelNew.setSurname(clientModel.getSurname());
        modelNew.setNumber(clientModel.getNumber());
        modelNew.setEmail(clientModel.getEmail());
        modelNew.setDocument(modelNew.getDocument());
        modelNew = clientRepository.save(modelNew);
        return modelNew;
    }

    public ClientModel deleteClient(Long id) {
        clientRepository.deleteById(id);
        return null;
    }

    public ClientModel getClientById(Long id) {
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return clientRepository.findById(id).orElse(null);
        } else {
            log.info("nothing found");
            return null;
        }
    }

}
