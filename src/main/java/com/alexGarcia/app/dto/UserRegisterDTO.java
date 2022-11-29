package com.alexGarcia.app.dto;

public class UserRegisterDTO {
	private Long id;
	private String name;
	private String surname;
	private String userName;
	private String password;

	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param userName
	 * @param password
	 */
	public UserRegisterDTO(Long id, String name, String surname, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @param name
	 * @param surname
	 * @param userName
	 * @param password
	 */
	public UserRegisterDTO(String name, String surname, String userName, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @param userName
	 */
	public UserRegisterDTO(String userName) {
		super();
		this.userName = userName;
	}

	/**
	 * 
	 */
	public UserRegisterDTO() {
		super();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
