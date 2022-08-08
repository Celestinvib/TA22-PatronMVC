package model;

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
	
	public void selectAllClients(SQLConnection connection) {		
		String query = "select * from clients;";
//	    connection.insertData(query);
	}
	
	public void selectOneClients(SQLConnection connection, String id) {		
		String query = "select * from clients where id="+id+";";
//	    connection.insertData(query);
	}
	
	public void updateClients(SQLConnection connection, String id, String title ,String director,String cli_id ) {		
		String query = "select * from clients where id="+id+";";
	    connection.insertData(query);
	}
	
	public void deleteClients(SQLConnection connection,String id) {
		String query = "delete from clients where id="+id+";";
	    connection.insertData(query);
	}
	
	
	}

