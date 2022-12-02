package com.alexGarcia.app.controller;


import com.alexGarcia.app.dto.ContactDTO;
import com.alexGarcia.app.entity.Contact;
import com.alexGarcia.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> getConctacts(){
        List<Contact> list = contactService.showContacts();
        List<ContactDTO> listContact = new ArrayList<>();

        for(Contact co: list) {
            listContact.add(new ContactDTO(co.getId(), co.getName(), co.getDescription(), co.getDate(), co.getEmail(), co.getPhone(), co.getOportunity().getId()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(listContact);
    }


}
