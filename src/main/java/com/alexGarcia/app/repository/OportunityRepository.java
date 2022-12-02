package com.alexGarcia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexGarcia.app.entity.Oportunity;

@Repository
public interface OportunityRepository extends JpaRepository<Oportunity, Long> {

	public Oportunity findByName(String name);
}
