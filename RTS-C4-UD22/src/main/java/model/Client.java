package model;

import java.sql.Date;
import java.sql.ResultSet;

public class Client {
	
	public void tableStructureCreation(SQLConnection connection) {		
		String structure  = "create table if not exists clients ("
				+ "	id int(11) NOT NULL AUTO_INCREMENT,"
				+ " name varchar(250) DEFAULT NULL,"
				+ " surname varchar(250) DEFAULT NULL,"
				+ " adress varchar(250) DEFAULT NULL,"
				+ " DNI int(11) DEFAULT NULL,"
				+ " date date DEFAULT NULL,"
				+ " PRIMARY KEY (id)"
				+ ");";
		connection.insertData(structure);
	}
	
	/**	that return all the clients stored in the database
	 * @param connection Connection with the database
	 * @return all the clients that the select has returned
	 */
	public ResultSet selectAllClients(SQLConnection connection) {		
		String query = "select * from clients;";
		return connection.getValues(query);
	}
	
	/**
	 * Method that return a video from the database
	 * @param connection Connection with the database
	 * @param id of the client from which you want to obtain the fields
	 * @return
	 */
	public ResultSet selectOneClient(SQLConnection connection, int id) {		
		String query = "select * from clients where id="+id+";";
		return connection.getValues(query);
	}
	
	/**
	 * 
	 * @param connection Connection with the database
	 * @param id id of the client
	 * @param name new name of the client
	 * @param surname new surname of the client
	 * @param adress new adress of the client 
	 * @param DNI new DNI of the client 
	 * @param date new date of the client 
	 */
	public void updateClients(SQLConnection connection, int id, String name ,String surname,String adress,  int DNI, String date) {		
		String query = "UPDATE clients set name='" + name + "', surname='" + surname + "' ,adress='" + adress + "' ,DNI='" + DNI + "' ,date='" + date
				+ "' where id=" + id +";";
	    connection.insertData(query);
	}
	
	/**
	 * 
	 * @param connection Connection with the database
	 * @param id of the client you want to delete
	 */
	public void deleteClients(SQLConnection connection,int id) {
		String query = "delete from clients where id="+id+";";
	    connection.insertData(query);
	}
	
	
	/**
	 * 
	 * @param connection Connection with the database
	 * @param name name of the client
	 * @param surname surname of the client
	 * @param adress adress of the client
	 * @param DNI  DNI of the client 
	 * @param date date of the client
	 */
	public void insertData(SQLConnection connection, String name ,String surname,String adress, int DNI, Date date ) {
		String query = "INSERT INTO clients (name, surname, adress, DNI, date) VALUES ('"+name+"','"+surname+"','"+adress+"','"+DNI+"','"+date+ ")";
	    connection.insertData(query);
	}
}

