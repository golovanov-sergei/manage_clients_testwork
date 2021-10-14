package com.manage_clients_testwork.repositories;

import com.manage_clients_testwork.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
