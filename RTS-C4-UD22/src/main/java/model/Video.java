package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Video {
	/** Attributes */
	private int id;
	
	private String title;
	
	private String director;
	
	private int cli_id;

	/**
	 * Constructor
	 * @param id
	 * @param title
	 * @param director
	 * @param cli_id
	 */
	public Video(String title, String director, int cli_id) {
		this.title = title;
		this.director = director;
		this.cli_id = cli_id;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the cli_id
	 */
	public int getCli_id() {
		return cli_id;
	}

	/**
	 * @param cli_id the cli_id to set
	 */
	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}
	
	
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
	
	public void selectAllVideos(SQLConnection connection) {		
		String query = "select * from videos;";
//	    connection.insertData(query);
	}
	
	public void selectOneVideo(SQLConnection connection, String id) {		
		String query = "select * from videos where id="+id+";";
//	    connection.insertData(query);
	}
	
	public void updateVideo(SQLConnection connection, String id, String title ,String director,String cli_id ) {		
		String query = "select * from videos where id="+id+";";
	    connection.insertData( query);
	}
	
	public void deleteVideo(SQLConnection connection,String id) {
		String query = "delete from videos where id="+id+";";
	    connection.insertData(query);
	}
	
	
	
	
}