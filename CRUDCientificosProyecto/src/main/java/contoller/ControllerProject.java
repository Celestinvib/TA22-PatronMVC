package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		view.getPanelUpdateScientist().setVisible(false);
		view.getPanelCreateScientist().setVisible(false);
		view.getPanelUpdateScientist().setVisible(false);
		view.getPanelCreateScientist().setVisible(false);
		buttonListeners();
		 
		view.getFrame().setVisible(true);
		
		loadTable(project.selectAllProjects(conn), view.getTableProjects());
	}
	

	private void loadTable(ResultSet resultSet, JTable table) {
		table.setModel(new DefaultTableModel(new Object[] {"ID", "Name", "Hours"}, 0));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model = (DefaultTableModel) table.getModel();
		
		int id, hours;
		String name;
		try {
			while(resultSet.next()) {
				id = resultSet.getInt("id");
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
		
		/**
		 * Opens Update panel
		 */
		view.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.getTableProjects().getSelectedRow() != -1) {
					view.getPanelTable().setVisible(false);
					view.getPanelUpdateProject().setVisible(true); 
					
					String name = (String) view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 1);
					String hours = (String) view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 2);
					
					view.getLblProjectNameU().setText(name);
					view.getLblProjectHoursU().setText(hours);
					
				}
			}
		});

		/**
		 * Opens Create panel
		 */
		view.getBtnCreate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelTable().setVisible(false);
				view.getPanelCreateProject().setVisible(true);
			}
		});

		/**
		 * Deletes the selected project
		 */
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.getTableProjects().getSelectedRow() != -1) {
					int id =   (int)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 0);
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the project with id " + view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 0), " ?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						project.deleteProject(conn, id);
						loadTable(project.selectAllProjects(conn), view.getTableProjects());
					}
				}
			}
		});
		
		/**
		 * Inserts a new project
		 */
		view.getBtnCreateProject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String name = view.getLblProjectNameC().getText();
				String hours = view.getLblProjectHoursC().getText();
				
				
				if(!(name.isEmpty() && hours.isEmpty())) {
					project.insertProject(conn, name, Integer.parseInt(hours));
					JOptionPane.showMessageDialog(null, "Project created.");
				    loadTable(project.selectAllProjects(conn), view.getTableProjects());
					view.getPanelCreateProject().setVisible(false);
					view.getPanelTable().setVisible(true);
					
				}
				
			}
		});
		
		/**
		 * Updates an existing project
		 */
		view.getBtnUpdateProject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 0);
				String name = (String)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 1);			
				String hours = (String)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 2);
				
				if(!(name.isEmpty() && hours.isEmpty())) {
					project.updateProject(conn, id, name, Integer.parseInt(hours));
					JOptionPane.showMessageDialog(null, "Project updated.");
					loadTable(project.selectAllProjects(conn), view.getTableProjects());
					view.getPanelUpdateProject().setVisible(false);
					view.getPanelTable().setVisible(true);
					
				}
				
			}
		});
		
		/**
		 * "Closes" the project table data menu panel and opens the main menu
		 */
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().setVisible(false);
				menu.getFrame().setVisible(true);

			}
		});
		
		/**
		 * "Closes" the panel of create project and opens the project table data menu panel
		 */
		view.getBtnBackProjectC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelCreateProject().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		/**
		 * "Closes" the panel of update project and opens the video table data menu panel
		 */
		view.getBtnBackProjectU().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelUpdateProject().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
	}		
		 
}

