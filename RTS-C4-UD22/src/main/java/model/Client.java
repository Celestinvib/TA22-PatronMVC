package model;

import java.sql.ResultSet;

public class Client {
	
	public void tableStructureCreation(SQLConnection connection) {		
		String structure  = "create table videos ("
				+ "	id int(11) NOT NULL AUTO_INCREMENT,"
				+ " nombre varchar(250) DEFAULT NULL,"
				+ " apellido varchar(250) DEFAULT NULL,"
				+ " direccion varchar(250) DEFAULT NULL,"
				+ " fecha date DEFAULT NULL,"
				+ " PRIMARY KEY (id)"
				+ ");";
		connection.insertData(structure);
	}
	
	public ResultSet selectAllClients(SQLConnection connection) {		
		String query = "select * from clients;";
		return connection.getValues(query);
	}
	
	public ResultSet selectOneClients(SQLConnection connection, int id) {		
		String query = "select * from clients where id="+id+";";
		return connection.getValues(query);
	}
	
	public void updateClients(SQLConnection connection, int id, String name ,String surname,String adress, String date) {		
		String query = "UPDATE clients set nombre='" + name + "', apellido='" + surname + "' ,direccion='" + adress + "' ,fecha='" + date
				+ "' where id=" + id +";";
	    connection.insertData(query);
	}
	
	public void deleteClients(SQLConnection connection,int id) {
		String query = "delete from clients where id="+id+";";
	    connection.insertData(query);
	}
	
	
	}

