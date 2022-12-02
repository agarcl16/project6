package com.alexGarcia.app.service;
import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.entity.Contact;
import com.alexGarcia.app.repository.ClientRepository;
import com.alexGarcia.app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> showContacts() {
        return contactRepository.findAllByDate(LocalDate.now());
    }
}
