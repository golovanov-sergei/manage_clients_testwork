package com.manage_clients_testwork.service;

import com.manage_clients_testwork.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllCients();
    public Client getClient(Long id);
    public Client getClient(String email);
    public void saveClient(Client client);
    public void deleteClient(Long id);
    public void validateData(Client client,Boolean isANewUser);
}
