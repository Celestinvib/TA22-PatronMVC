package model;

import java.sql.ResultSet;

public class ScientistsProjects {
	/**	Method that creates the table scientists_projects
	 * @param connection Connection with the database
	 */
	public void tableStructureCreation(SQLConnection connection) {

		String structure  = "create table scientists_projects (ID int autoincrement, Scientist VARCHAR(8), Project int, "
				+ "CONSTRAINT FK_DNISciPro FOREIGN KEY (Scientist) REFERENCES Scientist(DNI) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "CONSTRAINT FK_IDSciPro FOREIGN KEY (Project) REFERENCES Project (Id) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ " PRIMARY KEY (ID)"
				+ ");";
		connection.insertData(structure);
		
		}
	
	/**	Method that return all the scientists_projects stored in the database
	 * @param connection Connection with the database
	 * @return all the scientists_projects that the select has returned
	 */
	public ResultSet selectAllScientistsProjects(SQLConnection connection) {		
		String query = "select * from scientists_projects;";
		return connection.getValues(query);
	}
	
	/**
	 * Method that return a project from the database
	 * @param connection Connection with the database
	 * @param Id
	 * @return the scientists_projects that the select has returned
	 */
	public ResultSet selectOneScientistsProjects(SQLConnection connection, String Id) {		
		String query = "select * from scientists_projects where Id='"+Id+"';";
		return connection.getValues(query);
	}
	
	/**
	 *  Method that update an existing scientists_projects with new fields
	 * @param connection
	 * @param Id
	 * @param name
	 * @param hours
	 */
	public void updateScientistsProjects(SQLConnection connection, String scientist, String project) {		
		String query = "UPDATE scientists_projects set scientist='" + scientist + "', project=" + project + "';";
	    connection.insertData(query);
	}
	
	/**
	 * 
	 * @param connection
	 * @param Id
	 */
	public void deleteScientistsProjects(SQLConnection connection, int Id) {
		String query = "delete from scientists_projects where Id="+Id+";";
	    connection.insertData(query);
	}
	
	
	/**
	 * 
	 * @param connection
	 * @param scientist
	 * @param project
	 */
	public void insertScientistsProject(SQLConnection connection, String scientist, String project  ) {
		String query = "INSERT INTO scientists_projects (sientist, project) VALUES ('" + scientist + "','" + project + ");";
	    connection.insertData(query);
	}
}
