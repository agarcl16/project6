package com.alexGarcia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexGarcia.app.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
