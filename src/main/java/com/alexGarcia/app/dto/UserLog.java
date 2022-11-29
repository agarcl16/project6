package com.alexGarcia.app.dto;

public class UserLog {

	private Long id;
	private String userName;
	private String password;

	/**
	 * @param userName
	 * @param password
	 */
	public UserLog(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 */
	public UserLog(Long id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	/**
	 * 
	 */
	public UserLog() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
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
