package com.alexGarcia.app.service;

import java.util.function.BooleanSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.ContactRepository;
import com.alexGarcia.app.repository.OportunityRepository;

@Service
public class OportunityServiceImpl implements OportunityService {

	@Autowired
	private OportunityRepository oportunityRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Oportunity addOportunity(Oportunity op) {

		return oportunityRepository.save(op);
	}

	@Override
	public boolean isOportunity(Oportunity op) {
		return oportunityRepository.getByName(op.getName());
	}

}
