package model;

import java.sql.Date;

public class Client {
	
	private int id;
	
	private String name;
	
	private String surname;
	
	private String direction;
	
	private int DNI;
	
	private Date date;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param surname
	 * @param direction
	 */
	
	public Client (String name, String surname, String direction, int DNI, Date date) {
		this.name = name;
		this.surname = surname;
		this.direction = direction;
		this.DNI = DNI;
		this.date = date;
	}
	
	/**Getters & Setters */
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	/**
	 * @return the DNI
	 */
	public int getDNI() {
		return DNI;
	}
	
	/**
	 * @param DNI the DNI to set
	 */
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
