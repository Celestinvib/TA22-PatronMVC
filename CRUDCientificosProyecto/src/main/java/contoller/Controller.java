package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Project;
import model.SQLConnection;
import model.Scientist;
import model.ScientistsProjects;
import view.Menu;
import view.View;

public class Controller {
	private Project project;
	private Scientist scientist;
	private ScientistsProjects scientistsProjects;
	private Menu menu;
	private SQLConnection conn;
	
	public enum table {
	    Projects,
	    Scientists
	}

	public table tableShowed;
	
	public Controller() {
		this.project = new Project();
		this.scientist = new Scientist();
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
		conn.createDB("TA22-ScientistProjects");
		project.tableStructureCreation(conn);
		
		project.insertProject(conn, "Project 01", 3);
		project.insertProject(conn, "Project 02", 23);
		
		scientist.tableStructureCreation(conn);
		scientist.insertScientist(conn, "12345678", "Mike Scott");
		scientist.insertScientist(conn, "23332121", "Rafa Nadal");
		scientist.insertScientist(conn, "77789567", "Antonio Lopez");
		
		scientistsProjects.tableStructureCreation(conn);
		scientistsProjects.insertScientistsProject(conn, null, null);  //project may be int?

	}
	
	/**
	 * Method gets all the buttons of the menu that we need a listener and adds it
	 */	
	public void buttonCalcActions() {
		
		menu.getBtnProjects().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu.getFrame().setVisible(false); //Makes the menu frame invisible
				tableShowed = table.Projects; 
				
				View view = new View();
				ControllerProject controllerProject = new ControllerProject(project, view ,menu, conn);
				controllerProject.launchView();
			}
		});
		
		menu.getBtnScientists().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu.getFrame().setVisible(false);
				tableShowed = table.Scientists;
				View view1 = new View();
				ControllerScientist controllerScientist= new ControllerScientist();	//arguments left
				controllerScientist.launchView();
			}
		});
		
		menu.getBtnRestartDb().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				resetStructure();	
			}
		});

	}
}
