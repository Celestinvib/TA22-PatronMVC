package controller;

import view.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Client;
import model.SQLConnection;
import model.Video;
import view.View;

public class Controller {
	
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
		this.client = new Client();
		this.video = new Video();
	}
	
	public void launchView() {
		//Sql connection & creation of the db and its structure
		this.conn = new SQLConnection();	
		
		if(this.conn.connection != null) { //If the user has connected to his db
			
			this.menu = new Menu(); //Creates a new view of menu
			
			buttonCalcActions(); 
			resetStructure(); //Creates a new structure of the db (Every time the app is launched)
			this.menu.getPanelMenu().setVisible(true);
		
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
		
		video.tableStructureCreation(conn);
		video.insertVideo(conn, "Homemade Spiderman 1", "Mike Scott", 1);
		video.insertVideo(conn, "Homemade Spiderman 2", "Mike Scott", 1);
		video.insertVideo(conn, "The last light", "Tarantino", 2);

	}
	
	/**
	 * Method gets all the buttons of the menu that we need a listener and adds it
	 */	
	public void buttonCalcActions() {
		
		menu.getBtnClients().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu.getFrame().setVisible(false); //Makes the menu frame invisible
				tableShowed = table.Clients; 
				
				View view = new View();
				ControllerClient controllerClient = new ControllerClient(client, view ,menu, conn);
				controllerClient.launchView();
			}
		});
		
		menu.getBtnMovies().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu.getFrame().setVisible(false);
				tableShowed = table.Videos;
				View view1 = new View();
				ControllerVideo controllerVideo= new ControllerVideo(video, view1, menu, conn);
				controllerVideo.launchView();
			}
		});

		menu.getBtnRestartDb().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				resetStructure();	
			}
		});

	}

}
