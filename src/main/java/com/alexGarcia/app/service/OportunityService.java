package com.alexGarcia.app.service;

import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.entity.Oportunity;

import java.io.InvalidObjectException;

public interface OportunityService {

	Oportunity addOportunity(OportunityDTO op);

	Oportunity getOportunity(String name);
	
	Oportunity isOportunity(Oportunity op);

	OportunityDTO checkInfo(OportunityDTO op) throws InvalidObjectException;
}
