package com.alexGarcia.app.service;

import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> showClients() {
        return clientRepository.findAll();
    }
}
