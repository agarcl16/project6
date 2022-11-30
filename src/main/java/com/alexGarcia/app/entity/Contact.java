package com.alexGarcia.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

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

	public String print(){
		String retorno = "\tId: "+this.getId()+"\n\tName: "+this.getName()+"\n\tDescription: "+this.getDescription();
		return retorno;
	}

}
