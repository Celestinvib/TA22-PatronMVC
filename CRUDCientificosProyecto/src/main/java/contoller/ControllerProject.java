package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Project;
import model.SQLConnection;
import view.Menu;
import view.View;

public class ControllerProject {
	private Project project;
	private View view;
	private SQLConnection conn;
	private Menu menu;
	
	
	public ControllerProject(Project project, View view ,Menu menu, SQLConnection SqlCon) {
		this.project = project;
		this.view = view;
		this.menu = menu;
		this.conn = SqlCon;
		
	}
	
	public void launchView() {
		view.setTitle("Projects");
		view.pack();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
//		view.getPanelUpdateClient().setVisible(false);
//		view.getPanelCreateClient().setVisible(false);
//		view.getPanelUpdateVideo().setVisible(false);
//		view.getPanelCreateVideo().setVisible(false);
		buttonListeners();
		 
//		view.getFrame().setVisible(true);
				
//		loadTable(project.selectAllProjects(conn), view.getTableProjects());
	}
	

	private void loadTable(ResultSet resultSet, JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model = (DefaultTableModel) table.getModel();
		
		//Id char don't really knowing how it works
		char id = '0' ; //<----- DELETE the = 0 
		String name;
		int hours;
		try {
			while(resultSet.next()) {
//				id = resultSet.getCharacterStream("Id");
				name = resultSet.getString("name");
				hours = resultSet.getInt("hours");
				
				model.addRow(new Object[] {id, name, hours});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Method gets all the buttons of the menu that we need a listener and adds it
	 */	
	public void buttonListeners() {
		
		 
	}
}
