package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Video {
	
	public void tableStructureCreation(SQLConnection connection) {		
		String structure  = "create table videos ("
				+ "	id int(11) NOT NULL AUTO_INCREMENT,"
				+ "    title varchar(250) DEFAULT NULL,"
				+ "    director varchar(250) DEFAULT NULL,"
				+ "    cli_id int(11) DEFAULT NULL,"
				+ "    PRIMARY KEY (id),"
				+ "    CONSTRAINT videos_fk FOREIGN KEY (cli_id) REFERENCES cliente (id)"
				+ ");";
		connection.insertData(structure);
	}
	
	public ResultSet selectAllVideos(SQLConnection connection) {		
		String query = "select * from videos;";
	    return connection.getValues(query);
	}
	
	public ResultSet selectOneVideo(SQLConnection connection, String id) {		
		String query = "select * from videos where id="+id+";";
		
	    return connection.getValues(query);
	}
	
	public void updateVideo(SQLConnection connection, String id, String title ,String director,String cli_id ) {		
		String query = "UPDATE videos set title="+title+", director="+director+" ,cli_id="+cli_id+" where id="+id+";";
	    connection.insertData(query);
	}
	
	public void deleteVideo(SQLConnection connection,String id) {
		String query = "delete from videos where id="+id+";";
	    connection.insertData(query);
	}
		
}