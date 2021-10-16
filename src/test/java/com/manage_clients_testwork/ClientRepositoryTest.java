package com.manage_clients_testwork;

import com.manage_clients_testwork.model.Client;
import com.manage_clients_testwork.repositories.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void getClientTest() {
        Client client = new Client("test@mail.com","LAst name","First name","Middle name","+70000000001");
        clientRepository.save(client);
        client = clientRepository.findClientByEmail("test@mail.com");
        Assertions.assertThat(client.getMiddleName()).isEqualTo("Middle name");
    }

}
