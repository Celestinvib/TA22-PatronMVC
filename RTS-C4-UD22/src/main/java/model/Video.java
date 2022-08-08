package model;

import java.sql.ResultSet;

public class Video {
	
	/**
	 * Method that creates the table structure of the table videos
	 * @param connection Connection  with the db
	 */
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
	
	/**
	 * Method that return all the videos stored in the db
	 * @param connection Connection with the db
	 * @return all the videos that the select has returned
	 */
	public ResultSet selectAllVideos(SQLConnection connection) {		
		String query = "select * from videos;";
	    return connection.getValues(query);
	}
	
	/**
	 * Method that return a video from the db
	 * @param connection Connection with the db
	 * @param id  id of the video from which you want to obtain the fields
	 * @return the video that the select has returned
	 */
	public ResultSet selectOneVideo(SQLConnection connection, int id) {		
		String query = "select * from videos where id="+id+";";
		
	    return connection.getValues(query);
	}
	
	
	/**
	 * Method that insert a new video to the table videos
	 * @param connection Connection with the db
	 * @param title  title of the video
	 * @param director director of the video
	 * @param cli_id  client owner of the video
	 */	
	public void insertVideo(SQLConnection connection,String title ,String director,int cli_id ) {			
		String query = "INSERT INTO videos (title, director, cli_id) VALUES ('"+title+"','"+director+"',"+cli_id+");";
	    connection.insertData(query);   
	}
	
	
	/**
	 * Method that update an existing video with new fields
	 * @param connection Connection with the db
	 * @param id  id of the video
	 * @param title  new title of the video
	 * @param director new director of the video
	 * @param cli_id  new client owner of the video
	 */	
	public void updateVideo(SQLConnection connection, int id, String title ,String director,int cli_id ) {		
		String query = "UPDATE videos set title='"+title+"', director='"+director+"' ,cli_id="+cli_id+" where id="+id+";";
	    connection.insertData(query);
	}
	
	/**
	 * Method that deletes a video from the db
	 * @param connection Connection with the db
	 * @param id  id of the video you want to delete
	 */
	public void deleteVideo(SQLConnection connection,int id) {
		String query = "delete from videos where id="+id+";";
	    connection.insertData(query);
	}
		
}