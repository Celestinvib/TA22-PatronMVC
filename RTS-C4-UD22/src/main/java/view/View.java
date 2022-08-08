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

public class View {

	private JFrame frame;
	private JTable table;



	/**
	 * Create the application.
	 */
	public View() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		panel.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(1, 0, 10, 0));
		
		JButton btnUpdate = new JButton("Actualizar");
		panelButtons.add(btnUpdate);

		JButton btnDelete = new JButton("Borrar");
		panelButtons.add(btnDelete);

		JButton btnCreate = new JButton("Crear");
		panelButtons.add(btnCreate);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		panel.add(new JScrollPane(table), BorderLayout.CENTER);
	}

}
