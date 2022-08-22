package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.SQLConnection;
import model.Scientist;
import view.Menu;
import view.View;

public class ControllerScientist {
	private Scientist scientist;
	private View view;
	private SQLConnection conn;
	private Menu menu;
	
	//
	
	
	/**
	 * 
	 */
	public ControllerScientist() {
	}

	/**
	 * @param scientist
	 * @param view
	 * @param conn
	 * @param menu
	 */
	public ControllerScientist(Scientist scientist, View view, SQLConnection conn, Menu menu) {
		this.scientist = scientist;
		this.view = view;
		this.conn = conn;
		this.menu = menu;
	}

	/**
	 * Hides any other panel or view and makes and displays the main table
	 */
	public void launchView() {
		view.getFrame().setTitle("Scientists");
		view.pack();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.getPanelUpdateScientist().setVisible(false);
		view.getPanelCreateScientist().setVisible(false);
		view.getPanelUpdateScientist().setVisible(false);
		view.getPanelCreateScientist().setVisible(false);
		buttonListeners();
		 
		view.getFrame().setVisible(true);
				
		loadTable(scientist.selectAllScientists(conn), view.getTableScientists());
		
	}
	
	/**
	 * Sets table model and inserts the data in the table
	 * @param resultSet
	 * @param table
	 */
	private void loadTable(ResultSet resultSet, JTable table) {
		table.setModel(new DefaultTableModel(new Object[] {"DNI", "NameSurname"}, 0));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model = (DefaultTableModel) table.getModel();
		String dni, namesurname;
		try {
			while(resultSet.next()) {
				dni = resultSet.getString("dni");
				namesurname = resultSet.getString("namesurname");

				model.addRow(new Object[] {dni, namesurname});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void buttonListeners() {
		
		/**
		 * Opens Update panel
		 */
		view.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.getTableScientists().getSelectedRow() != -1) {
					view.getPanelTable().setVisible(false);
					view.getPanelUpdateScientist().setVisible(true);
					
					String name = (String) view.getTableScientists().getValueAt(view.getTableScientists().getSelectedRow(), 1);
					
					view.getTextFieldScientistNameU().setText(name);
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
				view.getPanelCreateScientist().setVisible(true);
			}
		});

		/**
		 * Deletes the selected scientist
		 */
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.getTableScientists().getSelectedRow() != -1) {
					String id = (String)view.getTableScientists().getValueAt(view.getTableScientists().getSelectedRow(), 0);
					if(JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar al scientiste con dni " + view.getTableScientists().getValueAt(view.getTableScientists().getSelectedRow(), 0), "SEGURO?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						scientist.deleteScientist(conn, id);
						loadTable(scientist.selectAllScientists(conn), view.getTableScientists());
					}
				}
			}
		});
		
		/**
		 * Inserts a new scientist
		 */
		view.getBtnCreateScientist().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dni = view.getTextFieldDNIC().getText();
				String name = view.getTextFieldScientistNameC().getText();
				
				
				if(!(name.isEmpty() && dni.isEmpty())) {
					scientist.insertScientist(conn, dni, name);
					JOptionPane.showMessageDialog(null, "Scientist creado.");
					loadTable(scientist.selectAllScientists(conn), view.getTableScientists());
					view.getPanelCreateScientist().setVisible(false);
					view.getPanelTable().setVisible(true);
					
				}
				
			}
		});
		
		/**
		 * Updates an existing scientist
		 */
		view.getBtnUpdateScientist().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String)view.getTableScientists().getValueAt(view.getTableScientists().getSelectedRow(), 0);
				
				String name = view.getTextFieldScientistNameU().getText();
				
				if(!(name.isEmpty() && dni.isEmpty())) {
					scientist.updateScientist(conn, dni, name);
					JOptionPane.showMessageDialog(null, "Scientiste actualizado.");
					loadTable(scientist.selectAllScientists(conn), view.getTableScientists());
					view.getPanelCreateScientist().setVisible(false);
					view.getPanelTable().setVisible(true);
					
				}
				
			}
		});
		
		/**
		 * "Closes" the scientists table data menu panel and opens the main menu
		 */
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().setVisible(false);
				menu.getFrame().setVisible(true);

			}
		});
		
		/**
		 * "Closes" the panel of create scientist and opens the video table data menu panel
		 */
		view.getBtnBackScientistC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelCreateScientist().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		/**
		 * "Closes" the panel of update scientist and opens the video table data menu panel
		 */
		view.getBtnBackScientistU().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelUpdateScientist().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
	}
}
