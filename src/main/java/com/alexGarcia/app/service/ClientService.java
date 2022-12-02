package com.alexGarcia.app.service;

import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.entity.Oportunity;

import java.io.InvalidObjectException;
import java.util.List;

public interface ClientService {

	List<Client> showClients();
}
