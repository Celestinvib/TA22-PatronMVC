package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.SQLConnection;
import model.ScientistsProjects;
import view.Menu;
import view.View;

	public class ControllerScientistProjects {
		private ScientistsProjects scientistsProjects;
		private View view;
		private SQLConnection conn;
		private Menu menu;
		
		
		public ControllerScientistProjects(ScientistsProjects scientistsProjects, View view ,Menu menu, SQLConnection SqlCon) {
			this.scientistsProjects = scientistsProjects;
			this.view = view;
			this.menu = menu;
			this.conn = SqlCon;
			
		}
		
		public void launchView() {
			view.setTitle("ScientistsProjects");
			view.pack();
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setLocationRelativeTo(null);
			view.getPanelUpdateScientist().setVisible(false);
			view.getPanelCreateScientist().setVisible(false);
			view.getPanelUpdateProject().setVisible(false);
			view.getPanelCreateProject().setVisible(false);
			view.getPanelUpdateScientistProject().setVisible(false);
			view.getPanelCreateScientistProject().setVisible(false);
			buttonListeners();
			 
			view.getFrame().setVisible(true);
					
			loadTable(scientistsProjects.selectAllScientistsProjects(conn), view.getTableProjects());
		}
		

		private void loadTable(ResultSet resultSet, JTable table) {
			table.setModel(new DefaultTableModel(new Object[] {"ID", "DNI_Scientist", "Id_Project"}, 0));
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			model = (DefaultTableModel) table.getModel();
			

			int id, IdProject;
			String dni;
			try {
				while(resultSet.next()) {
					id = resultSet.getInt("id");
					dni = resultSet.getString("Scientist");
					IdProject = resultSet.getInt("Project");
					
					model.addRow(new Object[] {id,dni, IdProject});
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
						view.getPanelUpdateScientistProject().setVisible(true);
						
						String DNI = (String) view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 1);
						int id =  (int)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 2);
						
						view.getTextFieldDNIU().setText(DNI);
						view.getTextFieldIdU().setText(String.valueOf(id));

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
					view.getPanelCreateScientistProject().setVisible(true);
				}
			});

			/**
			 * Deletes the selected scientists projects
			 */
			view.getBtnDelete().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(view.getTableProjects().getSelectedRow() != -1) {
						int Id = (int)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 0);
						if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the scientistsProjects with ID: " + view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 0), "ARE YOU SURE?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							scientistsProjects.deleteScientistsProjects(conn, Id);
							loadTable(scientistsProjects.selectAllScientistsProjects(conn), view.getTableProjects());
						}
					}
				}
			});
			
			/**
			 * Inserts a new scientists projects
			 */
			view.getBtnCreateScientistProject().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String DNI = view.getTextFieldDNIeC().getText();
					String Id = view.getTextFieldIdC().getText();
					
					
					if(!(DNI.isEmpty() && Id.isEmpty())) {
						scientistsProjects.insertScientistsProject(conn, DNI, Integer.parseInt(Id));
						JOptionPane.showMessageDialog(null, "Scientist assigned to a project.");
						loadTable(scientistsProjects.selectAllScientistsProjects(conn), view.getTableProjects());
						view.getPanelCreateScientistProject().setVisible(false);
						view.getPanelTable().setVisible(true);
						
					}
					
				}
			});
			
			/**
			 * Updates an existing scientists projects
			 */
			view.getBtnUpdateScientistProject().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					int id = (int)view.getTableProjects().getValueAt(view.getTableProjects().getSelectedRow(), 0);
					
					String DNI = view.getTextFieldDNIU().getText();
					String project_d = view.getTextFieldIdU().getText();
					
					if(!(DNI.isEmpty() && project_d.isEmpty())) {
						scientistsProjects.updateScientistsProjects(conn,id, DNI, Integer.parseInt(project_d));
						JOptionPane.showMessageDialog(null, "Scientist assigned to a project. Cliente updated.");
						loadTable(scientistsProjects.selectAllScientistsProjects(conn), view.getTableProjects());
						view.getPanelCreateScientistProject().setVisible(false);
						view.getPanelTable().setVisible(true);
						
					}
					
				}
			});
			
			/**
			 * "Closes" the scientists projects table data menu panel and opens the main menu
			 */
			view.getBtnBack().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					view.getFrame().setVisible(false);
					menu.getFrame().setVisible(true);

				}
			});
			
			/**
			 * "Closes" the panel of create scientists projects and opens the video table data menu panel
			 */
			view.getBtnBackScientistProjectC().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					view.getPanelCreateScientistProject().setVisible(false);
					view.getPanelTable().setVisible(true);
				}
			});
			
			/**
			 * "Closes" the panel of update scientists projects and opens the video table data menu panel
			 */
			view.getBtnBackScientistProjectU().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					view.getPanelUpdateScientistProject().setVisible(false);
					view.getPanelTable().setVisible(true);
				}
			}); 
		}
	}
