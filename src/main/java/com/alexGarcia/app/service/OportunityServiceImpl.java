package com.alexGarcia.app.service;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.alexGarcia.app.dto.OportunityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexGarcia.app.entity.Contact;
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
	public Oportunity addOportunity(OportunityDTO op) {

		return null;
	}

	@Override
	public Oportunity getOportunity(String name) {
		return oportunityRepository.findByName(name);
	}

	@Override
	public Oportunity isOportunity(Oportunity op) {
		return oportunityRepository.findByName(op.getName());
	}

	@Override
	public OportunityDTO checkInfo(OportunityDTO op) throws InvalidObjectException {
		if(op.getName()==null)
			throw  new InvalidObjectException("The information must include name");
		else if(op.getEmail()==null && op.getPhone()==null)
			throw  new InvalidObjectException("The information must include email or phone");
		else if(op.getDescription()==null)
			throw new InvalidObjectException("The information must include description");
		else if(op.getFurtureClient().equals("T")){
			if(op.getBussinesName()==null)
				throw new InvalidObjectException("There is no BussinessName");
		}
		if(op.getFutureAction()!=null){
			try{
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fecha = LocalDate.parse(op.getFutureAction(), formato);
				if(fecha.isBefore(LocalDate.now())||fecha.isEqual((LocalDate.now())))
					throw new InvalidObjectException("Future Date must be after today");
			}catch(Exception e){
				throw new InvalidObjectException("Not a valid Date");
			}
		}
		return op;
	}

}
