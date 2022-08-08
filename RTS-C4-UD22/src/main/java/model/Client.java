package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Client {
	
	private int id;
	private String name;
	private String surname;
	private String direction;
	private int DNI;
	private Date date;
	
	private String answer;
	private String query;
	
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
	
	public Connection connection;
	
	public Connection getConexion() {
		return connection;
	}
	
	public String manipulateDB(String name, String action, String query) {
		try {
			String QueryDB = "USE ud22";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(QueryDB);
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			return ("Data " + name + " succesfully");
		} catch (SQLException e) {
			return ("Failed by " + action + " data");
		}
	}
	
	public String Select (String action, String query) {
		String result = "";
		
		try {
			
			String sql = "Select * from client where id = ? " ;
			String QueryDB = "USE ud22";
			
			Statement stdb = connection.createStatement();
			
			stdb.executeUpdate(QueryDB);
			PreparedStatement query_ = connection.prepareStatement(sql);
			
			query_.setInt(1, Integer.parseInt(query));
			ResultSet results = query_.executeQuery();
			
			while (results.next()) {
				
				result += results.getString("id") + " ";
				result += results.getString("name") + " ";
				result += results.getString("surname") + " ";
				result += results.getString("direction") + " ";
				result += results.getString("DNI") + " ";
				result += results.getString("date") + " ";
			}
			results.close();
			return result;
		} catch (SQLException e) {
			System.out.println(e);
			return "Failed by " + action + " data";
		}
	}
	
	public void insertData() {

		SQLConnection SQL = new SQLConnection();
		String TA22 = null;
		String SQLquery = null;
		SQL.insertData(TA22, SQLquery);

		answer = manipulateDB("insterts", "insert", query);

		SQL.closeConnection();
	}
	
	public void deleteData() {

		SQLConnection SQL = new SQLConnection();
		SQL.makeConection();

		answer = manipulateDB("deletes", "delete", query);

		SQL.closeConnection();

	}

	public void updateData() {

		SQLConnection SQL = new SQLConnection();
		SQL.makeConection();

		answer = manipulateDB("updates", "update", query);

		SQL.closeConnection();

	}
	
	public void selectData() {
		SQLConnection SQL = new SQLConnection();
		SQL.makeConection();

		answer = Select("select", query);

		SQL.closeConnection();
	}
	
	}
