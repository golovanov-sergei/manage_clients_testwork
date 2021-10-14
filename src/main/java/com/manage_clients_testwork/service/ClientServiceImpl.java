package com.manage_clients_testwork.service;

import com.manage_clients_testwork.model.Client;
import com.manage_clients_testwork.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllCients() {
        Iterable<Client> clients = clientRepository.findAll();
        return (List<Client>) clients;
    }

    @Override
    public Client getClient(Long id) {
        Client client = null;
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            client = optional.get();
        }
        return client;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public void validateData(Client client) {

    }
}
