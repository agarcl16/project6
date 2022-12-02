package com.alexGarcia.app.controller;

import com.alexGarcia.app.dto.ClientDTO;
import com.alexGarcia.app.dto.ContactDTO;
import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.dto.OportunityDTO2;
import com.alexGarcia.app.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.service.OportunityService;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("oportunity")
@CrossOrigin(origins = "http://localhost:3000")
public class OportunityController {

	@Autowired
	private OportunityService oportunityService;

	@GetMapping("/oportunities")
	public ResponseEntity<List<OportunityDTO2>> getClientes(){
		List<Oportunity> list = oportunityService.showOportunities();
		List<OportunityDTO2> listOportunity = new ArrayList<>();
		List<ContactDTO> listContact;
		for(Oportunity o : list) {
			listContact = new ArrayList<>();
			for(Contact co: o.getContacts()) {
				listContact.add(new ContactDTO(co.getId(), co.getName(), co.getDescription(), co.getDate(), co.getEmail(), co.getPhone(), co.getOportunity().getId()));
			}
			listOportunity.add(new OportunityDTO2(o.getId(), o.getName(), o.getClient()==null?null:o.getClient().getId(), o.getEmail(), o.getPhone(), listContact, o.getDescription()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(listOportunity);
	}

	@PostMapping("/addOportunity")
	public ResponseEntity addOportunity(@RequestBody OportunityDTO op) {
		Oportunity newOp;
		try{
			oportunityService.checkInfo(op);
			newOp = oportunityService.addOportunity(op);
		}catch(InvalidObjectException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(newOp.print());
	}
}
