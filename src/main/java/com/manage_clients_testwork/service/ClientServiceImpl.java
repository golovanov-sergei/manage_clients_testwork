package com.manage_clients_testwork.service;

import com.manage_clients_testwork.exceptionhandler.ClientSaveException;
import com.manage_clients_testwork.model.Client;
import com.manage_clients_testwork.repositories.ClientRepository;
import com.manage_clients_testwork.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Client getClient(String email) {
        Client client = clientRepository.findClientByEmail(email);
        return client;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = null;
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()){
            client = optional.get();
            clientRepository.delete(client);
        }else {
            throw new ClientSaveException("Client ID("+id+") not found");
        }

    }

    //Возможно валидацию разных параметров следует разнести по разным функциям???
    @Override
    public void validateData(Client client, Boolean isANewUser) {
        if (client.getEmail() == null) {
            throw new ClientSaveException("Required field EMAIL not filled");
        }
        if (isANewUser && getClient(client.getEmail()) != null) {
            throw new ClientSaveException("Client's  email(" + client.getEmail() + ") already exists");
        }
        if (StringUtils.emailNotValid(client.getEmail())) {
            throw new ClientSaveException("Required field EMAIL not valid");
        }
        if (StringUtils.phoneNotValid(client.getPhone())) {
            throw new ClientSaveException("Required field PHONE not valid");
        }
        if (!isANewUser && client.getId() == 0L) {
            throw new ClientSaveException("Required field ID not filled");
        }
        if (!isANewUser && getClient(client.getId())==null) {
            throw new ClientSaveException("Client Id(" + client.getId() + ") doesn't exists");
        }

//      Проверка при редактировании клиента: принадлежит ли данный email другому клиенту
//      Если редактирование и указанный имейл есть в базе и айди указанного имейла не совпадает с айди редактируемого пользователя
//      Выбросить исключение
        if (!isANewUser && getClient(client.getEmail()) != null && getClient(client.getEmail()).getId() != client.getId()) {
            throw new ClientSaveException("Client's  email(" + client.getEmail() + ") already exists");
        }

    }
}
