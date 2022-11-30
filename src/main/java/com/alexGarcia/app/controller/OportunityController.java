package com.alexGarcia.app.controller;

import com.alexGarcia.app.dto.OportunityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.service.OportunityService;

@Controller
@RequestMapping("oportunity")
public class OportunityController {

	@Autowired
	private OportunityService oportunityService;
	
	@PostMapping("/addOportunity")
	public ResponseEntity addOportunity(@RequestBody OportunityDTO op) {

		Oportunity op1 = new Oportunity();

		Oportunity newOp = oportunityService.addOportunity(op1);
		return ResponseEntity.status(HttpStatus.OK).body(newOp.print());
	}
}
