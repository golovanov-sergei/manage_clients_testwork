package com.manage_clients_testwork.controller;

import com.manage_clients_testwork.model.Client;
import com.manage_clients_testwork.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllCients();
    }
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.getClient(id);
    }
    @PostMapping("/clients")
    public void saveClient(@RequestBody Client client){
        clientService.validateData(client,true);
        clientService.saveClient(client);
    }
    @PutMapping("/clients")
    public void updateClient(@RequestBody Client client){
        clientService.validateData(client,false);
        clientService.saveClient(client);
    }
}
