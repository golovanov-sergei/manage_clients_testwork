package com.manage_clients_testwork.controller;

import com.manage_clients_testwork.exceptionhandler.ClientSaveException;
import com.manage_clients_testwork.exceptionhandler.Response;
import com.manage_clients_testwork.model.Client;
import com.manage_clients_testwork.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @GetMapping("/clients/{id}")
    @ApiOperation(value = "Finds client by Id",
            notes = "Provide an Id to look up specific client information from database",
            response = Client.class
    )
    public Client getClient(@ApiParam(value = "Id value for the client you want to retrieve",required = true)
                                @PathVariable Long id){
        return clientService.getClient(id);
    }

    @GetMapping("/clients")
    @ApiOperation(value = "Gets clients list",
            notes = "Provide a list of clients from database",
            response = Client.class,
            responseContainer = "List"
    )
    public List<Client> getAllClients(){
        return clientService.getAllCients();
    }

    @PostMapping("/clients")
    @ApiOperation(value = "Add new client to database",
            notes = "Add new client to database",
            response = Response.class
    )
    public ResponseEntity<Response> saveClient(@RequestBody Client client){
        Response response = new Response();
        clientService.validateData(client,true);
        clientService.saveClient(client);
        response.setSuccess(true);
        response.setMessage(client.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/clients")
    @ApiOperation(value = "Edit existing client in database",
            notes = "Edit existing client in database",
            response = Response.class
    )
    public ResponseEntity<Response> updateClient(@RequestBody Client client){
        Response response = new Response();
        clientService.validateData(client,false);
        clientService.saveClient(client);
        response.setSuccess(true);
        response.setMessage(client.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    @ApiOperation(value = "Deletes client from database",
            notes = "Deletes client from database",
            response = Response.class
    )
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
