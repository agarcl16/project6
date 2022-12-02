package com.alexGarcia.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "oportunity_id")
    private Oportunity oportunity;

    /**
     *
     */
    public Contact() {
        super();
    }

    /**
     * @param name
     * @param description
     */
    public Contact(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    /**
     * @param name
     * @param description
     * @param date
     */
    public Contact(String name, String description, LocalDate date) {
        super();
        this.name = name;
        this.description = description;
        this.date = date;
    }

    /**
     * @param id
     * @param name
     * @param description
     */
    public Contact(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Oportunity getOportunity() {
        return oportunity;
    }

    public void setOportunity(Oportunity oportunity) {
        this.oportunity = oportunity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String print() {
        String retorno = "\tId: " + this.getId() + "\n\tName: " + this.getName() + "\n\tDescription: " + this.getDescription();
        return retorno;
    }

}
