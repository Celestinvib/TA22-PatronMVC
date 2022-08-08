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

public class View extends JFrame{

	public JFrame frame;
	public JTable table;
	public JPanel panel;
	public JPanel panelButtons;
	
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnCreate;

	/**
	 * Create the application.
	 */
	public View() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panelButtons = new JPanel();
		panel.add(panelButtons, BorderLayout.SOUTH);
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
		

		panel.add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
