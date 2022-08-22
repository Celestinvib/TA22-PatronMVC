package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JFrame;
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
//			view.getPanelUpdateClient().setVisible(false);
//			view.getPanelCreateClient().setVisible(false);
//			view.getPanelUpdateVideo().setVisible(false);
//			view.getPanelCreateVideo().setVisible(false);
			buttonListeners();
			 
//			view.getFrame().setVisible(true);
					
//			loadTable(project.selectAllProjects(conn), view.getTableProjects());
		}
		

		private void loadTable(ResultSet resultSet, JTable table) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			model = (DefaultTableModel) table.getModel();
			
			//Id char don't really knowing how it works
			char id = '0' ; //<----- DELETE the = 0
			int IdScientist, IdProject;
			try {
				while(resultSet.next()) {
//					id = resultSet.getCharacterStream("Id");
					IdScientist = resultSet.getInt("IdScientist");
					IdProject = resultSet.getInt("IdProject");
					
					model.addRow(new Object[] {IdScientist, IdProject});
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

}
