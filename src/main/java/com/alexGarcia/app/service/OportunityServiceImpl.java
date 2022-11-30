package com.alexGarcia.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

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
	public Oportunity addOportunity(Oportunity op) {

		Oportunity op2 = isOportunity(op);
		if(op2==null) {
			op2 = oportunityRepository.save(op);		
		}
		Contact contact = new Contact(op.getName(), op.getDescription());
		contact.setOportunity(op2);
		if (op2.getContacts() == null) {
			List<Contact> list = new ArrayList<Contact>();
			list.add(contact);
			op2.setContacts(list);
		}
		contactRepository.save(contact);
		return getOportunity(op2.getName());
	}

	@Override
	public Oportunity getOportunity(String name) {
		return oportunityRepository.findByName(name);
	}

	@Override
	public Oportunity isOportunity(Oportunity op) {
		return oportunityRepository.findByName(op.getName());
	}

}
