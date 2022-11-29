package com.alexGarcia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexGarcia.app.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {

}
