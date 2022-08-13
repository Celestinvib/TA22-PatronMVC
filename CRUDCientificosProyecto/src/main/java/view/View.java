package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class View  extends JFrame {
	/**
	 * Attributes
	 */
	private JFrame frame;
	private JPanel panelTable;
	
	//Panel buttons JPanel & Jbuttons
	private JPanel panelButtons;
	
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnBack;
	
	//Jtables 
	private JTable tableProjects;
	private JTable tableScientists;
	private JTable tableScientistsProjects;
	
	public View ()  {
		/**
		 * Window frame
		 */
		frame  = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		panelTable = new JPanel();
		panelTable.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		panelTable.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(1, 0, 10, 0));
		
		btnBack = new JButton("Back");
		panelButtons.add(btnBack);
		
		btnUpdate = new JButton("Update");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Delete");
		panelButtons.add(btnDelete);

		btnCreate = new JButton("Add");
		panelButtons.add(btnCreate);
		
		tableScientists = new JTable();
		tableScientists = new JTable(new DefaultTableModel(new Object[] {"DNI", "nameSurname"}, 0));
		tableScientists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableProjects = new JTable();
		tableProjects = new JTable(new DefaultTableModel(new Object[] {"ID", "Name", "Hours"}, 0));
		tableProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableScientistsProjects = new JTable();
		tableScientistsProjects = new JTable(new DefaultTableModel(new Object[] {"ID", "IdScientist", "IdProject"}, 0));
		tableScientistsProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panelTable.add(new JScrollPane(tableProjects), BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(tableScientists);
		panelTable.add(scrollPane, BorderLayout.NORTH);
		
		JScrollPane scrollPane2 = new JScrollPane(tableScientistsProjects);
		panelTable.add(scrollPane2, BorderLayout.NORTH);
	}
	
	/**Getters & Setters */

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the panelTable
	 */
	public JPanel getPanelTable() {
		return panelTable;
	}

	/**
	 * @return the panelButtons
	 */
	public JPanel getPanelButtons() {
		return panelButtons;
	}

	/**
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @return the btnCreate
	 */
	public JButton getBtnCreate() {
		return btnCreate;
	}

	/**
	 * @return the btnBack
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * @return the tableProjects
	 */
	public JTable getTableProjects() {
		return tableProjects;
	}

	/**
	 * @return the tableScientists
	 */
	public JTable getTableScientists() {
		return tableScientists;
	}

	/**
	 * @return the tableScientistsProjects
	 */
	public JTable getTableScientistsProjects() {
		return tableScientistsProjects;
	}
	

	
	

}
