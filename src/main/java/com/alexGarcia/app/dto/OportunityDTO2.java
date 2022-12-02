package com.alexGarcia.app.dto;

import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.entity.Contact;

import javax.persistence.*;
import java.util.List;

public class OportunityDTO2 {
    private Long id;
    private String name;
    private Long client;
    private String email;
    private String phone;
    private List<ContactDTO> contacts;
    private String description;

    public OportunityDTO2(Long id, String name, Long client, String email, String phone, List<ContactDTO> contacts, String description) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.email = email;
        this.phone = phone;
        this.contacts = contacts;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getClient() {
        return client;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
