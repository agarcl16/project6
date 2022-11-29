package com.alexGarcia.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Oportunity> oportunities;

	/**
	 * @param name
	 */
	public Client(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public Client(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public List<Oportunity> getOportunities() {
		return oportunities;
	}

	public void setOportunities(List<Oportunity> oportunities) {
		this.oportunities = oportunities;
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

}
