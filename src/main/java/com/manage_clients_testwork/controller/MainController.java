package com.manage_clients_testwork.controller;

import com.manage_clients_testwork.exceptionhandler.ClientSaveException;
import com.manage_clients_testwork.exceptionhandler.Response;
import com.manage_clients_testwork.model.Client;
import com.manage_clients_testwork.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> saveClient(@RequestBody Client client){
        Response response = new Response();
        clientService.validateData(client,true);
        clientService.saveClient(client);
        response.setSuccess(true);
        response.setMessage(client.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/clients")
    public ResponseEntity<Response> updateClient(@RequestBody Client client){
        Response response = new Response();
        clientService.validateData(client,false);
        clientService.saveClient(client);
        response.setSuccess(true);
        response.setMessage(client.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Response> deleteClient(@PathVariable long id){
        Response response = new Response();
        clientService.deleteClient(id);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<Response> handleException(ClientSaveException exception){
        Response response = new Response();
        response.setSuccess(false);
        response.setFatal(false);
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
