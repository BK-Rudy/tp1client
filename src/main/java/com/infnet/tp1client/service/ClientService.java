package com.infnet.tp1client.service;

import com.infnet.tp1client.domain.Client;
import com.infnet.tp1client.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        verifyCLient(id);
        return clientRepository.findById(id).get();
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Long id, Client client) {
        verifyCLient(id);
        client.setId(id);
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        verifyCLient(id);
        clientRepository.deleteById(id);
    }

    public void verifyCLient(Long id) {
        if (!clientRepository.existsById(id)) throw new EntityNotFoundException("Não há cliente com esse ID");
    }
}
