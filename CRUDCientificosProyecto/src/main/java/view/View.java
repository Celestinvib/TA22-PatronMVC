package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View  extends JFrame {
	
	public JFrame frame;
	public JPanel panelTable;
	
	public View ()  {
		/**
		 * Window frame
		 */
		frame  = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Main panel with the table and CRUD options
		 */
		panelTable = new JPanel();
		panelTable.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
	}

}
