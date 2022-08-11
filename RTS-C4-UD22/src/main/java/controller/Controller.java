package controller;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Client;
import model.SQLConnection;
import model.Video;
import view.View;

public class Controller  implements ActionListener{
	
	private Video video;
	private Client client;
	private Menu menu;
	private SQLConnection conn;
	
	public enum table {
	    Clients,
	    Videos
	}

	public table tableShowed;
	
	public Controller() {
		this.client = new Client();;
		this.menu = new Menu();
	}
	
	public void launchView() {
		//Sql connection & creation of the db and its structure
		conn = new SQLConnection();		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
		int id;
		
		switch(b.getName()) {
			case "btnClients":
				tableShowed = tableShowed.Clients;
			break;
			
			case "btnMovies":
				tableShowed = tableShowed.Videos;
				View view = new View();
				Client client = new Client();
				ControllerClient controllerClient = new ControllerClient(client, view);
			break;
			case  "btnRestoreDefaultStructure":
				resetStructure();	
			break;
			
		}
		
	}
	

	
	/**
	 * Method that creates the basic structure of this db and its structure
	 */		
	private void resetStructure() {
		conn.createDB("TA22");
		client.tableStructureCreation(conn);
		
		client.insertClient(conn, "Nico", "Basora", "C/Josep Fregos N33", 377566722,"2018-10-20");
		client.insertClient(conn, "Celestin", "Tanga", "C/Josep Fregos N31", 366522123,"2018-02-20");
		
		video.insertVideo(conn, "Homemade Spiderman 1", "Mike Scott", 1);
		video.insertVideo(conn, "Homemade Spiderman 2", "Mike Scott", 1);
		video.insertVideo(conn, "The last light", "Tarantino", 2);

	}

}
