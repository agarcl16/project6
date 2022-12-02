package com.alexGarcia.app.service;

import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.entity.Oportunity;

import java.io.InvalidObjectException;
import java.util.List;

public interface OportunityService {

	Oportunity addOportunity(OportunityDTO op);

	Oportunity getOportunity(String name);
	
	Oportunity isOportunity(Oportunity op);

	Client isClient(String name);

	OportunityDTO checkInfo(OportunityDTO op) throws InvalidObjectException;

	List<Oportunity> showOportunities();
}
