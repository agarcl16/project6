package com.alexGarcia.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "oportunity")
public class Oportunity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@ManyToOne(optional = true)
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(length = 200)
	private String email;

	@Column(length = 50)
	private String phone;

	@OneToMany(mappedBy = "oportunity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts;

	/**
	 * @param name
	 * @param client
	 * @param email
	 * @param phone
	 */
	public Oportunity(String name, Client client, String email, String phone) {
		super();
		this.name = name;
		this.client = client;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * @param name
	 * @param email
	 * @param phone
	 * @param contacts
	 */
	public Oportunity(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * @param id
	 * @param name
	 * @param client
	 * @param email
	 * @param phone
	 */
	public Oportunity(Long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * 
	 */
	public Oportunity() {
		super();
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

}
