package com.alexGarcia.app.service;

import com.alexGarcia.app.entity.Oportunity;

public interface OportunityService {

	Oportunity addOportunity(Oportunity op);

	Oportunity getOportunity(String name);
	
	Oportunity isOportunity(Oportunity op);

}
