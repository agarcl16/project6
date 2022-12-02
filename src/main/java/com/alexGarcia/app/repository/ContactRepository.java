package com.alexGarcia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alexGarcia.app.entity.Contact;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query(value ="SELECT * FROM contact s WHERE s.date > :now", nativeQuery=true)
    List<Contact> findAllByDate(LocalDate now);
}
