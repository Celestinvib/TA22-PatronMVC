package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import javax.swing.JSeparator;

public class View extends JFrame{

	public JFrame frame;
	public JTable table;
	public JPanel panelTable;
	public JPanel panelButtons;
	
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnCreate;

	JPanel panelUpdate;
	JPanel panelCreate;
	private JPanel panel;
	private JTable tableUpdate;
	JButton btnUpdateData;
	private JButton btnCreateData;
	
	/**
	 * Create the application.
	 */
	public View() {
		/**
		 * Window frame
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Main panel with the table and CRUD options
		 */
		panelTable = new JPanel();
		panelTable.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		panelButtons = new JPanel();
		panelTable.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(1, 0, 10, 0));
		
		btnUpdate = new JButton("Actualizar");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Borrar");
		panelButtons.add(btnDelete);

		btnCreate = new JButton("Crear");
		panelButtons.add(btnCreate);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		panelTable.add(new JScrollPane(table), BorderLayout.CENTER);
		
		
		/**
		 * Update panel
		 */
		panelUpdate = new JPanel();
		panelUpdate.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelUpdate);
		panelUpdate.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 0, 395, 56);
		panelUpdate.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tableUpdate = new JTable();
		panel.add(tableUpdate);
		
		btnUpdateData = new JButton("Actualizar");
		btnUpdateData.setBounds(10, 210, 90, 20);
		panelUpdate.add(btnUpdateData);
		
		/**
		 * Create panel
		 */
		panelCreate = new JPanel();
		panelCreate.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelCreate);
		panelCreate.setLayout(null);
		
		btnCreateData = new JButton("Crear");
		btnCreateData.setBounds(10, 210, 90, 20);
		panelCreate.add(btnCreateData);
	}
}
