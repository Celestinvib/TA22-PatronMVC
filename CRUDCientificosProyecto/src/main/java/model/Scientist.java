package model;

import java.sql.ResultSet;

import contoller.SQLConnection;

public class Scientist {
	public void tableStructureCreation(SQLConnection connection) {

		String structure  = "create table scientists ("
				+ "	DNI varchar(8),"
				+ " nameSurname varchar(255),"
				+ " PRIMARY KEY (DNI)"
				+ ");";
		connection.insertData(structure);
	}
	
	/**	that return all the scientists stored in the database
	 * @param connection Connection with the database
	 * @return all the scientists that the select has returned
	 */
	public ResultSet selectAllScientists(SQLConnection connection) {		
		String query = "select * from scientists;";
		return connection.getValues(query);
	}
	
	/**
	 * Method that return a scientist from the database
	 * @param connection Connection with the database
	 * @param DNI of the scientist from which you want to obtain the fields
	 * @return
	 */
	public ResultSet selectOneScientist(SQLConnection connection, String DNI) {		
		String query = "select * from scientists where DNI='"+DNI+"';";
		return connection.getValues(query);
	}
	
	/**
	 * 
	 * @param connection Connection with the database
	 * @param DNI DNI of the scientist
	 * @param nameSurname name & last name of the scientist
	 */
	public void updateScientist(SQLConnection connection, String DNI ,String nameSurname) {		
		String query = "UPDATE scientists set DNI='" + DNI + "', nameSurname='" + nameSurname+ ";";
	    connection.insertData(query);
	}
	
	/**
	 * 
	 * @param connection Connection with the database
	 * @param DNI of the scientist you want to delete
	 */
	public void deleteScientist(SQLConnection connection, String DNI) {
		String query = "delete from scientists where id="+DNI+";";
	    connection.insertData(query);
	}
	
	
	/**
	 * 
	 * @param connection Connection with the database
	 * @param DNI DNI of the scientist
	 * @param nameSurname name & last name of the scientist
	 */
	public void insertScientist(SQLConnection connection, String DNI ,String nameSurname ) {
		String query = "INSERT INTO scientists (DNI, nameSurname) VALUES ('"+DNI+"','"+nameSurname+"')";
	    connection.insertData(query);
	}
}
