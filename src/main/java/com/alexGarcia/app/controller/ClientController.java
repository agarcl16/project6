package com.alexGarcia.app.controller;

import com.alexGarcia.app.dto.ClientDTO;
import com.alexGarcia.app.dto.ContactDTO;
import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.dto.OportunityDTO2;
import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.entity.Contact;
import com.alexGarcia.app.service.ClientService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.service.OportunityService;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getClientes(){
        List<Client> lista = clientService.showClients();
        List<ClientDTO> listClient = new ArrayList<>();
        List<OportunityDTO2> listOportunity;
        List<ContactDTO> listContact;

        for(Client c : lista){
            listOportunity = new ArrayList<>();
            for(Oportunity o : c.getOportunities()) {
                listContact = new ArrayList<>();
                for(Contact co: o.getContacts()) {
                    listContact.add(new ContactDTO(co.getId(), co.getName(), co.getDescription(), co.getDate(), co.getEmail(), co.getPhone(), co.getOportunity().getId()));
                }
                listOportunity.add(new OportunityDTO2(o.getId(), o.getName(), o.getClient().getId(), o.getEmail(), o.getPhone(), listContact, o.getDescription()));
            }
            listClient.add(new ClientDTO(c.getId(),c.getName(),listOportunity));
        }

        return ResponseEntity.status(HttpStatus.OK).body(listClient);
    }

    /*public List<Client> getClients(){
        List<Client> lista = clientService.showClients();
        return lista;
    }*/
}
