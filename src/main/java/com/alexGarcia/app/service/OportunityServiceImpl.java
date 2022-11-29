package com.alexGarcia.app.service;

import java.util.function.BooleanSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.ContactRepository;
import com.alexGarcia.app.repository.OportunityRepository;

@Service
public class OportunityServiceImpl implements OportunityService{
	
	@Autowired
	private OportunityRepository oportunityRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean addOportunity(Oportunity op) {
		oportunityRepository.save(op);
		return false;
	}

	public boolean isOportunity(Oportunity op) {
		// TODO Auto-generated method stub
		return true;
	}

}
