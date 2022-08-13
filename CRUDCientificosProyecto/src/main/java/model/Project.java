package model;

import java.sql.ResultSet;

public class Project {
	
	/**	Method that creates the table projects
	 * @param connection Connection with the database
	 */
	public void tableStructureCreation(SQLConnection connection) {

		String structure  = "create table projects ("
				+ "	Id char(4),"
				+ " name varchar(255),"
				+ " hours int,"
				+ " PRIMARY KEY (Id)"
				+ ");";
		connection.insertData(structure);
	}
	
	/**	Method that return all the projects stored in the database
	 * @param connection Connection with the database
	 * @return all the projects that the select has returned
	 */
	public ResultSet selectAllProjects(SQLConnection connection) {		
		String query = "select * from projects;";
		return connection.getValues(query);
	}
	
	/**
	 * Method that return a project from the database
	 * @param connection Connection with the database
	 * @param DNI of the scientist from which you want to obtain the fields
	 * @return the project that the select has returned
	 */
	public ResultSet selectOneProject(SQLConnection connection, char Id) {		
		String query = "select * from projects where Id='"+Id+"';";
		return connection.getValues(query);
	}
	
	/**
	 *  Method that update an existing project with new fields
	 * @param connection Connection with the database
	 * @param Id Id of the project
	 * @param name name of the project
	 * @param hours duration on hours of the project
	 */
	public void updateProject(SQLConnection connection,char Id, String name ,int hours) {		
		String query = "UPDATE projects set name='" + name + "', hours=" + hours+ " where Id='"+Id+"';";
	    connection.insertData(query);
	}
	
	/**
	 * Method that deletes a project from the db
	 * @param connection Connection with the database
	 * @param Id of the project you want to delete
	 */
	public void deleteProject(SQLConnection connection, char Id) {
		String query = "delete from projects where Id="+Id+";";
	    connection.insertData(query);
	}
	
	
	/**
	 * Method that insert a new project to the table projects
	 * @param connection Connection with the database
	 * @param Id Id of the project
	 * @param name name of the project
	 * @param hours duration on hours of the project
	 */
	public void insertProject(SQLConnection connection, char Id ,String name, int hours  ) {
		String query = "INSERT INTO projects (Id, name, hours ) VALUES ('"+Id+"','"+name+"',"+hours+");";
	    connection.insertData(query);
	}
}
