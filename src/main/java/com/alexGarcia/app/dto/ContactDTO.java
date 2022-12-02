package com.alexGarcia.app.dto;

import com.alexGarcia.app.entity.Oportunity;

import javax.persistence.*;
import java.time.LocalDate;

public class ContactDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String email;
    private String phone;
    private Long oportunity;

    public ContactDTO(Long id, String name, String description, LocalDate date, String email, String phone, Long oportunity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.email = email;
        this.phone = phone;
        this.oportunity = oportunity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Long getOportunity() {
        return oportunity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOportunity(Long oportunity) {
        this.oportunity = oportunity;
    }
}
